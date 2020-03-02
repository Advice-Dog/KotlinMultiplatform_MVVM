package com.jarroyo.kmp_mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jarroyo.kmp_mvvm.ui.HomeAdapter
import com.jarroyo.sharedcode.viewModel.HackerTrackerViewModel
import com.jarroyo.sharedcode.viewModel.github.*
import kotlinx.android.synthetic.main.fragment_schedule.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: HackerTrackerViewModel

    private val adapter = HomeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProviders.of(this).get(HackerTrackerViewModel::class.java)

        viewModel.getArticles().addObserver {
            loading_progress.visibility = View.GONE
            adapter.setElements(it)
        }
    }
}
