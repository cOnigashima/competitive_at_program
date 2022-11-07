package Rcrt

import retrofit2.http.GET
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.http.Query
import java.util.concurrent.TimeUnit


fun main(args: Array<String>) {
    val seed = readLine()!!
    val n = readLine()!!.toInt()


    fun askServer(n : Int):Int =
        ExampleRepositoryImpl().fetch(seed,n)

    fun recursiveN (n: Int) : Int{
        if (n % 2 == 0) {
            return recursiveN(n - 1) + recursiveN((n - 2) + recursiveN((n - 3) + recursiveN((n - 4)
        } else {
            return askServer(n)
        }
    }

    val result = recursiveN(n)
    println("Hello $result")
}




class ExampleRepositoryImpl  {
    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(getClient())
        .build()

    private fun getClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    private val service = retrofit.create(ExampleRemoteDataSource::class.java)

    fun fetch(seed: String, n: Int) = service.fetch(seed,n)


    companion object {
        private const val BASE_URL = "http://challenge-server.code-check.io"
    }
}

interface ExampleRemoteDataSource {
    @GET("/api/recursive/ask")
    suspend fun fetch(@Query("seed") seed: String, @Query("n") n: Int): ResponseSeed
}

data class ResponseSeed(
    val seed : String,
    val n : Int,
    val result :Int,
)