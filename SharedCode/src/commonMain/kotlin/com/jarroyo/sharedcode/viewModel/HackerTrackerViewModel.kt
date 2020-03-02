package com.jarroyo.sharedcode.viewModel

import com.jarroyo.sharedcode.data.source.network.FirebaseApi
import com.jarroyo.sharedcode.domain.model.hackertracker.Article
import com.jarroyo.sharedcode.domain.model.hackertracker.Conference
import com.jarroyo.sharedcode.domain.model.hackertracker.Event
import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MediatorLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel

class HackerTrackerViewModel : ViewModel() {

    private val firebaseApi = FirebaseApi()

    private val conferences = MediatorLiveData<List<Conference>>(emptyList())
    fun getConferences():LiveData<List<Conference>> = conferences

    private val articles = MediatorLiveData<List<Article>>(emptyList())
    fun getArticles() : LiveData<List<Article>> = articles

    private val events = MediatorLiveData<List<Event>>(emptyList())
    fun getSchedule(): LiveData<List<Event>> = events

    init {
        firebaseApi.getConferences().addObserver {
            conferences.postValue(it)
        }

        firebaseApi.getArticles().addObserver {
            articles.postValue(it)
        }

        firebaseApi.getEvents().addObserver {
            events.postValue(it)
        }
    }
}