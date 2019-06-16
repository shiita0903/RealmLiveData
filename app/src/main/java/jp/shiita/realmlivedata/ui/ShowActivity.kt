package jp.shiita.realmlivedata.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import jp.shiita.realmlivedata.R
import jp.shiita.realmlivedata.databinding.ActivityShowBinding
import javax.inject.Inject

class ShowActivity : DaggerAppCompatActivity() {
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: ShowViewModel
            by lazy { ViewModelProviders.of(this, viewModelFactory).get(ShowViewModel::class.java) }
    private val binding: ActivityShowBinding
            by lazy { DataBindingUtil.setContentView<ActivityShowBinding>(this, R.layout.activity_show) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
    }
}
