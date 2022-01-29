package com.mymvvmkotlin.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.system.measureTimeMillis

/*Mutual exclusion locks
A mutual exclusion lock (mutex) locks access to a sensitive part of code.*/

fun main() {
    runBlocking {
        var mutex = Mutex()
        var counter = 0
        withContext(Dispatchers.Default) {
            massiveRunMutex {
                mutex.withLock {
                    counter++
                }
            }
        }
        println("Counter = $counter")
    }
}

suspend fun massiveRunMutex(action: suspend () -> Unit) {
    val n = 100
    val k = 1000
    val time = measureTimeMillis {
        coroutineScope {
            repeat(n) {
                launch {
                    repeat(k) {
                        action()
                    }
                }
            }
        }
    }
}

