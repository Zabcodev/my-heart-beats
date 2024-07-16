package com.zabcoding.myheartbeats.data.network.response

import com.zabcoding.myheartbeats.data.local.entities.EcgEntity

data class EcgResponse(
    val BeatsPerMin: Int? = null,
    val HighPassV1: Int? = null
) {
    fun toDatabase() = EcgEntity(
        bpm = this.BeatsPerMin!!,
        hpV1 = this.HighPassV1!!
    )
}
