package com.jarroyo.sharedcode.domain.model.hackertracker

import kotlinx.serialization.Serializable

@Serializable
data class Event(
        val id: Int = -1,
        val conference: String = "",
        val title: String = "",
        val description: String = "",
        val begin: String = "",
        val end: String = "",
        val link: String = "",
        val updated: String = "",
        val speakers: ArrayList<Speaker> = ArrayList(),
        val type: Type = Type(),
        val location: Location = Location(),
        val hidden: Boolean = false
)