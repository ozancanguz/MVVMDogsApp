package com.ozancanguz.mvvmdogsapp.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.signature.AndroidResourceSignature
import com.ozancanguz.mvvmdogsapp.model.DogBreed
import com.ozancanguz.mvvmdogsapp.model.DogDao
import com.ozancanguz.mvvmdogsapp.model.DogDatabase
import com.ozancanguz.mvvmdogsapp.model.DogsApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.newThread
import kotlinx.coroutines.launch

class ListViewModel(application: Application):BaseViewModel(application) {

    // retrofit part 3
    private val dogService = DogsApiService()
    private val disposable = CompositeDisposable()


    val dogs = MutableLiveData<List<DogBreed>>()
    val dogsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
          fetchFromRemote()
    }



    // retrofit part 5
    private fun fetchFromRemote(){
        loading.value=true
        disposable.add(

            dogService.getDogs()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSingleObserver<List<DogBreed>>(){
                    override fun onSuccess(dogList: List<DogBreed>?) {
                        if (dogList != null) {
                            storeDogsLocally(dogList)
                        }

                    }

                    override fun onError(e: Throwable?) {
                       dogsLoadError.value=true
                        loading.value=false

                    }


                }))

    }


    private fun dogRetrieved(dogList:List<DogBreed>){
        dogs.value=dogList!!
        loading.value=false
        dogsLoadError.value=false

    }

     private fun storeDogsLocally(list: List<DogBreed>){

                 launch {
                   val dao:DogDao=  DogDatabase(getApplication()).dogDao()
                     dao.deleteAllDogs()
                     val result=dao.insertAll(*list.toTypedArray())
                     var i=0
                     while(i<list.size){
                         list[i].uuid=result[i].toInt()
                         ++i
                     }
                     dogRetrieved(list)

                 }

     }

    // 4
    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}

