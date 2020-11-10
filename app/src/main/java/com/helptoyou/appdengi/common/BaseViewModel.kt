package com.helptoyou.appdengi.common

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver

import androidx.lifecycle.ViewModel
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
abstract class BaseViewModel : ViewModel(), KoinComponent, LifecycleObserver {

    fun addLifecycleObserver(lifecycle: Lifecycle) {
        lifecycle.addObserver(this)
    }
}