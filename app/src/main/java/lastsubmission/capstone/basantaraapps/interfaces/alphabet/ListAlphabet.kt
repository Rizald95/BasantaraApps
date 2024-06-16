package lastsubmission.capstone.basantaraapps.interfaces.alphabet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lastsubmission.capstone.basantaraapps.R
import lastsubmission.capstone.basantaraapps.databinding.ActivityListAlphabetBinding

class ListAlphabet : AppCompatActivity() {
    private lateinit var binding:ActivityListAlphabetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListAlphabetBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}