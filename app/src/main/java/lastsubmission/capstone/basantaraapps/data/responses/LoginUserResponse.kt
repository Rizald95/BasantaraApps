package lastsubmission.capstone.basantaraapps.data.responses

import com.google.gson.annotations.SerializedName

data class LoginUserResponse(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
