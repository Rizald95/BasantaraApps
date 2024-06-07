package lastsubmission.capstone.basantaraapps.interfaces.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lastsubmission.capstone.basantaraapps.R
import lastsubmission.capstone.basantaraapps.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.openBottomSheet.setOnClickListener {
            val bottomSheetFragment = BottomViewsFragment.newInstance("Deskripsi hasil penjelasan akan ditampilkan disini")
            bottomSheetFragment.show(supportFragmentManager,  BottomViewsFragment::class.java.simpleName)
        }
    }
}