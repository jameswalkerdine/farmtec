package com.walkerdine.farmtec

import java.sql.Timestamp
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class RfidReading(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0,
                       val rfidReaderId: String,
                       val idRead: String,
                       val timeStamp: Timestamp    = Timestamp(System.currentTimeMillis())     )