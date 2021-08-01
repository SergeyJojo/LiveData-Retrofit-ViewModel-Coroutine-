package com.sergeyjojo.todolisttrain

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.sergeyjojo.todolisttrain.MainActivityViewModel.MainActivityViewModel
import com.sergeyjojo.todolisttrain.NetworkService.ProfileResponse.Profile
import com.sergeyjojo.todolisttrain.NetworkService.ProfileResponse.ProfileData
import com.sergeyjojo.todolisttrain.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    val mainActivityViewModel: MainActivityViewModel by viewModels()

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var response: MutableLiveData<ProfileData>? = null

        Log.e("Tag", "тут")
//        CoroutineScope(Dispatchers.IO).launch { mainActivityViewModel.getProfileCall(1080721563) }
        mainActivityViewModel.getLiveDataObserver().observe(this@MainActivity,
            {
                Log.e("Tag", "here1")
                response = it.leaderboard_rank as MutableLiveData<ProfileData>
                Log.e("Tag", "here2")
                binding.textView.text = response.toString()
            })

        mainActivityViewModel.getLiveDataObserver().observe(this, Observer {
            Log.e("tag", "а это")
        })

        Log.e("Tag", "${binding.textView.text}")


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
