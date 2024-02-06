package com.example.myrmcalculatorapp.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.round

class HomeViewModel:ViewModel() {

    private val _weigth = MutableLiveData<Int>()
    val weigth: LiveData<Int> = _weigth

    private val _repsNumber = MutableLiveData<Int>()
    val repsNumber: LiveData<Int> = _repsNumber

    private val _rm1 = MutableLiveData<Double>()
    val rm1: LiveData<Double> = _rm1

    fun onTextChange(weigth: Int, repsNumber: Int) {
        _weigth.value = weigth
        _repsNumber.value = repsNumber
    }
    fun calculateRm() {
         if(_weigth.value!! >  0 || _repsNumber.value!! > 0 ){
            val rm1 = _weigth.value!! / (1.0278 - (0.0278 * _repsNumber.value!!))
             _rm1.value = round(rm1 * 100) / 100.0
        }else _rm1.value = 0.0

    }
}