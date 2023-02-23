package com.omersungur.dagger_hilt_examplekotlin

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

interface MyInterface {
    fun myPrintFunction() : String
}

/*
1. Yöntem

@InstallIn(SingletonComponent::class)
@Module
abstract class MyModule {
    @ActivityScoped
    @Binds // hilt yapısında dışarıdan bir kütüphane kullanabilmek için veya custom sınıflarımızı kullanabilmek için bind kullanabiliriz.
    abstract fun bindingFunction(myImplementor: InterfaceImplementor) : MyInterface
}
 */

// 2.Yöntem
@InstallIn(SingletonComponent::class)
@Module
class MyModule {

    @FirstImplementor // anotasyonumuz
    @Singleton
    @Provides // hilt yapısında dışarıdan bir kütüphane kullanabilmek için veya custom sınıflarımızı kullanabilmek için provides ile bunu belirtmeliyiz.
    fun providerFunction() : MyInterface {
        return InterfaceImplementor()
    }

    @Singleton
    @Provides
    fun gSonProvider() : Gson {
        return Gson()
    }

    @SecondImplementor
    @Singleton
    @Provides
    fun secondProviderFunction() : MyInterface {
        return SecondInterfaceImplementor()
    }

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FirstImplementor // iki tane aynı interface'i implement eden class'ımız var ve bunları birbirinden ayırabilmek için annotation kullanıyoruz.

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class SecondImplementor