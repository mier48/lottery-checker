package com.albertomier.lotterychecker.core.extensions

/**
 * TODO
 *
 * @return
 */
fun Int.toNumberString() = numberToString(this)

/**
 * TODO
 *
 * @param number
 * @return
 */
private fun numberToString(number: Int): String {
    return if (number < 10) {
        "0$number"
    } else {
        number.toString()
    }
}