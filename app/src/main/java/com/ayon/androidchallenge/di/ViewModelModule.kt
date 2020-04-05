package com.ayon.androidchallenge.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ayon.androidchallenge.presentation.MainFragmentViewModel
import com.ayon.androidchallenge.presentation.ViewModelFactory
import com.ayon.androidchallenge.presentation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Injections for ViewModels
 */
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainFragmentViewModel::class)
    abstract fun provideMapViewModel(viewModel: MainFragmentViewModel): ViewModel

}
