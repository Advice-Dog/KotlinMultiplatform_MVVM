package com.jarroyo.sharedcode

import com.jarroyo.sharedcode.domain.model.hackertracker.Article
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import kotlinx.serialization.StructureKind
import kotlin.reflect.KClass

//expect class Firestore {
//    companion object {
//        fun getInstance(): Firestore
//    }
//
//    fun getArticles(conference: String): MutableLiveData<List<Article>>
//
//    fun collection(collection: String):FirestoreCollection
//}
//
//expect class FirestoreDocument {
//    fun collection(collection: String): FirestoreCollection
//}
//
//expect class FirestoreCollection {
//    fun document(document: String): FirestoreDocument
//
//    fun addSnapshotListener(listener: (Snapshot, Exception) -> Unit)
//}
//
//expect class Snapshot <T>  {
//    fun toObjects(clazz: KClass<T>)
//}