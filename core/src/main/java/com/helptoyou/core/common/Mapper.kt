package com.helptoyou.core.common

interface Mapper<T, R> {

    fun map(value: T): R
}