package com.nagyrobi144.dogify.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class BreedImageResponse(
    @SerialName("message")
    val breedImageUrl: String
)