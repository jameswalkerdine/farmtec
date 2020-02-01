package com.walkerdine.farmtec


import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*

@RepositoryRestResource
interface RfidReadingRepository : CrudRepository<RfidReading, Long> {
    fun findByRfidReaderId(rfidReaderId: String): List<RfidReading>
    override fun findById(id: Long): Optional<RfidReading>
}