package com.example.core

import androidx.lifecycle.ViewModel
import kotlin.reflect.KClass
import dagger.MapKey

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)