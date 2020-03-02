package com.jarroyo.sharedcode.domain.model.hackertracker

import kotlinx.serialization.Serializable

@Serializable
data class Type(
        val id: Int = -1,
        val name: String = "",
        val conference: String = "",
        val color: String = "#343434"
)