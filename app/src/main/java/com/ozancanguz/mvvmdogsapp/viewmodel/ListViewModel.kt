package com.ozancanguz.mvvmdogsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ozancanguz.mvvmdogsapp.model.DogBreed

class ListViewModel:ViewModel(){

    val dogs=MutableLiveData<List<DogBreed>>()
    val dogsLoadError=MutableLiveData<Boolean>()
    val loading=MutableLiveData<Boolean>()

    fun refresh(){
        val dog1=DogBreed("1","Corgi","15 years","breedgroup",

            "breedfor","temperament","imageurl")

        val dog2=DogBreed("2","Corgi","15 years","breedgroup",

            "breedfor","temperament","imageurl")
        val dog3=DogBreed("3","Corgi","15 years","breedgroup",

            "breedfor","temperament","imageurl")

        val doglist= arrayListOf<DogBreed>(dog1,dog2,dog3)
        dogs.value=doglist
        dogsLoadError.value=false
        loading.value=false




    }

}