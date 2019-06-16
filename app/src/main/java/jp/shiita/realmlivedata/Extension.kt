package jp.shiita.realmlivedata

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import io.realm.Realm
import io.realm.RealmModel

fun <T> LiveData<T>.observe(owner: LifecycleOwner, observer: (T) -> Unit) =
        observe(owner, Observer<T> { if (it != null) observer(it) })

fun <T : RealmModel> T.toMutableLiveData(realm: Realm) =
        RealmMutableLiveData<T>(realm).also { it.value = this }