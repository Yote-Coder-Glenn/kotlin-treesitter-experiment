package org.sandoval.kotlintsparser
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
class HelloWorldController(val parser: ParserDisplay) {
    @GetMapping("/")
    fun hello(): ResponseEntity<List<String>> {
        val matches = parser.parse("gff")
        return ResponseEntity.ok(matches)
    }
}
