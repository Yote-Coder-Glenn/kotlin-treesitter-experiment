package org.sandoval.kotlintsparser
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloWorldController(val parser: ParserDisplay) {
    @GetMapping("/")
    fun hello(): String {
        return parser.parse("gff")
    }
}