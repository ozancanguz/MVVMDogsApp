package com.ozancanguz.mvvmdogsapp.model

import io.reactivex.Single
import retrofit2.http.GET

// FOR RETROFIT PART 1
interface DogsApi {

    @GET("DevTides/DogsApi/master/dogs.json")
    fun getDogs():Single<List<DogBreed>>


}