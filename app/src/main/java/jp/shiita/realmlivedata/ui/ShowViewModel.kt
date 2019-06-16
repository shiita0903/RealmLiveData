package jp.shiita.realmlivedata.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import jp.shiita.realmlivedata.data.SimpleTextDataSource
import javax.inject.Inject

class ShowViewModel @Inject constructor(
        dataSource: SimpleTextDataSource
) : ViewModel() {
    val text: LiveData<String>
        get() = _text
    private val _text = MutableLiveData<String>()

    init {
        _text.postValue(dataSource.getSimpleTexts()
                .joinToString(separator = "\n") { it.text })
    }
}