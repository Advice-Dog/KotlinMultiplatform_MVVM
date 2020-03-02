package com.jarroyo.kmp_mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jarroyo.kmp_mvvm.ui.ScheduleAdapter
import com.jarroyo.sharedcode.viewModel.HackerTrackerViewModel
import kotlinx.android.synthetic.main.fragment_schedule.*


class ScheduleFragment : Fragment() {

    private val adapter = ScheduleAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false) as ViewGroup
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.layoutManager = LinearLayoutManager(context)
        list.adapter = adapter

        val viewModel = ViewModelProviders.of(requireActivity())[HackerTrackerViewModel::class.java]
        viewModel.getSchedule().addObserver {
            loading_progress.visibility = View.GONE
            adapter.setSchedule(it)
        }
    }
}