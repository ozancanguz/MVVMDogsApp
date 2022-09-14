package com.ozancanguz.mvvmdogsapp.view

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.mvvmdogsapp.R
import com.ozancanguz.mvvmdogsapp.model.DogBreed
import com.ozancanguz.mvvmdogsapp.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {
    // 1 -tanımlamaları yap
    private lateinit var viewmodel:ListViewModel
    private var dogListAdapter=DogsListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 2--
        viewmodel= ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewmodel.refresh()

        dogslist.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=dogListAdapter
        }
        observeViewModel()

    }


    // 3
   fun observeViewModel() {

       viewmodel.dogs.observe(viewLifecycleOwner, Observer {dogs ->
           dogs?.let {
               dogslist.visibility=View.VISIBLE
               dogListAdapter.updateDogList(dogs as ArrayList<DogBreed>)

           }
       })

       viewmodel.loading.observe(viewLifecycleOwner, Observer {isLoading ->
           isLoading?.let {
               loadingview.visibility=if(it) View.VISIBLE else View.GONE
               if(it){
                   listerror.visibility=View.GONE
                   dogslist.visibility=View.GONE
               }
           }

       })

       viewmodel.dogsLoadError.observe(viewLifecycleOwner, Observer { isError ->
          isError?.let {
              listerror.visibility=if(it) View.VISIBLE else View.GONE
          }
       })


    }

}
