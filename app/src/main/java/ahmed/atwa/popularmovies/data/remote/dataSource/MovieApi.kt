package ahmed.atwa.popularmovies.data.remote.dataSource

import ahmed.atwa.popularmovies.data.remote.MovieRemote
import ahmed.atwa.popularmovies.data.remote.MovieResponse
import ahmed.atwa.popularmovies.presentation.commons.AppConstants.Companion.API_KEY_QUERY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

/**
 * Created by Ahmed Atwa on 10/19/18.
 */

@Singleton
interface MovieApi {


    companion object {

        const val POPULAR_MOVIES_QUERY: String = ("discover/movie?sort_by=popularity.desc")
    }



    @GET(POPULAR_MOVIES_QUERY)
    suspend fun getMostPopular(@Query(API_KEY_QUERY) apiKey: String): Response<MovieResponse>




}