import opennlp.tools.postag.POSModel
import opennlp.tools.postag.POSTaggerME
import java.io.File

fun getWordsFromFile(text: String): Array<String> {
    return text.split(Regex("\\W+")).filter { it.isNotEmpty() }.toTypedArray()
}

fun defineTags(words: Array<String>): Array<String> {
    return POSTaggerME(POSModel(File("models/en-pos-maxent.bin").inputStream())).tag(words)
}

fun countPOS(pos: Array<String>): Map<Char, Int> {
    return pos.groupingBy { it[0] }.eachCount()
}

fun main() {
    val posToCount = countPOS(defineTags(getWordsFromFile(File("text.txt").readText())))
    println("Verb: ${posToCount['V']}")
    println("Adjective: ${posToCount['J']}")
    println("Adverb: ${posToCount['R']}")
}