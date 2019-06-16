package jp.shiita.realmlivedata.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import jp.shiita.realmlivedata.di.ViewModelFactory
import jp.shiita.realmlivedata.di.ViewModelKey
import jp.shiita.realmlivedata.ui.EditViewModel
import jp.shiita.realmlivedata.ui.ShowViewModel

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ShowViewModel::class)
    abstract fun bindAddEditNoteViewModel(viewModel: ShowViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EditViewModel::class)
    abstract fun bindEditViewModel(viewModel: EditViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}