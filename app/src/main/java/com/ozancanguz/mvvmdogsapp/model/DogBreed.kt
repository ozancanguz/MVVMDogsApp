package com.ozancanguz.mvvmdogsapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class DogBreed (

    @ColumnInfo(name = "breeed_id")
    @SerializedName("id")
    val breedId:String?,


    @ColumnInfo(name = "dog_name")
    @SerializedName("name")
    val dogbreed:String?,

    @ColumnInfo(name = "life_span")
    @SerializedName("lifespan")
    val lifesSpan:String?,

    @ColumnInfo(name = "breed_group")
    @SerializedName("breed_group")
    val breedGroup:String?,

    @ColumnInfo(name = "bred_for")
    @SerializedName("bred_for")
    val breedFor:String?,


    @SerializedName("temperament")
    val temperament:String?,

    @ColumnInfo(name = "dog_url")
    @SerializedName("url")
    val imageUrl:String?

){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int=0
}