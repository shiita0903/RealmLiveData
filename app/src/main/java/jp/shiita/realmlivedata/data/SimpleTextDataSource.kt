package jp.shiita.realmlivedata.data

import io.realm.Realm
import jp.shiita.realmlivedata.RealmMutableLiveData
import jp.shiita.realmlivedata.toMutableLiveData

class SimpleTextDataSource(private val realm: Realm) {
    fun getSimpleText(index: Int): RealmMutableLiveData<SimpleText> = realm.where(SimpleText::class.java)
            .findAllAsync()[index]!!
            .toMutableLiveData(realm)

    fun getSimpleTexts(): List<SimpleText> = realm.where(SimpleText::class.java)
            .findAllAsync()
            .map { realm.copyFromRealm(it) }

    fun addSimpleText(simpleText: SimpleText) = realm.executeTransaction {
        realm.copyToRealmOrUpdate(simpleText)
    }

    fun deleteAllSimpleText() = realm.executeTransaction {
        realm.where(SimpleText::class.java).findAll().deleteAllFromRealm()
    }
}