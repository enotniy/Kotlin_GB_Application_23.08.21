package com.kotlin.gbapplication2308

open class Parent {

    companion object {
        const val PI: Double = 3.14

        fun doNothing() {

        }
    }

    private val first = "first"
    protected val second = "second"
    internal val third = "third"
    public val forth = "forth"

    protected inner class Inner {
        private val fifth = "fifth"
    }
}
