package com.ozancanguz.mvvmdogsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.ozancanguz.mvvmdogsapp.R
import com.ozancanguz.mvvmdogsapp.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_list.*


class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    private var dogUuid=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // get from list fragment
        arguments?.let {
            dogUuid=DetailFragmentArgs.fromBundle(it).dogUuid

        }

        viewModel= ViewModelProviders.of(this).get(DetailViewModel::class.java)
        viewModel.fetch()

        observeViewModel()


    }

    private fun observeViewModel() {
       viewModel.dogLiveData.observe(viewLifecycleOwner, Observer { dog ->
           dog?.let{
               dogName.text=dog.dogbreed
               dogPurpose.text=dog.breedFor
                dogLifespan.text=dog.lifesSpan
               dogTemperament.text=dog.temperament
           }
       })
    }
}