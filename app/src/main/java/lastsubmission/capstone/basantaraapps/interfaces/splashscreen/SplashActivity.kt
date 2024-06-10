package lastsubmission.capstone.basantaraapps.interfaces.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lastsubmission.capstone.basantaraapps.R
import lastsubmission.capstone.basantaraapps.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var  binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}