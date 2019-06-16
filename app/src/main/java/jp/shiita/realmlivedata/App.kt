package jp.shiita.realmlivedata

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.realm.Realm
import io.realm.RealmConfiguration
import jp.shiita.realmlivedata.di.DaggerAppComponent

class App : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder()
                .name(getString(R.string.app_name))
                .schemaVersion(1)
                .build()
        Realm.setDefaultConfiguration(config)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
                .application(this)
                .build()
    }
}