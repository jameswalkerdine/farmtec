package com.walkerdine.farmtec


import org.springframework.data.repository.CrudRepository
import java.util.*

interface RfidReadingRepository : CrudRepository<RfidReading, Long> {
    fun findByRfidReaderId(rfidReaderId: String): List<RfidReading>
    override fun findById(id: Long): Optional<RfidReading>
}