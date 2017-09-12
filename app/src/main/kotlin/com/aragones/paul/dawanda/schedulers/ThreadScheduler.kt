package com.aragones.paul.dawanda.schedulers

import rx.Observable

interface ThreadScheduler {
    fun <T> compose(): Observable.Transformer<T, T>
}