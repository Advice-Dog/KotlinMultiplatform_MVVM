package com.jarroyo.kmp_mvvm.ui

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.jarroyo.kmp_mvvm.R
import com.jarroyo.sharedcode.domain.model.hackertracker.Event
import kotlinx.android.synthetic.main.row_event.view.*

class EventView : FrameLayout {

    companion object {
        const val DISPLAY_MODE_MIN = 0
        const val DISPLAY_MODE_FULL = 1
    }

    var displayMode: Int = DISPLAY_MODE_MIN

    constructor(context: Context, attrs: AttributeSet? = null, display: Int = DISPLAY_MODE_MIN) : super(context, attrs) {
        displayMode = display
        init()
    }

    constructor(context: Context, event: Event, display: Int = DISPLAY_MODE_FULL) : super(context) {
        displayMode = display
        init()
        setContent(event)
    }

    private fun init() {
        inflate(context, R.layout.row_event, this)
        setDisplayMode()
    }

    fun setContent(event: Event) {
        render(event)
    }

    private fun setDisplayMode() {
        when (displayMode) {
            DISPLAY_MODE_MIN -> {
                val width = context.resources.getDimension(R.dimen.event_view_min_guideline).toInt()
                guideline.setGuidelineBegin(width)
                category_dot.visibility = View.GONE
                category_text.visibility = View.GONE
            }
            DISPLAY_MODE_FULL -> {
                val width = context.resources.getDimension(R.dimen.time_width).toInt()
                guideline.setGuidelineBegin(width)
                category_dot.visibility = View.VISIBLE
                category_text.visibility = View.VISIBLE
            }
        }
    }

    private fun render(event: Event) {
        title.text = event.title

        // Stage 2
        if (displayMode == DISPLAY_MODE_FULL) {
            location.text = event.location.name
        } else {
//            location.text = event.getFullTimeStamp(context) + " / " + event.location.name
        }


        renderCategoryColour(event)
        updateBookmark(event)

        setOnClickListener {
//            (context as? MainActivity)?.navigate(event)
        }

        star_bar.setOnClickListener {
            onBookmarkClick(event)
        }
    }

    private fun renderCategoryColour(event: Event) {
        val type = event.type

        category_text.text = type.name


        val color =
            Color.parseColor(type.color)

        category.setBackgroundColor(color)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val drawable = ContextCompat.getDrawable(context, R.drawable.chip_background)?.mutate()

            drawable?.setTint(color)
            category_dot.background = drawable
        }
    }


    private fun updateBookmark(event: Event) {
//        val isBookmarked = event.isBookmarked
//
        val drawable =
//            if (isBookmarked) {
//            R.drawable.ic_star_accent_24dp
//        } else {
            R.drawable.ic_star_border_white_24dp
//        }

        star_bar.setImageResource(drawable)
    }

    private fun onBookmarkClick(event: Event) {
//        event.isBookmarked = !event.isBookmarked
//        database.updateBookmark(event)
//
//        if(event.isBookmarked) {
//            reminder.setReminder(event)
//        } else {
//            reminder.cancel(event)
//        }
//
//        val action = if (event.isBookmarked) Analytics.EVENT_BOOKMARK else Analytics.EVENT_UNBOOKMARK
//        analytics.onEventAction(action, event)
//
//        updateBookmark(event)
    }
}
