package com.jarroyo.kmp_mvvm.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jarroyo.sharedcode.domain.model.hackertracker.Article

class HomeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val SKULL = 0
        private const val HEADER = 1
        private const val EVENT = 2
        private const val ARTICLE = 3
    }

    private val collection = ArrayList<Any>()

    override fun getItemViewType(position: Int): Int {
        if (position == 0)
            return SKULL

        return when (collection[position]) {
            is Article -> ARTICLE
            is String -> HEADER
            else -> EVENT
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            SKULL -> SkullHeaderViewHolder.inflate(parent)
//            HEADER -> HeaderViewHolder.inflate(parent)
//            EVENT -> EventViewHolder.inflate(parent, EventView.DISPLAY_MODE_MIN)
            ARTICLE -> ArticleViewHolder.inflate(parent)
            else -> throw IllegalStateException("Unknown viewType $viewType")
        }
    }
    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
//            is EventViewHolder -> holder.render(collection[position] as Event)
            is ArticleViewHolder -> holder.render(collection[position] as Article)
//            is HeaderViewHolder -> holder.render(collection[position] as String)
        }
    }

    fun setElements(list: List<Any>) {
        collection.clear()
        collection.addAll(listOf(SKULL) + list)
        notifyDataSetChanged()
    }

}
