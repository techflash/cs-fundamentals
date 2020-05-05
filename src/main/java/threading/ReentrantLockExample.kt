package threading

import java.util.*
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock

internal class Shared {
    var count = 0
    var reentrantLock = ReentrantLock()
    var condition: Condition = reentrantLock.newCondition()
    private fun increment() {
        println("current thread:  " + Thread.currentThread().name)
        for (i in 0..4999) {
            count++
        }
    }

    @Throws(InterruptedException::class)
    fun incrementFirst() {
        reentrantLock.lock()
        println("waiting...")
        condition.await()
        println("got signal... ")
        try {
            increment()
            condition.signal()
        } finally {
            reentrantLock.unlock()
        }
    }

    @Throws(InterruptedException::class)
    fun incrementSecond() {
        reentrantLock.lock()
        val scanner = Scanner(System.`in`)
        println("Enter any key")
        scanner.next()
        println("releasing signal..")
        condition.signal()
        try {
            increment()
            condition.await()
        } finally {
            reentrantLock.unlock()
        }
    }

    fun showResult() {
        println("count : $count")
    }
}

object ReentrantLockExample {
    @JvmStatic
    fun main(args: Array<String>) {
        val p = Shared()
        val t1 = Thread(Runnable {
            try {
                p.incrementFirst()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }, "t1")
        val t2 = Thread(Runnable {
            try {
                p.incrementSecond()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }, "t2")
        t1.start()
        t2.start()
        try {
            t1.join()
            t2.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        p.showResult()
    }
}