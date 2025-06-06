package tv.purple.monolith.component.api.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import tv.purple.monolith.models.retrofit.alejo.PronounItemData
import tv.purple.monolith.models.retrofit.alejo.UserPronounData

interface PronounsApi {
    @GET("/api/pronouns")
    fun pronouns(): Single<List<PronounItemData>>

    @GET("/api/users/{login}")
    fun getUserPronoun(@Path("login") userName: String): Single<List<UserPronounData>>
}