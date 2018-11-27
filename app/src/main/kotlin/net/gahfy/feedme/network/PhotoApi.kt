package net.gahfy.feedme.network

import io.reactivex.Observable
import net.gahfy.feedme.model.Photo
import retrofit2.http.GET

interface PhotoApi {
    @GET("/photos")
    fun getPhotos(): Observable<List<Photo>>
}