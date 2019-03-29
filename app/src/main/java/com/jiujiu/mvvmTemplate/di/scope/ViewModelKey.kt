package com.jiujiu.mvvmTemplate.di.scope

import androidx.lifecycle.ViewModel

import dagger.MapKey
import kotlin.reflect.KClass

@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
