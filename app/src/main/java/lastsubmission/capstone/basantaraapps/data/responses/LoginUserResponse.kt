package lastsubmission.capstone.basantaraapps.data.responses

import com.google.gson.annotations.SerializedName

data class LoginUserResponse(

	@field:SerializedName("password")
	val password: String,

	@field:SerializedName("email")
	val email: String
)
