package com.ayonymus.androidchallenge.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ayonymus.androidchallenge.presentation.MainFragmentViewModel
import com.ayonymus.androidchallenge.presentation.ViewModelFactory
import com.ayonymus.androidchallenge.presentation.ViewModelKey
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
