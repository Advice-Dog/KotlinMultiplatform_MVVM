package com.jarroyo.kmp_mvvm.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jarroyo.sharedcode.domain.model.hackertracker.Event
import java.util.*
import kotlin.collections.ArrayList

class ScheduleAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
        private const val EVENT = 0
        private const val DAY = 1
    }

    private val collection = ArrayList<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            EVENT -> EventViewHolder.inflate(parent, EventView.DISPLAY_MODE_FULL)
//            DAY -> DayViewHolder.inflate(parent)
            else -> throw IllegalStateException("Unknown viewType $viewType.")
        }
    }

    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = collection[position]

        when (holder) {
            is EventViewHolder -> holder.render(item as Event)
//            is DayViewHolder -> holder.render(item as Day)
        }
    }

//    override fun getItemViewType(position: Int): Int {
//        return when (collection[position]) {
//            is Event -> EVENT
//            is Day -> DAY
//            else -> throw IllegalStateException("Unknown viewType ${collection[position].javaClass}")
//        }
//    }
//

    fun setSchedule(list: List<Event>) {
        collection.clear()
        collection.addAll(list)

        notifyDataSetChanged()
    }
}