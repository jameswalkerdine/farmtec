package com.walkerdine.farmtec


import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*

@RepositoryRestResource (collectionResourceRel = "weights", path = "weights")
interface WeightReadingRepository : PagingAndSortingRepository<WeightReading, Long> {
    fun findByScaleId(scaleId: String): List<WeightReading>
    override fun findById(id: Long): Optional<WeightReading>
}