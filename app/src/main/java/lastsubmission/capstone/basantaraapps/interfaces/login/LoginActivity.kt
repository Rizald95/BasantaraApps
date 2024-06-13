package lastsubmission.capstone.basantaraapps.interfaces.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.commit
import android.view.animation.AnimationUtils
import lastsubmission.capstone.basantaraapps.R
import lastsubmission.capstone.basantaraapps.data.dummy.LoginData
import lastsubmission.capstone.basantaraapps.databinding.ActivityLoginBinding
import lastsubmission.capstone.basantaraapps.helper.ViewModelFactory
import lastsubmission.capstone.basantaraapps.interfaces.home.ui.home.HomeFragment
import lastsubmission.capstone.basantaraapps.interfaces.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel by viewModels<LoginViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Terapkan animasi fade in pada komponen utama
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_anim)
        binding.tvLoginAccount.startAnimation(fadeInAnimation)
        binding.welcome.startAnimation(fadeInAnimation)
        binding.loginLayout.startAnimation(fadeInAnimation)
        binding.tvSignup.startAnimation(fadeInAnimation)
        binding.tvRegister.startAnimation(fadeInAnimation)

        binding.btnLogin.setOnClickListener {
            binding.btnLogin.setOnClickListener {
                val email = binding.etEmail.text.toString().trim()
                val password = binding.etPassword.text.toString().trim()

                if (validateLogin(email, password)) {
                    replaceHomeFragment()
                } else {
                    Toast.makeText(this, "Email atau Password salah", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.tvRegister.setOnClickListener {
            navigateToRegister()
        }

    }

    private fun navigateToRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun replaceHomeFragment() {
        supportFragmentManager.commit {
            replace(android.R.id.content, HomeFragment())
            setReorderingAllowed(true)
            addToBackStack(null)  // Optional: This allows the user to press Back to return to the login screen
        }
    }

    private fun validateLogin(email: String, password: String): Boolean {
        val loginData = LoginData.getLoginData()
        for (login in loginData) {
            if (login.email == email && login.password == password) {
                return true
            }
        }
        return false
    }
}