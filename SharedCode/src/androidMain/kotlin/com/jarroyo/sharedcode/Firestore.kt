package com.jarroyo.sharedcode

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.jarroyo.sharedcode.domain.model.hackertracker.Article
import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MutableLiveData

//actual class Firestore {
//
//    private val firestore = FirebaseFirestore.getInstance()
//
//    actual companion object {
//
//        private val instance: Firestore = Firestore()
//
//        actual fun getInstance() = instance
//    }
//
//    actual fun getArticles(conference: String): MutableLiveData<List<Article>> {
//        val results = MutableLiveData<List<Article>>(emptyList())
//
//        firestore.collection("conferences")
//            .document(conference)
//            .collection("articles")
//            .orderBy("updated_at", Query.Direction.DESCENDING)
//            .addSnapshotListener { snapshot, exception ->
//                if (exception == null) {
//                    val articles = snapshot?.toObjects(Article::class.java) ?: emptyList()
//                    results.postValue(articles)
//                }
//
//            }
//
//        return results
//    }
//
//    actual fun collection(collection: String): FirestoreCollection {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//}