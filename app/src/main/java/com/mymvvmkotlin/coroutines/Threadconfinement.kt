package com.mymvvmkotlin.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/*Thread confinement
All accès to shared data is confined to a single thread
Fine-grained - each individual increment switches context much slower*/

// confined way
fun main() {
    runBlocking {
        var counter = 0
        withContext(Dispatchers.Default) {
            massiveRunThreads { counter++ }
        }
        println("Counter = $counter");
    }
}

suspend fun massiveRunThreads(action: suspend () -> Unit) {
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

// coarse-grained
fun main0() {
    runBlocking {
        val counterContext = newSingleThreadContext("CounterContext")
        var counter = 0
        withContext(counterContext) {
            massiveRunThreads {
                counter++
            }
        }
        println("Counter = $counter");
    }
}

