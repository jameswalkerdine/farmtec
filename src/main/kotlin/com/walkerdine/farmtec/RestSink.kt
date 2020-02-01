package com.walkerdine.farmtec


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.config.annotation.CorsRegistry

@RestController
class WeightSink(private val weightReadingRepository: WeightReadingRepository){
    @GetMapping("/weightReading")
    fun greeting(@RequestParam(value = "weight") weight: Double, @RequestParam(value = "scaleId") scaleId: String) =
        run {
            val reading = WeightReading(scaleId = scaleId, weight = weight)
            weightReadingRepository.save(reading)
            reading
        }
}

@RestController
class RFIDSink(private val rfidReadingRepository: RfidReadingRepository){
    @GetMapping("/RFIDReading")
    fun greeting(@RequestParam(value = "rfidReaderId") readerId: String, @RequestParam(value = "idRead") idRead: String) =
        run {
            val reading = RfidReading(rfidReaderId = readerId,  idRead = idRead)
            rfidReadingRepository.save(reading)
            reading
        }

}
@RestController
class GetController(private val repository: RfidReadingRepository){
    @GetMapping("/RFIDS")
    fun findAll() = repository.findAll()
}

@RestController
class WeightGetController(private val repository: WeightReadingRepository){
    @GetMapping("/Weights")
    fun findAll() = repository.findAll()
}

fun addCorsMappings(registry: CorsRegistry) {
    registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
        .allowedOrigins("http://localhost:8080")
        .allowedHeaders(
            "Authorization",
            "Cache-Control",
            "Content-Type",
            "Accept",
            "X-Requested-With",
            "Access-Control-Allow-Origin",
            "Access-Control-Allow-Headers",
            "Origin"
        )
        .exposedHeaders(
            "Access-Control-Expose-Headers",
            "Authorization",
            "Cache-Control",
            "Content-Type",
            "Access-Control-Allow-Origin",
            "Access-Control-Allow-Headers",
            "Origin"
        )

}