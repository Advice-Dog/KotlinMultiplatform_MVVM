package com.jarroyo.sharedcode.viewModel

import com.jarroyo.sharedcode.data.source.network.FirebaseApi
import com.jarroyo.sharedcode.di.KodeinInjector
import com.jarroyo.sharedcode.domain.model.hackertracker.Article
import com.jarroyo.sharedcode.utils.coroutines.launchSilent
import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MediatorLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import org.kodein.di.Kodein
import org.kodein.di.erased.instance
import kotlin.coroutines.CoroutineContext

class HackerTrackerViewModel : ViewModel() {

    private val firebaseApi = FirebaseApi()

    private val articles = MediatorLiveData<List<Article>>(emptyList())
    fun getArticles() : LiveData<List<Article>> = articles

    init {
        firebaseApi.getArticles().addObserver {
            articles.postValue(it)
        }
    }
}