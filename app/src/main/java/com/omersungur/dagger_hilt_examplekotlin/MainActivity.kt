package com.omersungur.dagger_hilt_examplekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // Field Injection
    @Inject
    lateinit var musician1 : Musicians

    @Inject
    lateinit var myClass : ClassExample

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Musicians sınıfından bir obje oluşturabilmek için instrument ve band için de ayrı bir obje oluşturmalıyız.
        // Bir sınıfın parametresinde başka bir sınıftan değişken varsa, bu sınıftan bir obje üretmek için diğer sınıflardan da bir obje üretmeliyiz.
        // Bu sınıfları tek tek oluşturmamak için Dependency Injection kullanılır.
        // Eğer Hilt'te bir problem varsa uygulama hiçbir şekilde çalışmaz. (hilt işlerini Compile time'da yapar)
        // Field Injection ve Constructor Injection tanımlamalarını yaptıktan sonra hilt yapısını kullanabiliriz.

        /*val insturment1 = Instruments()
        val band1 = Bands()
        val musician1 = Musicians(insturment1,band1)
        musician1.sing()*/

        musician1.sing()

        println(myClass.myFunction())

        println(myClass.secondFunction())

    }
}

@AndroidEntryPoint // Hiltin kullanılacağı yerde bunu belirtiyoruz
class FragmentExample : Fragment() {
    @Inject
    lateinit var musician : Musicians // Musicians sınıfının kapsamı Singleton olduğu için her yerde kullanabiliriz. Burada Fragment içinde kullandık.
}