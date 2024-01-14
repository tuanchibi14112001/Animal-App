package com.example.animalapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.animalapp.base.BaseViewModel
import com.example.animalapp.model.AnimalType
import com.example.animalapp.repository.AnimalTypeRepo
import com.example.animalapp.utils.Resource
import kotlinx.coroutines.launch


//@HiltViewModel
//class AnimalTypeViewModel @Inject constructor(private val repo: AnimalTypeRepo) : BaseViewModel() {
//    private val _dataFlow = MutableLiveData<Resource<List<AnimalType>>>()
//    val dataFlow : LiveData<Resource<List<AnimalType>>>get() = _dataFlow
//
//    private fun getAllAnimalType() = viewModelScope.launch {
//        _dataFlow.value = Resource.loading()
//        val result = repo.getAnimalType()
//        _dataFlow.value = result
//    }
//}