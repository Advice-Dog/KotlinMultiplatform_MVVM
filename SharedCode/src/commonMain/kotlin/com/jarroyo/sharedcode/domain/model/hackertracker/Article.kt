package com.jarroyo.sharedcode.domain.model.hackertracker

data class Article(val id: Long = -1, val name: String = "", val text: String = "")

data class Conference(val id: Int = -1, val name: String = "", val code: String = "")