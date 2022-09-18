package com.example.livedata.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.livedata.R
import com.example.livedata.model.ListImages
import com.example.livedata.model.Product

class ProductLiveData: ViewModel() {

    val userData :MutableLiveData<MutableList<Product>> = MutableLiveData()
    val parfumGrey = "ORIGINAL JAYROSSE PARFUM - GREY\n" +
            "\n" +
            "EAU DE PERFUME 30 ML\n" +
            "\n" +
            "Character: Sweet Romantic\n" +
            "\n" +
            "Longevity: Up To 6-8 Hours\n" +
            "\n" +
            "•Top notes: Plum, Ozonic notes, Grapefruit and Bergamot\n" +
            "•Middle notes: Hazelnut, Honey, Cedar, Cashmere Wood, and Orange Blossom\n" +
            "•Base notes: Amberwood, Patchouli, Oakmoss and Vetiver\n" +
            "\n" +
            "Aroma sweet yang terkesan romantis sangat cocok digunakan untuk dating bertemu pasangan"

    val parfumLuke = "- JAYROSSE PERFUME - LUKE\n" +
            "EAU DE PERFUME 30 ML\n" +
            "Character: Woody Elegant\n" +
            "Longevity: Up To 6-8 Hours\n" +
            "\n" +
            "•Top notes: Lemon Zest, Bergamot, Mint and Artemisia\n" +
            "•Middle notes: Lavender, Geranium, Pineapple and Green Notes\n" +
            "•Base notes: Sandalwood, Cedar, Amberwood, and Tonka Bean\n" +
            "\n" +
            "Aroma maskulin yang memberikan kesan manly bisa menjadi daya pikat kamu, sangat cocok kamu gunakan untuk dating, acara formal atau kegitan sehari-hari \uD83D\uDC4C\n" +
            "\n" +
            "⛔PRODUK MUDAH PECAH HARAP ATC EXTRA BUBBLE UNTUK TAMBAHAN PACKINGAN ⛔"

    val parfumGray = "- JAYROSSEPERFUME - ROUGE\n" +
            "EAU DE PERFUME 30 ML\n" +
            "Character: Manly Romantic\n" +
            "Longevity: Up To 6-8 Hours\n" +
            "\n" +
            "•Top notes: Calabrian bergamot and Pepper\n" +
            "•Middle notes: Sichuan Pepper, Lavender, Pink Pepper, Vetiver, Patchouli, Geranium and elemi\n" +
            "•Base notes: Ambroxan, Cedar and Labdanum\n" +
            "\n" +
            "Aroma yang terkesan manly dan kharismatik pasti sangat disukai orang sekitarmu, sangat cocok buat hangout ataupun kegiatan sehari-hari\n" +
            "\n" +
            "⛔PRODUK MUDAH PECAH HARAP ATC EXTRA BUBBLE UNTUK TAMBAHAN PACKINGAN ⛔"


    val pacoRabbano = "Parfum Paco Rabanne One Million Man Parfum\n" +
            "Untuk : Pria\n" +
            "Jenis : Parfum\n" +
            "Ukuran : 100ml\n" +
            "Notes : Tuberose, Monoi Oil, Salt, Ambergris, Solar notes, Leather, Cashmeran, Labdanum, Pine.\n" +
            "Parfum Paco Rabanne One Million Man EDP diluncurkan pada tahun 2020\n" +
            "\n" +
            "BPOM : NC14200600285"


    val listData = mutableListOf(
       Product("Parfum Grey Jayrosse pria tahan lama Parfum Jayrosse Grey 30ml", mutableListOf(ListImages(R.drawable.parfumi)),500000,222,"" +
               parfumGrey) ,
        Product("Parfum Jayrosse Luke Parfum pria tahan lama 30ml Parfum Grey Jayrosse", mutableListOf(ListImages(R.drawable.parfumluke),ListImages(R.drawable.parfum_lukeii)
            ,ListImages(R.drawable.parfum_lukeiii)),200000,200,"" +
               parfumLuke),
        Product("Parfum Jayrosse Rouge Parfum pria tahan lama Parfum wanita Parfum Joyrosse Grey Parfum pria tahan lama 30ml ",
            mutableListOf(ListImages(R.drawable.parfum_rougei),ListImages(R.drawable.parfum_rougeii),ListImages(R.drawable.parfum_rougeiii)),
            400000,210,"" +
                parfumGray),
        Product("Paco Rabanne One Million Man (Parfum) - 100 ML", mutableListOf(ListImages(R.drawable.paco_rabbane),ListImages(R.drawable.paco_rabbaneii)),1000000,
            30,"" + pacoRabbano),
        Product("Parfum Grey Jayrosse pria tahan lama Parfum Jayrosse Grey 30ml", mutableListOf(ListImages(R.drawable.parfumi)),500000,222,"" +
                parfumGrey) ,
        Product("Parfum Jayrosse Luke Parfum pria tahan lama 30ml Parfum Grey Jayrosse", mutableListOf(ListImages(R.drawable.parfumluke),ListImages(R.drawable.parfum_lukeii)
            ,ListImages(R.drawable.parfum_lukeiii)),200000,200,"" +
                parfumLuke),
        Product("Parfum Jayrosse Rouge Parfum pria tahan lama Parfum wanita Parfum Joyrosse Grey Parfum pria tahan lama 30ml ",
            mutableListOf(ListImages(R.drawable.parfum_rougei),ListImages(R.drawable.parfum_rougeii),ListImages(R.drawable.parfum_rougeiii)),
            400000,210,"" +
                    parfumGray),
        Product("Paco Rabanne One Million Man (Parfum) - 100 ML", mutableListOf(ListImages(R.drawable.paco_rabbane),ListImages(R.drawable.paco_rabbaneii)),1000000,
            30,"" + pacoRabbano),
    )

    fun getData(){
        userData.value = listData
    }

}