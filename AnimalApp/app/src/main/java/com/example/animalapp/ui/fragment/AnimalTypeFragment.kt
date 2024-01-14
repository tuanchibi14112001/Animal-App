package com.example.animalapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.animalapp.R
import com.example.animalapp.api.ApiService
import com.example.animalapp.base.BaseFragment
import com.example.animalapp.databinding.FragmentAnimalTypeBinding
import com.example.animalapp.model.AnimalType
//import com.example.animalapp.ui.viewmodel.AnimalTypeViewModel
import com.example.animalapp.utils.Constant
import com.example.animalapp.utils.Status
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Animal Type Created Fragment

class AnimalTypeFragment : BaseFragment<FragmentAnimalTypeBinding>() {

   // private val viewModel: AnimalTypeViewModel by viewModels()
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAnimalTypeBinding.inflate(inflater, container, false)

    override fun prepareView(savedInstanceState: Bundle?) {
        binding.btnPetAnimal.setOnClickListener{
            it.findNavController().navigate(R.id.action_animalTypeFragment_to_listAnimalFragment)
        }
        getAllType()
        //showLoading()
    }

//    private fun observeModel(){
//        viewModel.dataFlow.observe(viewLifecycleOwner) {
//            when (it.status) {
//                Status.SUCCESS -> {
//                    Log.d("CHECK_RESPONSE", it.data.toString())
//                    hideLoading()
//                }
//                Status.ERROR -> {
//                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
//                    hideLoading()
//                }
//                Status.LOADING -> {
//                    showLoading()
//                }
//            }
//        }
//    }
    private fun getAllType(){
        val api = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
        api.getAnimalType().enqueue(object : Callback<List<AnimalType>>{
            override fun onResponse(
                call: Call<List<AnimalType>>,
                response: Response<List<AnimalType>>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        for (type in it){
                            binding.txtPets.text = type.name
                            Log.d("CHECK_RESPONSE", type.name)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<AnimalType>>, t: Throwable) {
                Log.d("CHECK_RESPONSE", t.message.toString())
            }

        })
    }
}