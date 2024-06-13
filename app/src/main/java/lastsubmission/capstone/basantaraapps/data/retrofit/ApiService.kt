package lastsubmission.capstone.basantaraapps.data.retrofit

import lastsubmission.capstone.basantaraapps.data.responses.AlphabetResponse
import lastsubmission.capstone.basantaraapps.data.responses.AlphabetResponseItem
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService  {


    @FormUrlEncoded
    @POST("api/login")
    suspend fun login(
        @Field("email")
        email: String,

        @Field("password")
        password: String
    )

    @FormUrlEncoded
    @POST("api/register")
    suspend fun register(

        @Field("name")
        name: String,

        @Field("email")
        email: String,

        @Field("password")
        password: String
    )

    @GET("api/alphabets")
    suspend fun getAlphabet() : AlphabetResponse

    @GET("api/alphabets")
    suspend fun getAlphabetOptional(): List<AlphabetResponseItem>


}