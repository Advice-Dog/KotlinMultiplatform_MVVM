package com.jarroyo.sharedcode.domain.model.hackertracker

import kotlinx.serialization.Serializable

@Serializable
data class Vendor(
        val id: Int = -1,
        val name: String = "",
        val description: String? = null,
        val link: String? = null,
        val partner: Boolean = false,
        val updatedAt: String = "",
        val conference: String = "",
        val hidden: Boolean = false
)

