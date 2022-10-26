package com.ozancanguz.mvvmdogsapp.util

import android.content.Context
import android.text.Html
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ozancanguz.mvvmdogsapp.R


fun getProgressDrawble(context: Context):CircularProgressDrawable {

    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}
         fun ImageView.loadImage(uri:String?,progressDrawable: CircularProgressDrawable){
             val options=RequestOptions()
                 .placeholder(progressDrawable)
                 .error(R.mipmap.ic_launcher)
                 Glide.with(context)
                     .setDefaultRequestOptions(options)
                     .load(uri)
                     .into(this)

         }

