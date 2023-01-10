package com.example.lista2

import kotlin.random.Random

data class Crime(val isSolved: Boolean, val title: String, val description: String, val index: Int ) {

}

fun getRandomList(random: Random): List<Int> =
    List(20) { random.nextInt(300000, 399999) }

val indexValues = getRandomList(Random(1))


fun generateListOfCrimes(): MutableList<Crime> {
    var listOfCrimes = mutableListOf<Crime>()

    for (i: Int in 0..19) {
        if(i % 2 == 0)
            listOfCrimes.add(Crime(true, "Crime #$i", "This is a crime number $i done by student with an index number of " + indexValues[i] + ".", i))
        else
            listOfCrimes.add(Crime(false, "Crime #$i", "This is a crime number $i done by student with an index number of " + indexValues[i] + ".", i))
    }

    return listOfCrimes
}