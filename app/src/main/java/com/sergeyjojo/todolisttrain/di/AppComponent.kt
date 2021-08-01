package com.sergeyjojo.todolisttrain.di

import com.sergeyjojo.todolisttrain.MainActivityViewModel.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RetrofitModule::class])

@Singleton
interface AppComponent {

    fun inject(MainActivityViewModel: MainActivityViewModel)
}