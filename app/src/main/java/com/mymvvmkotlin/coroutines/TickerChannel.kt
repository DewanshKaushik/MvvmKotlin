package com.mymvvmkotlin.coroutines

import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main (){

    runBlocking{
        val tickerChannel=ticker(100)
        val startTime=System.currentTimeMillis()
        tickerChannel.consumeEach {
            val delta =System.currentTimeMillis()-startTime
            println("Received tick after $delta")
        }
    delay(1000)
    println("Done")
    tickerChannel.cancel();
}
}