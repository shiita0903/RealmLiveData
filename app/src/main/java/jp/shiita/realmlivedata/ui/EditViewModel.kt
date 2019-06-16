package jp.shiita.realmlivedata.ui

import android.arch.lifecycle.ViewModel
import jp.shiita.realmlivedata.RealmMutableLiveData
import jp.shiita.realmlivedata.data.SimpleText
import jp.shiita.realmlivedata.data.SimpleTextDataSource
import javax.inject.Inject

class EditViewModel @Inject constructor(
        dataSource: SimpleTextDataSource
) : ViewModel() {
    val simpleText1: RealmMutableLiveData<SimpleText> = dataSource.getSimpleText(0)
    val simpleText2: RealmMutableLiveData<SimpleText> = dataSource.getSimpleText(1)
}