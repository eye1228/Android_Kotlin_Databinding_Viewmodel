package com.example.viewmodel_livedata


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.viewmodel_livedata.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    var viewModel: MainViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding?.setViewModel(viewModel)
        binding?.setLifecycleOwner(this)
        toolbarInit()
        settingAdapter()
        //observerViewModel()
    }

    fun toolbarInit() {
        setSupportActionBar(binding?.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_keyboard_backspace_black_24dp)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    fun settingAdapter() {
        val userDataList: ArrayList<UserDataList> = ArrayList()
        userDataList.add(UserDataList("e0eun_qt", "이영은"))
        userDataList.add(UserDataList("iiveryi", "정성훈"))
        userDataList.add(UserDataList("deep_shining_", "최석준"))
        userDataList.add(UserDataList("g_yyuu_", "임규민"))
        userDataList.add(UserDataList("seo._.6", "김서준"))
        userDataList.add(UserDataList("ttingho812", "추명호"))
        userDataList.add(UserDataList("sun_nowplaying", "김혜선"))
        userDataList.add(UserDataList("0_haribro", "오하형"))
        userDataList.add(UserDataList("wonbin622", "김원빈"))
        userDataList.add(UserDataList("yang.0626", "양동욱"))
        userDataList.add(UserDataList("galpos3_", "이수민"))
        val adapter = UserAdapter(applicationContext, userDataList)
        binding?.recyclerView?.setAdapter(adapter)
    }

    /*fun observerViewModel() {
        MainViewModel.counter.observe(this, Observer<Int?> {
            fun onChanged(integer: Int) {
                Log.d("확인",integer.toString());
                MainViewModel.following.value = "팔로잉 " + integer + "명"
            }
        })
    }*/
}

