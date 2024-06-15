package lastsubmission.capstone.basantaraapps.data.retrofit

import lastsubmission.capstone.basantaraapps.data.responses.AlphabetRandomResponse
import lastsubmission.capstone.basantaraapps.data.responses.AlphabetResponse
import lastsubmission.capstone.basantaraapps.data.responses.AlphabetResponseItem
import lastsubmission.capstone.basantaraapps.data.responses.LoginUserResponse
import lastsubmission.capstone.basantaraapps.data.responses.RegisterUserResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService  {


    @FormUrlEncoded
    @POST("api/users/login")
    suspend fun login(
        @Field("email")
        email: String,

        @Field("password")
        password: String
    ) : LoginUserResponse

    @FormUrlEncoded
    @POST("api/users/register")
    suspend fun register(

        @Field("username")
        username: String,

        @Field("email")
        email: String,

        @Field("password")
        password: String
    ): RegisterUserResponse

    @GET("api/alphabets")
    suspend fun getAlphabet() : AlphabetResponse

    @GET("api/alphabets")
    suspend fun getAlphabetOptional(): List<AlphabetResponseItem>

    @GET("api/alphabets/random")
    suspend fun getAlphabetRandom(): AlphabetRandomResponse




}