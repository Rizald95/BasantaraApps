package lastsubmission.capstone.basantaraapps.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import lastsubmission.capstone.basantaraapps.data.preferences.UserModel
import lastsubmission.capstone.basantaraapps.data.preferences.UserModelPreferences
import lastsubmission.capstone.basantaraapps.data.responses.AlphabetResponse
import lastsubmission.capstone.basantaraapps.data.responses.AlphabetResponseItem
import lastsubmission.capstone.basantaraapps.data.retrofit.ApiService
import lastsubmission.capstone.basantaraapps.helper.Result
import kotlinx.coroutines.flow.Flow
import lastsubmission.capstone.basantaraapps.data.responses.LoginUserResponse
import lastsubmission.capstone.basantaraapps.data.responses.RegisterUserResponse

class UserRepository private constructor( private val userModelPreferences: UserModelPreferences, private val apiService: ApiService) {

    fun register(username: String, email: String, password: String): LiveData<Result<RegisterUserResponse>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)
        try {
            val response = apiService.register(username, email, password)
            emit(Result.Success(response))

        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

    fun login(email: String, password: String): LiveData<Result<LoginUserResponse>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)
        try {
            val response = apiService.login(email, password)
            emit(Result.Success(response))
        }catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }


    fun getListAlphabets(): LiveData<Result<List<AlphabetResponseItem>>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)
        try {
            val response = apiService.getAlphabetOptional()
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

    fun getListAlphabet(): LiveData<Result<AlphabetResponse>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)
        try {
            val response = apiService.getAlphabet()
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

    suspend fun logout() {
        userModelPreferences.logout()
    }

    fun getSession(): Flow<UserModel> {
        return userModelPreferences.getSession()
    }



    companion object {
        @Volatile
        private var instance : UserRepository? = null

        fun getInstance(userModelPreferences: UserModelPreferences, apiService: ApiService): UserRepository = instance ?: synchronized(this) {
            instance ?: UserRepository(userModelPreferences, apiService)
        }.also { instance = it }
    }
}