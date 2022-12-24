package com.albertomier.lotterychecker.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albertomier.lotterychecker.data.network.ApiResponseStatus
import com.albertomier.lotterychecker.domain.AddNumberUseCase
import com.albertomier.lotterychecker.domain.CheckNumberUseCase
import com.albertomier.lotterychecker.domain.GetNumbersUseCase
import com.albertomier.lotterychecker.domain.RemoveNumberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NumberViewModel @Inject constructor(
    private val checkNumberUseCase: CheckNumberUseCase,
    private val getNumberUseCase: GetNumbersUseCase,
    private val addNumberUseCase: AddNumberUseCase,
    private val removeNumberUseCase: RemoveNumberUseCase
) :
    ViewModel() {

    private val _number = MutableLiveData<com.albertomier.lotterychecker.domain.model.Number>()
    val number: LiveData<com.albertomier.lotterychecker.domain.model.Number> get() = _number

    private val _numberList = MutableLiveData<List<com.albertomier.lotterychecker.domain.model.Number>>()
    val numberList: LiveData<List<com.albertomier.lotterychecker.domain.model.Number>> get() = _numberList

    private val _status = MutableLiveData<ApiResponseStatus<Any>>()
    val status: LiveData<ApiResponseStatus<Any>> get() = _status

    fun checkNumber(number: String) {
        viewModelScope.launch {
            _status.value = ApiResponseStatus.Loading()
            handleResponseStatus(checkNumberUseCase(number))
            getNumbers()
        }
    }

    fun getNumbers() {
        viewModelScope.launch {
            //_status.value = ApiResponseStatus.Loading()
            handleResponseListStatus(getNumberUseCase())
        }
    }

    fun addNumber(number: String, prize: Int, timestamp: Int, status: Int, error: Int) {
        viewModelScope.launch {
            Log.e("TAG RESPONSEE",number)
            addNumberUseCase(number, prize, timestamp, status, error)
            //checkNumber(number)
            //handleResponseListStatus(getNumberUseCase())
        }
    }

    fun removeNumber(number: String) {
        viewModelScope.launch {
            removeNumberUseCase(number)
            getNumbers()
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun handleResponseStatus(responseStatus: ApiResponseStatus<com.albertomier.lotterychecker.domain.model.Number>) {
        if (responseStatus is ApiResponseStatus.Success) {
            _number.value = responseStatus.data
        }

        _status.value = responseStatus as ApiResponseStatus<Any>
    }

    @Suppress("UNCHECKED_CAST")
    private fun handleResponseListStatus(responseStatus: List<com.albertomier.lotterychecker.domain.model.Number>) {
        //if (responseStatus is ApiResponseStatus.Success) {
        Log.e("TAGGGG", responseStatus.toString())
            _numberList.value = responseStatus
       // }

        //_status.value = responseStatus as ApiResponseStatus<Any>
    }
}