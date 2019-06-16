package jp.shiita.realmlivedata.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import jp.shiita.realmlivedata.R
import jp.shiita.realmlivedata.databinding.ActivityEditBinding
import jp.shiita.realmlivedata.observe
import javax.inject.Inject

class EditActivity : DaggerAppCompatActivity() {
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: EditViewModel
            by lazy { ViewModelProviders.of(this, viewModelFactory).get(EditViewModel::class.java) }
    private val binding: ActivityEditBinding
            by lazy { DataBindingUtil.setContentView<ActivityEditBinding>(this, R.layout.activity_edit) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

        binding.observeButton.setOnClickListener { _ ->
            viewModel.simpleText2.observe(this) { binding.editText2.setText(it.text) }
        }
        binding.removeButton.setOnClickListener { _ ->
            viewModel.simpleText2.removeObservers(this)
        }
    }
}
