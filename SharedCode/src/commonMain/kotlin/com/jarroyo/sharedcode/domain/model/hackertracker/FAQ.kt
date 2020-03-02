package com.jarroyo.sharedcode.domain.model.hackertracker

import kotlinx.serialization.Serializable

@Serializable
data class FAQ(
        val id: Int = -1,
        val conference: String = "",
        val question: String = "",
        val answer: String = "")