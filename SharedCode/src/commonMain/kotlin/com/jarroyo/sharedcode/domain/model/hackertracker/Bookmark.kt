package com.jarroyo.sharedcode.domain.model.hackertracker

import kotlinx.serialization.Serializable

@Serializable
data class Bookmark(
        val id: String = "",
        val value: Boolean = false
)