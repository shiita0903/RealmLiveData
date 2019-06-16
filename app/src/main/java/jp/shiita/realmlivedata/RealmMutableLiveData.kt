package jp.shiita.realmlivedata

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.annotation.MainThread
import io.realm.Realm
import io.realm.RealmModel

class RealmMutableLiveData<T : RealmModel>(private val realm: Realm) : MutableLiveData<T>() {

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<T>) {
        super.observe(owner, Observer { t ->
            observer.onChanged(t)
        })
    }

    override fun onActive() {
        if (!realm.isInTransaction) realm.beginTransaction()
    }

    override fun onInactive() {
        if (realm.isInTransaction) realm.commitTransaction()
        realm.beginTransaction()
    }
}