package jp.shiita.realmlivedata.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import jp.shiita.realmlivedata.App
import jp.shiita.realmlivedata.di.module.ActivityModule
import jp.shiita.realmlivedata.di.module.DataModule
import jp.shiita.realmlivedata.di.module.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityModule::class,
    ViewModelModule::class,
    DataModule::class
])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder
        fun build(): AppComponent
    }

    override fun inject(app: App)
}