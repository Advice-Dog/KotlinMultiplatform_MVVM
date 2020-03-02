package com.jarroyo.sharedcode.domain.model.hackertracker

import kotlinx.serialization.Serializable

@Serializable
data class Article(
        val id: Int = -1,
        val name: String = "",
        val text: String = "",
        val hidden: Boolean = false
)