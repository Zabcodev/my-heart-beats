package com.zabcoding.myheartbeats.utils

import co.yml.charts.common.model.Point
import kotlin.math.sin
import kotlin.random.Random

fun generateEcgData(): List<Point> {

    val ecgData = mutableListOf<Point>()

    for (i in 0 until 150) {
        val xValue = i.toFloat()
        val yValue = generateEcgValue(xValue)
        ecgData.add(Point(xValue, yValue))
    }
    return ecgData
}

private fun generateEcgValue(xValue: Float): Float {
    val baseAmplitude = 1f
    val frequency = 0.5f
    val phasesShift = 0f

    val signal = baseAmplitude * sin(2 * Math.PI * frequency * xValue + phasesShift).toFloat()
    return signal + randomNoise()
}

private fun randomNoise(): Float {
    val noiseAmplitude = 0.1f
    return Random.nextFloat() * noiseAmplitude - noiseAmplitude / 2
}