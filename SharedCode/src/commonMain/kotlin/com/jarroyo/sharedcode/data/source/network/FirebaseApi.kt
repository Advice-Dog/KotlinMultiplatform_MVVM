package com.jarroyo.sharedcode.data.source.network

import co.touchlab.firebase.firestore.*
//import com.jarroyo.sharedcode.Firestore
import com.jarroyo.sharedcode.domain.model.hackertracker.Article
import com.jarroyo.sharedcode.domain.model.hackertracker.Conference
import dev.icerock.moko.mvvm.livedata.MediatorLiveData

class FirebaseApi {

//    private val firestore = Firestore.getInstance()

    val instance = getFirebaseInstance()

    fun getArticles() : MediatorLiveData<List<Article>> {
        val result = MediatorLiveData<List<Article>>(emptyList())

        instance.collection("conferences")
            .document("DEFCON27")
            .collection("articles")
            .get_()
            .addListeners({
                val articles = it.documents_.map {
                    Article(
//                        it.get("id") as Long,
                        0L,
                        it.get("name") as String,
                        it.get("text") as String
                    )
                }

                result.postValue(articles)
            }, {

            })

        return result
    }

    fun getConferences(): MediatorLiveData<List<Conference>> {
        val result = MediatorLiveData<List<Conference>>(emptyList())
//
//        firestore.collection("conferences")
//            .addSnapshotListener { snapshot, exception ->
//                snapshot.toObjects()
//            }
//


        return result
    }

}