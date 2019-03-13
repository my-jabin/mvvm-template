# mvvm-template
A template for quickly building a project that implements MVVM architecture by using Room, Dagger2, RxJava2, Data Binding.

## How to use it
1. Add/Modify your entities class. In the template, there is only a `User` entity. Add your own entity. Then create a corresponding `Dao` and `Repository` class, add `Dao` to `AppDatabase` class.
2. Dependency injection:
    * Your activities need to be added in the `ActivityBuilder` class.
    * Your `ViewModel` class need to be added in the `ViewModelModule` class.
    * If any application associated dependencies is required, could be provided in the `AppModule` class
    * Any activity associated dependencies could be provided in the `xxxActivityModule` class
3. Change the UI components.


## Dagger 2
* `@Inject`: Basically with this annotation we request dependencies. In other words, you use it to tell Dagger that the annotated class or field wants to participate in dependency injection. Thus, Dagger will construct instances of this annotated classes and satisfy their dependencies.

* `@Module`: Modules are classes whose methods provide dependencies, so we define a class and annotate it with @Module, thus, Dagger will know where to find the dependencies in order to satisfy them when constructing class instances. One important feature of modules is that they have been designed to be partitioned and composed together (for instance we will see that in our apps we can have multiple composed modules).

* `@Provide`: Inside modules we define methods containing this annotation which tells Dagger how we want to construct and provide those mentioned dependencies.

* `@Component`: Components basically are injectors, let’s say a bridge between @Inject and @Module, which its main responsibility is to put both together. They just give you instances of all the types you defined, for example, we must annotate an interface with @Component and list all the @Modules that will compose that component, and if any of them is missing, we get errors at compile time. All the components are aware of the scope of dependencies it provides through its modules.

* `@Scope`: Scopes are very useful and Dagger 2 has has a more concrete way to do scoping through custom annotations. We will see an example later, but this is a very powerful feature, because as pointed out earlier, there is no need that every object knows about how to manage its own instances. An scope example would be a class with a custom @PerActivity annotation, so this object will live as long as our Activity is alive. In other words, we can define the granularity of your scopes (@PerFragment, @PerUser, etc).

* `@Qualifier`: We use this annotation when the type of class is insufficient to identify a dependency. For example in the case of Android, many times we need different types of context, so we might define a qualifier annotation @ForApplication and @ForActivity, thus when injecting a context we can use those qualifiers to tell Dagger which type of context we want to be provided.

---

In the `AppComponent` class
``` java
@Singleton
@Component(modules = {AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(MvvmApp app);

}
```

* `AndroidInjectionModule`. The description of this module from official document is:
 ```
/**
 * Contains bindings to ensure the usability of {@code dagger.android} framework classes. This
 * module should be installed in the component that is used to inject the {@link
 * android.app.Application} class.
 */
```

* `ActivityBuilder` class is a customized module. We map all activities here, tell Dagger all of our activities in compile time

* `AppModule` class provides global dependencies. Like retrofit, okhttp, persitence db etc.

---

#### Map Multibindings

Dagger lets you use multibindings to contribute entries to an injectable map as long as the map keys are known at compile time.

To contribute an entry to a multibound map, add a method to a module that returns the value and is annotated with @IntoMap and with another custom annotation that specifies the map key for that entry.
``` java
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashActivityViewModel.class)
    abstract ViewModel bindsSplashActivityViewModel(SplashActivityViewModel settingsActivityViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    abstract ViewModel bindsMainActivityViewModel(MainActivityViewModel mainActivityViewModel);
}
```
In the above example, two `ViewModel` are added into a map with the structure `(Map<K, Provider<V>>).`, where key is a customized key annotated with `@ViewModelKey`, valus is a `Provider`
``` java
@Retention(RetentionPolicy.RUNTIME)
@MapKey
public @interface ViewModelKey {
    Class<? extends ViewModel> value();
}
```

Annotation `@Binds` is similar to `@Provides`. Simply put, the difference is `@Provides` return a concrete instance, while `@Binds` return an interface

---

#### Annotation `@ContributesAndroidInjector`
Dagger Android introduced an annotation which can reduce the `Component` `Binds` `IntoSet` `Subcomponent` `ActivityKey` `FragmentKey` etc. boilerplate for you.
``` java
@Module
public abstract class ActivityBuilder {
    // @ContributesAndroidInjector(modules = SplashActivityModule.class)
    // SplashActivityModule provides the dependencies specific to the SplashActivity
    @ContributesAndroidInjector()
    abstract SplashActivity bindsSplashActivity();

    // some other activity
}
```

`ActivityBuilder` tells Dagger all activities in the compile time. Using `@ContributesAndroidInjector`, Dagger generates automatically the following code for us.

``` java
@Module(subcomponents = ActivityBuilder_BindsSplashActivity.SplashActivitySubcomponent.class)
public abstract class ActivityBuilder_BindsSplashActivity {
  private ActivityBuilder_BindsSplashActivity() {}

  @Binds
  @IntoMap
  @ActivityKey(SplashActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      SplashActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface SplashActivitySubcomponent extends AndroidInjector<SplashActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SplashActivity> {}
  }
}
```


Thanks to:
 * [The New Dagger 2 Android Injector](https://blog.mindorks.com/the-new-dagger-2-android-injector-cbe7d55afa6a)
 * [Tasting Dagger 2 on Android](https://fernandocejas.com/2015/04/11/tasting-dagger-2-on-android/)
