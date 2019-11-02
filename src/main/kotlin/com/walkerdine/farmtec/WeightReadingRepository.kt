package com.walkerdine.farmtec


import org.springframework.data.repository.CrudRepository
import java.util.*

interface WeightReadingRepository : CrudRepository<WeightReading, Long> {
    fun findByScaleId(scaleId: String): List<WeightReading>
    override fun findById(id: Long): Optional<WeightReading>
}