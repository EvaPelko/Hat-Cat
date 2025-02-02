package com.unipu.hatcat

data class Cat(
    val hunger: Float = 0.1f,
    val thirst: Float = 0.3f,
    val tiredness: Float = 0.1f
) {
    fun isHappy(): Boolean {
        return hunger == 1f && thirst == 1f && tiredness == 1f
    }
}