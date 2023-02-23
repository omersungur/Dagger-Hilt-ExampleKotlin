package com.omersungur.dagger_hilt_examplekotlin

import javax.inject.Inject
import javax.inject.Singleton

//Constructor Injection
@Singleton // Kapsam belirtebiliyoruz. Diğer tarafta kullandığımız kapsam bu kapsamdan düşük yetkide olmamalı.
class Musicians @Inject constructor(val instrument : Instruments, val band : Bands) {

    fun sing() {
        println("Sing method is working...")
    }
}