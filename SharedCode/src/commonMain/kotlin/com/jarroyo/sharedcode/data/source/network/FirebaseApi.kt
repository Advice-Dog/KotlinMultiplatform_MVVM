package com.jarroyo.sharedcode.data.source.network

import co.touchlab.firebase.firestore.*
import com.jarroyo.sharedcode.domain.model.hackertracker.*
//import com.jarroyo.sharedcode.Firestore
import dev.icerock.moko.mvvm.livedata.MediatorLiveData
import io.ktor.util.Hash

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
                        0,
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

        instance.collection("conferences")
            .orderBy("start_date")
            .get_()
            .addListeners({
                val conferences = it.documents_.map {
                    Conference(
//                        it.get("id") as Long,
                        0,
                        it.get("name") as String,
                        it.get("code") as String
                    )
                }

                result.postValue(conferences)
            }, {

            })


        return result
    }

    fun getEvents() : MediatorLiveData<List<Event>> {
        val result = MediatorLiveData<List<Event>>(emptyList())

        instance.collection("conferences")
            .document("DEFCON27")
            .collection("events")
            .get_()
            .addListeners({
                val events = it.documents_.map {
                    Event(
//                        it.get("id") as Long,
                        0,
                        it.get("conference") as String,
                        it.get("title") as String,
                        it.get("description") as String,
                        type = getType(it.get("type") as HashMap<String, Any>),
                        location = getLocation(it.get("location") as HashMap<String, Any>)
                    )
                }

                result.postValue(events)
            }, {

            })

        return result
    }

    private fun getLocation(hashMap: HashMap<String, Any>): Location {
        return Location(
            name = hashMap.get("name") as String,
            hotel = hashMap.get("hotel") as? String?
        )
    }

    private fun getType(type: HashMap<String, Any>): Type {
        return Type(
            id = -1,
            name = type.get("name") as String,
            color = type.get("color") as String
        )
    }

}