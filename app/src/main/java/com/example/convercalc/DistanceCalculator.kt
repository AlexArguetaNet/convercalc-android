package com.example.convercalc

class DistanceCalculator {

    private var swapUnits = false

    fun setSwapUnits(boolVal: Boolean) {
        this.swapUnits = boolVal
    }
    fun getSwapUnits(): Boolean {
        return this.swapUnits
    }


    fun inchesAndCentimeters(x: Double): Double {
        return if (!swapUnits) {
            x * 2.54
        } else {
            x / 2.54
        }
    }

    fun feetAndMeters(x: Double): Double {
        return if (!swapUnits) {
            x * 0.3048
        } else {
            x / 0.3048
        }
    }

    fun milesAndKilometers(x: Double): Double {
        return if (!swapUnits) {
            x * 1.60934
        } else {
            x / 1.60934
        }

    }

}