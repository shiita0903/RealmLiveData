package jp.shiita.realmlivedata.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.shiita.realmlivedata.ui.EditActivity
import jp.shiita.realmlivedata.ui.MainActivity
import jp.shiita.realmlivedata.ui.ShowActivity

@Suppress("unused")
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector()
    abstract fun contributeShowActivity(): ShowActivity

    @ContributesAndroidInjector()
    abstract fun contributeEditActivity(): EditActivity
}