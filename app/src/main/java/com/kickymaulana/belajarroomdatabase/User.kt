package com.kickymaulana.belajarroomdatabase

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("name")
    val firstName: String?,

    @SerializedName("username")
    val lastName: String?
)
