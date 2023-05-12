import opennlp.tools.postag.POSModel
import opennlp.tools.postag.POSTaggerME
import java.io.File

fun main() {
    val text = "John has a sister named Penny."
    val tokens = text.split(Regex("\\W+")).filter { it.isNotEmpty() }.toTypedArray()
    val tags = POSTaggerME(POSModel(File("models/en-pos-maxent.bin").inputStream())).tag(tokens)
    println(tokens.zip(tags))
}