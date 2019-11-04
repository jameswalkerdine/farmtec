package com.walkerdine.farmtec

import org.springframework.stereotype.Controller
import java.util.concurrent.atomic.AtomicLong
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.ui.Model





data class Greeting(val id: Long, val content: String)


@Controller
class GreetingController {

    @GetMapping("/greeting")
    fun greeting(
        @RequestParam(
            name = "name",
            required = false,
            defaultValue = "World"
        ) name: String, model: Model
    ): String {
        model.addAttribute("name", name)
        return "greeting"
    }

}




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