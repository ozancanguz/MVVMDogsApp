package com.ozancanguz.mvvmdogsapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.mvvmdogsapp.R
import com.ozancanguz.mvvmdogsapp.model.DogBreed
import kotlinx.android.synthetic.main.item_dog.view.*

class DogsListAdapter(val dogList:ArrayList<DogBreed>):RecyclerView.Adapter<DogsListAdapter.DogviewHolder>(){

    // 1- viewholder class ı yaz
     class DogviewHolder(var view: View):RecyclerView.ViewHolder(view){

         // 2 doglist adapter a : recyclerview.adapter viewholderı tanımla
         // 3- implement members

     }

    // 5 bunu yap
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogviewHolder {
       val inflater:LayoutInflater= LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_dog,parent,false)
        return DogviewHolder(view)
    }


    // 6 bunu yap
    override fun onBindViewHolder(holder: DogviewHolder, position: Int) {
        holder.view.name.text=dogList[position].dogbreed
        holder.view.lifespan.text=dogList[position].lifesSpan

    }

    // 4-bunu yap
    override fun getItemCount()=dogList.size


    //-8 bunu yap

    fun updateDogList(newDogList: ArrayList<DogBreed>){

        dogList.clear()
        dogList.addAll(newDogList)
        notifyDataSetChanged()

    }



}