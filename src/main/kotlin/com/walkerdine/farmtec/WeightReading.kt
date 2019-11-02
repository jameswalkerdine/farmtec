package com.walkerdine.farmtec

import java.sql.Timestamp
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class WeightReading(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0,
                val scaleId: String,
                val weight: Double,
                val timeStamp: Timestamp    = Timestamp(System.currentTimeMillis())     )