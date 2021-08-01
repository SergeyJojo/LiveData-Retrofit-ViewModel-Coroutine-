package com.sergeyjojo.todolisttrain.MainActivityViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.sergeyjojo.todolisttrain.NetworkService.ProfileResponse.ProfileData
import com.sergeyjojo.todolisttrain.NetworkService.RetrofitIServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var mService: RetrofitIServiceInterface
    private var liveDateList: MutableLiveData<ProfileData> = MutableLiveData()


    fun getLiveDataObserver(): MutableLiveData<ProfileData> {
        return liveDateList
    }

    suspend fun getProfileCall(id: Int) {
        val call: Call<ProfileData> = mService.account_id(id)
        call.enqueue(object : Callback<ProfileData> {
            override fun onResponse(call: Call<ProfileData>, response: Response<ProfileData>) {
                if (response.isSuccessful) {
                    liveDateList.postValue(response.body())
                    Log.e("TAG", "заебало уже")
                } else {
                    liveDateList.postValue(null)
                    Log.e("TOG", "заебало пиздец")
                }
            }

            override fun onFailure(call: Call<ProfileData>, t: Throwable) {
                liveDateList.postValue(null)
            }

        })
    }
}
