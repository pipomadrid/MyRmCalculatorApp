package com.example.myrmcalculatorapp.views

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myrmcalculatorapp.model.CalculatorState
import kotlin.math.round

class HomeViewModel:ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    fun getWeigthString():String{
        return if(state.weigth>0)state.weigth.toString()else ""
    }
    fun getRepsString():String{
        return if(state.repsNumber>0)state.repsNumber.toString()else ""
    }

   /* private val _weigth = MutableLiveData<Int>()
    val weigth: LiveData<Int> = _weigth

    private val _repsNumber = MutableLiveData<Int>()
    val repsNumber: LiveData<Int> = _repsNumber

    private val _rm1 = MutableLiveData<Double>()
    val rm1: LiveData<Double> = _rm1*/

    fun onTextChange(value: Int, text: String) {
        when(text){
            "w"->state = state.copy(weigth = value)
            "r"->state = state.copy(repsNumber = value)
        }
    }

    fun onClean(){
        state = state.copy(weigth=0,repsNumber = 0,rm1 = 0.0)
    }
    fun calculateRm() {
        val weigth = state.weigth
        val repsNumber = state.repsNumber
        state = if(weigth >  0 && repsNumber > 0 ){
            val rm1 = weigth / (1.0278 - (0.0278 * repsNumber))
            state.copy(rm1= round(rm1 * 100) / 100.0)
        }else state.copy(rm1=0.0)

    }
}