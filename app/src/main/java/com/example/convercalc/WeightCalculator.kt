package com.example.convercalc

class WeightCalculator {

    private var swapUnits = false

    fun setSwapUnits(boolVal: Boolean) {
        this.swapUnits = boolVal
    }
    fun getSwapUnits(): Boolean {
        return this.swapUnits
    }


    fun lbsAndKgs (x: Double): Double {

        return if (!swapUnits) {
            x / 2.205
        } else {
            x * 2.205
        }

    }

}