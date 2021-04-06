package com.example.viewmodel_livedata

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    companion object {
        var following: MutableLiveData<String> = MutableLiveData()
        //var counter: MutableLiveData<Int> = MutableLiveData()
        var counter = 0
        fun increase() {
            counter++
            following.setValue("팔로잉 $counter 명")

        }

        fun decrease() {
            counter--
            following.setValue("팔로잉 $counter 명")
        }



    }
    fun getFollowing(): MutableLiveData<String> {
        return following
    }
    init {
        following.setValue("팔로잉 $counter 명")
    }
}