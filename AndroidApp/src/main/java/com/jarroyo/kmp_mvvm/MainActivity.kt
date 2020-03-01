package com.jarroyo.kmp_mvvm

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jarroyo.kmp_mvvm.ui.HomeAdapter
import com.jarroyo.sharedcode.viewModel.HackerTrackerViewModel
import com.jarroyo.sharedcode.viewModel.github.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var viewModel: HackerTrackerViewModel

    private val adapter = HomeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProviders.of(this).get(HackerTrackerViewModel::class.java)

        viewModel.getArticles().addObserver {
            loading_progress.visibility = View.GONE
            adapter.setElements(it)
        }
    }
}
