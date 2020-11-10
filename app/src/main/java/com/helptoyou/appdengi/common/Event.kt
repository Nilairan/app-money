package com.helptoyou.appdengi.common

sealed class Event<T>
class Success<T>(val data: T) : Event<T>()
class Loading<T> : Event<T>()
class Error<T> : Event<T>()