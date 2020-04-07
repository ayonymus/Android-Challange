package com.ayon.marvel.di

import androidx.lifecycle.ViewModel
import com.ayon.core.di.ViewModelKey
import com.ayon.core.di.ViewModelModule
import com.ayon.marvel.presentation.ComicListMarvelFragment
import com.ayon.marvel.presentation.ComicListViewModel
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
    abstract fun bindMarvelFragment(): ComicListMarvelFragment

    @Binds
    @IntoMap
    @ViewModelKey(ComicListViewModel::class)
    abstract fun bindMainViewModel(viewModel: ComicListViewModel): ViewModel

}