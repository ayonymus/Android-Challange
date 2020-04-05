package com.ayon.mockfeature.di

import androidx.lifecycle.ViewModel
import com.ayon.mockfeature.presentation.MockFragment
import com.ayon.mockfeature.presentation.MockFragmentViewModel
import com.ayon.core.di.ViewModelKey
import com.ayon.core.di.ViewModelModule
import com.ayon.mockfeature.di.MockDataModule
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
    abstract fun bindMainFragment(): MockFragment

    @Binds
    @IntoMap
    @ViewModelKey(MockFragmentViewModel::class)
    abstract fun bindMainViewModel(viewModel: MockFragmentViewModel): ViewModel
}