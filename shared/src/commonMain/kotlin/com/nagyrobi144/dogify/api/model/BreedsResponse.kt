package com.nagyrobi144.dogify.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
internal data class BreedsResponse(@SerialName("message") val breeds: List<String>)