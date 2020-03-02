package com.jarroyo.sharedcode.domain.model.hackertracker

import kotlinx.serialization.Serializable

@Serializable
data class Map(
        val name: String = "",
        val file: String = ""
)