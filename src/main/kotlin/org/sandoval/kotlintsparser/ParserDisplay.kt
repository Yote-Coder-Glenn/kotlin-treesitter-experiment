package org.sandoval.kotlintsparser

import org.springframework.stereotype.Component
import org.treesitter.*
import java.io.File


@Component
class ParserDisplay {

    fun parse(code: String): List<String> {

        val classloader = Thread.currentThread().contextClassLoader
        val f = classloader.getResource("test-files/main.js")
        val source = f.readText();

        val parser = TSParser()
        val jslang: TSLanguage = TreeSitterJavascript()
        parser.setLanguage(jslang)

        val tree = parser.parseString(null, source)
        val rootNode = tree.rootNode

        //tree.printDotGraphs(File(System.getProperty("user.dir"), "js.dot"))

        val query = TSQuery(
            jslang, """                
                (arrow_function) @function
                (function_expression) @function
                (function_declaration) @function
                (method_definition) @function
            """.trimIndent()
        )
        val cursor = TSQueryCursor()
        cursor.exec(query, rootNode)
        val match = TSQueryMatch()
        val matches = mutableListOf<String>()
        while (cursor.nextMatch(match)) {
            match.captures.forEach {
                val node = it.node

                val text = source.substring(node.startByte, node.endByte)
                matches.add(text)
                println("---")
                println(text)

            }
        }


        return matches
    }

}
