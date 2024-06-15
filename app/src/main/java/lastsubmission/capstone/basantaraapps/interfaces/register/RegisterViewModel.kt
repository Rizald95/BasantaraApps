package lastsubmission.capstone.basantaraapps.interfaces.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import lastsubmission.capstone.basantaraapps.data.responses.RegisterUserResponse
import lastsubmission.capstone.basantaraapps.repository.UserRepository
import lastsubmission.capstone.basantaraapps.helper.Result

class RegisterViewModel(private val userRepository: UserRepository): ViewModel() {

    private val _register = MediatorLiveData<Result<RegisterUserResponse>>()
    val registerUser: LiveData<Result<RegisterUserResponse>> = _register

    fun register(username: String,email: String, password: String ) {
        val liveData = userRepository.register(username, email, password)
        _register.addSource(liveData) {
            result -> _register.value =result
        }
    }
}