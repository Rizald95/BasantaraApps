package lastsubmission.capstone.basantaraapps.data.preferences

data class UserModel (
    val email: String,
    val token: String,
    val isLogin: Boolean = false
)