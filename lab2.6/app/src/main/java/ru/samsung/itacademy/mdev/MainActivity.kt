package ru.samsung.itacademy.mdev

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: RandomViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provider = ViewModelProvider(this)
        viewModel = provider.get(RandomViewModel::class.java)

        observeViewModel()

        initView()
    }

    fun observeViewModel() {
        viewModel.counter.observe(this, Observer {
            rndNUM.setText(it.toString())
        })
    }

    fun initView() {
        getRnd.setOnClickListener {
            viewModel.onIncrementClicked()
        }
    }
}
