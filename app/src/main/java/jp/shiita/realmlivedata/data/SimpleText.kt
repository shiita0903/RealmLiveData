package jp.shiita.realmlivedata.data

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class SimpleText(
        open var text: String = "",
        @PrimaryKey open var id: String = UUID.randomUUID().toString()
) : RealmObject()