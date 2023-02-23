package com.omersungur.dagger_hilt_examplekotlin

import javax.inject.Inject

class SecondInterfaceImplementor
@Inject
constructor() : MyInterface
{
    override fun myPrintFunction(): String {
        return "My Second Interface Implementor"
    }

    //// İnterface'den bir nesne oluşturamayacağımız için bu interface'i bir class'a implement ettirerek bu class'tan nesne üretebiliriz.
}