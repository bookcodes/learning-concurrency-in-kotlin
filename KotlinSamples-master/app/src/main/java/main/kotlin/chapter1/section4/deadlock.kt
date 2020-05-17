package main.kotlin.chapter1.section4

import kotlinx.coroutines.*

lateinit var jobA : Job
lateinit var jobB : Job

// This will never complete execution.
fun main(args: Array<String>) = runBlocking {
    jobA = launch {
        delay(1000)
        // wait for JobB to finish
        jobB.join()
    }

    jobB = launch {
        // wait for JobA to finish
        jobA.join()
    }

    // wait for JobA to finish
    jobA.join()
    println("Finished")
}