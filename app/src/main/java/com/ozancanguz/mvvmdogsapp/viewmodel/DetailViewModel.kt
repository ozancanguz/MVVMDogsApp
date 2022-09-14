package com.ozancanguz.mvvmdogsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ozancanguz.mvvmdogsapp.model.DogBreed

class DetailViewModel:ViewModel() {

    val dogLiveData= MutableLiveData<DogBreed>()
    fun fetch(){
        val dog =DogBreed("1","golden","15 years","breedgroup",

            "breedfor","temperament","imageurl")

        dogLiveData.value=dog


}}