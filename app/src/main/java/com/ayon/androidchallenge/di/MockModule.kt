package com.ayon.androidchallenge.di

import androidx.lifecycle.ViewModel
import com.ayon.androidchallenge.presentation.MainFragment
import com.ayon.androidchallenge.presentation.MainFragmentViewModel
import com.ayon.core.di.ViewModelKey
import com.ayon.core.di.ViewModelModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(
    includes = [
        MockDataModule::class,
        ViewModelModule::class ]
)
abstract class MockModule {

    @ContributesAndroidInjector
    abstract fun bindMainFragment(): MainFragment

    @Binds
    @IntoMap
    @ViewModelKey(MainFragmentViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainFragmentViewModel): ViewModel
}