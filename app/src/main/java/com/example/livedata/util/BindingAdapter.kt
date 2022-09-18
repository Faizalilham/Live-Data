package com.example.livedata.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.livedata.model.ListImages

@BindingAdapter("android:images")
fun imageResources(place : ImageView ,image : List<ListImages>) {
    place.setImageResource(image.first().images)
}

@BindingAdapter("android:slideImages")
fun slideImage(place: ImageSlider, image : List<ListImages>){
    val listImage = mutableListOf<SlideModel>()
    for(i in image){
        listImage.add(SlideModel(i.images))
    }

    place.setImageList(listImage, ScaleTypes.CENTER_CROP)
}