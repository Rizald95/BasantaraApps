package lastsubmission.capstone.basantaraapps.interfaces.home.ui.scanning

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lastsubmission.capstone.basantaraapps.repository.UserRepository

class ScanningViewModel(private val userRepository: UserRepository): ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}