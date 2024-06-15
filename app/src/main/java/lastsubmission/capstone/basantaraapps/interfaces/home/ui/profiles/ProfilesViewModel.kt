package lastsubmission.capstone.basantaraapps.interfaces.home.ui.profiles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lastsubmission.capstone.basantaraapps.repository.UserRepository

class ProfilesViewModel(private val userRepository: UserRepository): ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text
}