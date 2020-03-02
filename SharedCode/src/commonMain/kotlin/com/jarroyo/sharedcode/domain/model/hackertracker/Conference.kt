package com.jarroyo.sharedcode.domain.model.hackertracker

import kotlinx.serialization.Serializable
import kotlin.collections.ArrayList

@Serializable
data class Conference(
        val id: Int = 0,
        val name: String = "",
        val description: String = "",
        val codeofconduct: String? = null,
        val code: String = "",
        val maps: ArrayList<Map> = ArrayList(),
        val start_date: String = "",
        val end_date: String = "",
//        val start_timestamp: Timestamp = Timestamp(Date()),
//        val end_timestamp: Timestamp = Timestamp(Date()),
        val timezone: String = "",
        val hidden: Boolean = false
)