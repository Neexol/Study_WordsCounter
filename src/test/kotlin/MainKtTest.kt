import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class MainKtTest {
    @Test
    fun test_getWordsFromFile() {
        val text = "Frankly speaking, I do not care about it. \n Hello world!"
        val expected = text.split(Regex("\\W+")).filter { it.isNotEmpty() }.toTypedArray()
        assertContentEquals(expected, getWordsFromFile(text))
    }

    @Test
    fun test_defineTags() {
        val words = arrayOf("I", "do", "not", "care", "about", "this", "red", "symbols")
        val expected = arrayOf("PRP", "VBP", "RB", "VB", "IN", "DT", "JJ", "NNS")
        assertContentEquals(expected, defineTags(words))
    }

    @Test
    fun test_countPOS() {
        val tags = arrayOf("JD", "VXP", "RB", "VB", "VKJ", "RB", "JJ", "JJ")
        val expected = tags.groupingBy { it[0] }.eachCount()
        assertEquals(expected, countPOS(tags))
    }
}