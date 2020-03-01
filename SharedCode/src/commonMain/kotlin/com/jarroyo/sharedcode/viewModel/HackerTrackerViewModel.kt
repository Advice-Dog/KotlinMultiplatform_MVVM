package com.jarroyo.sharedcode.viewModel

import com.jarroyo.sharedcode.domain.model.hackertracker.Article
import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MediatorLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel

class HackerTrackerViewModel : ViewModel() {

    private val articles = MediatorLiveData<List<Article>>(emptyList())

    fun getArticles() : LiveData<List<Article>> = articles


    init {

        articles.postValue(listOf(
            Article(0, "Welcome", "Welcome message")
        ))

    }


}