package jp.shiita.realmlivedata.di.module

import dagger.Module
import dagger.Provides
import io.realm.Realm
import jp.shiita.realmlivedata.data.SimpleTextDataSource
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideRealm(): Realm = Realm.getDefaultInstance()

    @Provides
    @Singleton
    fun provideSimpleTextDataSource(realm: Realm): SimpleTextDataSource = SimpleTextDataSource(realm)
}