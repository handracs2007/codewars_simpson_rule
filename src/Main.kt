import kotlin.math.pow
import kotlin.math.sin

// https://www.codewars.com/kata/565abd876ed46506d600000d/train/kotlin

fun func(x: Double): Double {
    return 3.0 / 2.0 * sin(x).pow(3.0)
}

fun simpson(n: Int): Double {
    val a = 0.0
    val b = Math.PI
    val h = (b - a) / n.toDouble()

    val fa = func(a)
    val fb = func(b)

    // Calculate with i = 1 until n/2
    var sumFirst = 0.0
    for (i in 1..(n / 2)) {
        val param = a + (2 * i.toDouble() - 1.toDouble()) * h
        sumFirst += func(param)
    }
    sumFirst *= 4.0

    // Calculate with i = 1 to (n/2 - 1)
    var sumSecond = 0.0
    for (i in 1 until n / 2) {
        val param = a + 2.0 * i.toDouble() * h
        sumSecond += func(param)
    }
    sumSecond *= 2

    // Get the final result
    return (b - a) / (3.0 * n.toDouble()) * (fa + fb + sumFirst + sumSecond)
}

fun main() {
    println(simpson(290))
    println(simpson(72))
}