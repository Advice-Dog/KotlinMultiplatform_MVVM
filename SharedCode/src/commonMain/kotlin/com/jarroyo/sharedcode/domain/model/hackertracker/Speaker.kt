package com.jarroyo.sharedcode.domain.model.hackertracker

import kotlinx.serialization.Serializable

@Serializable
data class Speaker(
        val id: Int = -1,
        val name: String = "",
        val description: String = "",
        val link: String = "",
        val twitter: String = "",
        val title: String = "",
        val hidden: Boolean = false
)