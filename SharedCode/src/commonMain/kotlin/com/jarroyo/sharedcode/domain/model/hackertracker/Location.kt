package com.jarroyo.sharedcode.domain.model.hackertracker

import kotlinx.serialization.Serializable

@Serializable
data class Location(
        val name: String = "",
        val hotel: String? = null,
        val conference: String = ""
)