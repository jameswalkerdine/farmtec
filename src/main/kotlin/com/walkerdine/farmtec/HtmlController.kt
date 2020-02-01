package com.walkerdine.farmtec

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam




class HtmlController2 {

    @GetMapping("/xyz")
    fun blog(model: Model): String {
        model["title"] = "Blog"
        return "blog"
    }

    @GetMapping("/hello")
    fun mainWithParam(
        @RequestParam(name = "name", required = false, defaultValue = "hello")
        name: String, model: Model
    ): String {

        model.addAttribute("message", name)

        return "welcome" //view
    }


}