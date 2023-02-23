package com.omersungur.dagger_hilt_examplekotlin

import javax.inject.Inject

class InterfaceImplementor
@Inject
constructor() : MyInterface
{
    override fun myPrintFunction(): String {
        return "My Interface Implementor"
    }

    // İnterface'den bir nesne oluşturamayacağımız için bu interface'i bir class'a implement ettirerek bu class'tan nesne üretebiliriz.
}