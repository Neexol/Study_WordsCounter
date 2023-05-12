import opennlp.tools.postag.POSModel
import opennlp.tools.postag.POSTaggerME
import java.io.File

fun getWords(): Array<String> {
    val text = File("text.txt").readText()
    return text.split(Regex("\\W+")).filter { it.isNotEmpty() }.toTypedArray()
}

fun getTags(words: Array<String>): Array<String> {
    return POSTaggerME(POSModel(File("models/en-pos-maxent.bin").inputStream())).tag(words)
}

fun main() {
    val countOfPOS = getTags(getWords()).groupingBy { it[0] }.eachCount()
    println("Verb: ${countOfPOS['V']}")
    println("Adjective: ${countOfPOS['J']}")
    println("Adverb: ${countOfPOS['R']}")
}