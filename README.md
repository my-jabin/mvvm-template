# mvvm-template
A template for quickly building a project that implements MVVM architecture by using Room, Dagger2, RxJava2, Data Binding.

## Place want to modify:
1. Your 'model', `Dao` and `repository` class. In this template is the `User`, `UserDao` and `UserRepository`.
2. Dependency injection:
    * Your activities need to be injected in the `ActivityBuilder` class.
    * Your `ViewModel` class need to be injected in the `ViewModelModule` class.
    * If any app associated dependencies is required, could be provided in the `AppModule` class
    * Any activity associated dependencies could be provided in the `xxxActivityModule` class
3. UI component.
