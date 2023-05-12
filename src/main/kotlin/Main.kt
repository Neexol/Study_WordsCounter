import opennlp.tools.postag.POSModel
import opennlp.tools.postag.POSTaggerME
import java.io.File

fun getWordsFromFile(file: File): Array<String> {
    return file.readText().split(Regex("\\W+")).filter { it.isNotEmpty() }.toTypedArray()
}

fun defineTags(words: Array<String>): Array<String> {
    return POSTaggerME(POSModel(File("models/en-pos-maxent.bin").inputStream())).tag(words)
}

fun countPOS(pos: Array<String>): Map<Char, Int> {
    return pos.groupingBy { it[0] }.eachCount()
}

fun main() {
    val countOfPOS = countPOS(defineTags(getWordsFromFile(File("text.txt"))))
    println("Verb: ${countOfPOS['V']}")
    println("Adjective: ${countOfPOS['J']}")
    println("Adverb: ${countOfPOS['R']}")
}