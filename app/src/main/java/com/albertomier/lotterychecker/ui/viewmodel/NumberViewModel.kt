package com.albertomier.lotterychecker.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albertomier.lotterychecker.data.network.ApiResponseStatus
import com.albertomier.lotterychecker.domain.CheckNumberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NumberViewModel @Inject constructor(private val checkNumberUseCase: CheckNumberUseCase) :
    ViewModel() {

    private val _number = MutableLiveData<com.albertomier.lotterychecker.domain.model.Number>()
    val number: LiveData<com.albertomier.lotterychecker.domain.model.Number> get() = _number

    private val _status = MutableLiveData<ApiResponseStatus<Any>>()
    val status: LiveData<ApiResponseStatus<Any>> get() = _status

    fun checkNumber(number: String) {
        viewModelScope.launch {
            _status.value = ApiResponseStatus.Loading()
            handleResponseStatus(checkNumberUseCase(number))
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun handleResponseStatus(responseStatus: ApiResponseStatus<com.albertomier.lotterychecker.domain.model.Number>) {
        if (responseStatus is ApiResponseStatus.Success) {
            _number.value = responseStatus.data
        }

        _status.value = responseStatus as ApiResponseStatus<Any>
    }
}