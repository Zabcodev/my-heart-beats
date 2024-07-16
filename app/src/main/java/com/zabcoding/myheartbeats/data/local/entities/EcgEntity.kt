package com.zabcoding.myheartbeats.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zabcoding.myheartbeats.presentation.dashboard.model.EcgModel

@Entity(tableName = "ecg_data")
data class EcgEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("beatsPerMin") val bpm: Int,
    @ColumnInfo("highPass") val hpV1: Int
) {
    fun toDomain() = EcgModel(
        bpm = this.bpm,
        highPass = hpV1
    )
}
