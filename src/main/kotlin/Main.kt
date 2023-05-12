import opennlp.tools.postag.POSModel
import opennlp.tools.postag.POSTaggerME
import java.io.File

fun getWords(): Array<String> {
    val text = File("text.txt").readText()
    return text.split(Regex("\\W+")).filter { it.isNotEmpty() }.toTypedArray()
}

fun defineTags(words: Array<String>): Array<String> {
    return POSTaggerME(POSModel(File("models/en-pos-maxent.bin").inputStream())).tag(words)
}

fun countPOS(pos: Array<String>): Map<Char, Int> {
    return pos.groupingBy { it[0] }.eachCount()
}

fun main() {
    val countOfPOS = countPOS(defineTags(getWords()))
    println("Verb: ${countOfPOS['V']}")
    println("Adjective: ${countOfPOS['J']}")
    println("Adverb: ${countOfPOS['R']}")
}