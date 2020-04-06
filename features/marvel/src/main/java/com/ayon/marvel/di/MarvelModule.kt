package com.ayon.marvel.di

import androidx.lifecycle.ViewModel
import com.ayon.core.di.ViewModelKey
import com.ayon.core.di.ViewModelModule
import com.ayon.marvel.presentation.MarvelFragment
import com.ayon.marvel.presentation.MarvelFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(
    includes = [
        MarvelDataModule::class,
        MarvelNetworkModule::class,
        ViewModelModule::class ]
)
abstract class MarvelModule {

    @ContributesAndroidInjector
    abstract fun bindMarvelFragment(): MarvelFragment

    @Binds
    @IntoMap
    @ViewModelKey(MarvelFragmentViewModel::class)
    abstract fun bindMainViewModel(viewModel: MarvelFragmentViewModel): ViewModel
}