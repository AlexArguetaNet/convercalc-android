package com.example.convercalc

class Calculator {

    private var swapUnits = false

    fun setSwapUnits(boolVal: Boolean) {
        swapUnits = boolVal
    }
    fun getSwapUnits(): Boolean {
        return swapUnits
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

    fun lbsAndKgs (x: Double): Double {

        return if (!swapUnits) {
            x / 2.205
        } else {
            x * 2.205
        }

    }



}