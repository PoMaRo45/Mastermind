import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MasterMind_polMartinezKtTest {
    @Test
    fun checkIfFunPrintColorsReturnRed () {
        val color = "vermell"
        val expected = "\uD83D\uDD34 "
        assertEquals(expected, printColores(color) )
    }
    @Test
    fun checkIfFunPrintColorsReturnYellow () {
        val color = "groc"
        val expected = "\uD83D\uDFE1 "
        assertEquals(expected, printColores(color) )
    }
    @Test
    fun checkIfFunPrintColorsReturnBlue () {
        val color = "blau"
        val expected = "\uD83D\uDD35 "
        assertEquals(expected, printColores(color) )
    }
    @Test
    fun checkIfFunPrintColorsReturnPurple () {
        val color = "lila"
        val expected = "\uD83D\uDFE3 "
        assertEquals(expected, printColores(color) )
    }
    @Test
    fun checkIfFunPrintColorsReturnGreen () {
        val color = "verd"
        val expected = "\uD83D\uDFE2 "
        assertEquals(expected, printColores(color) )
    }
    @Test
    fun checkIfAlluserSequenceIsGood () {
        val expected = mutableListOf<String>("✅", "✅", "✅", "✅")
        val userInput = mutableListOf<String>("groc", "lila", "lila", "verd")
        val sequence = mutableListOf<String>("groc", "lila", "lila", "verd")
        assertEquals(expected, sequenceCheker(userInput, sequence))
    }
    @Test
    fun checkIfAlluserSequenceIsBadPositioned () {
        val expected = mutableListOf<String>("\uD83D\uDD01", "\uD83D\uDD01", "\uD83D\uDD01", "\uD83D\uDD01")
        val userInput = mutableListOf<String>("blau", "verd", "vermell", "blau")
        val sequence = mutableListOf<String>("verd", "vermell", "blau", "verd")
        assertEquals(expected, sequenceCheker(userInput, sequence))
    }
    @Test
    fun checkIfAlluserSequenceIsWrong () {
        val expected = mutableListOf<String>("🚫", "🚫", "🚫", "🚫")
        val userInput = mutableListOf<String>("lila", "groc", "groc", "blau")
        val sequence = mutableListOf<String>("verd", "vermell", "verd", "verd")
        assertEquals(expected, sequenceCheker(userInput, sequence))
    }
    @Test
    fun checkIfuserInputIsMediumWellAndMediumBadPositioned () {
        val expected = mutableListOf<String>("\uD83D\uDD01", "✅", "\uD83D\uDD01", "✅")
        val userInput = mutableListOf<String>("verd", "groc", "vermell", "blau")
        val sequence = mutableListOf<String>("vermell", "groc", "verd", "blau")
        assertEquals(expected, sequenceCheker(userInput, sequence))
    }
    @Test
    fun checkIfuserInputIsMediumWrongAndMediumBadPositioned () {
        val expected = mutableListOf<String>("\uD83D\uDD01", "🚫", "\uD83D\uDD01", "🚫")
        val userInput = mutableListOf<String>("verd", "groc", "vermell", "blau")
        val sequence = mutableListOf<String>("vermell", "lila", "verd", "vermell")
        assertEquals(expected, sequenceCheker(userInput, sequence))
    }
    @Test
    fun checkIfuserInputIsFullOfOneColor () {
        val expected = mutableListOf<String>("\uD83D\uDEAB", "✅", "✅", "🚫")
        val userInput = mutableListOf<String>("verd", "verd", "verd", "verd")
        val sequence = mutableListOf<String>("vermell", "verd", "verd", "groc")
        assertEquals(expected, sequenceCheker(userInput, sequence))
    }
    @Test
    fun checkIfConditionIsNotAnOption () {
        val expected = "error"
        val condition = 3
        val input = "si"
        val message = "Introdueix CONTINUE quan estiguis preparat"
        val first = "SI"
        val second = "NO"
        assertEquals(expected, inputChecker(condition, input, message, first, second))
    }
    @Test
    fun checkIfTheWordIsWellFromTheBeggining () {
        val expected = "SI"
        val condition = 2
        val input = "SI"
        val message = "Introdueix CONTINUE quan estiguis preparat"
        val first = "SI"
        val second = "NO"
        assertEquals(expected, inputChecker(condition, input, message, first, second))
    }
}
