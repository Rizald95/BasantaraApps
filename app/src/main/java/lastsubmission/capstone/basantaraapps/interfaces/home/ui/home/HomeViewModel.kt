package lastsubmission.capstone.basantaraapps.interfaces.home.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lastsubmission.capstone.basantaraapps.repository.UserRepository

class HomeViewModel(private val userRepository: UserRepository): ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}