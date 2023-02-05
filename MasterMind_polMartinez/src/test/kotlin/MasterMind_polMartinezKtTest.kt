import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

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
    fun checkIfFunPrintColorsReturnBrown () {
        val color = "marró"
        val expected = "\uD83D\uDFE4 "
        assertEquals(expected, printColores(color) )
    }
    @Test
    fun checkIfFunPrintColorsReturnOrange () {
        val color = "taronja"
        val expected = "\uD83D\uDFE0 "
        assertEquals(expected, printColores(color) )
    }
    @Test
    fun checkIfAlluserSequenceIsGood () {
        val expected = mutableListOf<String>("✅", "✅", "✅", "✅")
        val userInput = mutableListOf<String>("groc", "lila", "lila", "verd")
        val sequence = mutableListOf<String>("groc", "lila", "lila", "verd")
        assertEquals(expected, sequenceCheker(userInput, sequence, 4))
    }
    @Test
    fun checkIfAlluserSequenceIsGoodIn777Mode () {
        val expected = mutableListOf<String>("✅", "✅", "✅", "✅", "✅","✅","✅")
        val userInput = mutableListOf<String>("groc", "lila", "lila", "verd", "lila", "verd", "lila")
        val sequence = mutableListOf<String>("groc", "lila", "lila", "verd", "lila", "verd", "lila")
        assertEquals(expected, sequenceCheker(userInput, sequence, 7))
    }
    @Test
    fun checkIfAlluserSequenceIsBadPositioned () {
        val expected = mutableListOf<String>("\uD83D\uDD01", "\uD83D\uDD01", "\uD83D\uDD01", "\uD83D\uDD01")
        val userInput = mutableListOf<String>("blau", "verd", "vermell", "blau")
        val sequence = mutableListOf<String>("verd", "vermell", "blau", "verd")
        assertEquals(expected, sequenceCheker(userInput, sequence, 4))
    }
    @Test
    fun checkIfAlluserSequenceIsWrong () {
        val expected = mutableListOf<String>("🚫", "🚫", "🚫", "🚫")
        val userInput = mutableListOf<String>("lila", "groc", "groc", "blau")
        val sequence = mutableListOf<String>("verd", "vermell", "verd", "verd")
        assertEquals(expected, sequenceCheker(userInput, sequence, 4))
    }
    fun checkIfAlluserSequenceIsWrongIn777Mode () {
        val expected = mutableListOf<String>("🚫", "🚫", "🚫", "🚫", "🚫", "🚫", "🚫")
        val userInput = mutableListOf<String>("lila", "groc", "groc", "blau", "groc", "groc", "blau")
        val sequence = mutableListOf<String>("verd", "vermell", "verd", "verd", "vermell", "verd", "verd")
        assertEquals(expected, sequenceCheker(userInput, sequence, 4))
    }
    @Test
    fun checkIfuserInputIsMediumWellAndMediumBadPositioned () {
        val expected = mutableListOf<String>("\uD83D\uDD01", "✅", "\uD83D\uDD01", "✅")
        val userInput = mutableListOf<String>("verd", "groc", "vermell", "blau")
        val sequence = mutableListOf<String>("vermell", "groc", "verd", "blau")
        assertEquals(expected, sequenceCheker(userInput, sequence, 4))
    }
    @Test
    fun checkIfuserInputIsMediumWrongAndMediumBadPositioned () {
        val expected = mutableListOf<String>("\uD83D\uDD01", "🚫", "\uD83D\uDD01", "🚫")
        val userInput = mutableListOf<String>("verd", "groc", "vermell", "blau")
        val sequence = mutableListOf<String>("vermell", "lila", "verd", "vermell")
        assertEquals(expected, sequenceCheker(userInput, sequence, 4))
    }
    @Test
    fun checkIfuserInputIsFullOfOneColor () {
        val expected = mutableListOf<String>("\uD83D\uDEAB", "✅", "✅", "🚫")
        val userInput = mutableListOf<String>("verd", "verd", "verd", "verd")
        val sequence = mutableListOf<String>("vermell", "verd", "verd", "groc")
        assertEquals(expected, sequenceCheker(userInput, sequence,4))
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
    @Test
    fun checkIfTheUserExists () {
        val expected = mutableListOf<String>("marto", "colinabo")
        assertEquals(expected, checkUser("marto"))
    }
    @Test
    fun checkIfTheUserDoNotExists () {
        val expected = mutableListOf<String>()
        assertEquals(expected, checkUser("martin"))
    }
    @Test
    fun checkIfModeDoNotExists () {
        val expected = ""
        assertEquals(expected, formaterToSave("marto",5,3, LocalDateTime.now()))
    }
    @Test
    fun checkIfAllDateIsWell () {
        val expected = "marto,2,true,3,,${LocalDateTime.now()}"
        assertEquals(expected, formaterToSave("marto",2,3, LocalDateTime.now()))
        //Falla perque quan es produeixen els calculs hi han milesimes de diferencia
    }
    @Test
    fun checkIfTheRankingModeSelectedIs1 () {
        val expected = "\t${bold}USUARIO\t INTENTOS$RESET\n" +
                "1.    marto\t\t3\n" +
                "2.    marto\t\t4\n" +
                "3.    imto\t\t6\n"
        assertEquals(expected, rankingModes("1"))
    }
    @Test
    fun checkIfTheRankingModeSelectedIs2 () {
        val expected = "\t${bold}USUARIO\t INTENTOS$RESET\n" +
                "1.    marto\t\t2\n"
        assertEquals(expected, rankingModes("2"))
    }
    @Test
    fun checkIfTheRankingModeSelectedIs3 () {
        val expected = "\t${bold}USUARIO\t INTENTOS\t TIEMPO$RESET\n" +
                "1.    marto\t\t1\t\t 23\n" +
                "2.    mimo\t\t1\t\t 25\n" +
                "3.    ivan\t\t1\t\t 32\n"
        assertEquals(expected, rankingModes("3"))
    }
    @Test
    fun checkIfRankingModeSelectedDoNotExists () {
        val expected = "$BACK_YELLOW$BLACK$bold ${"NO HI HAN DADES SOBRE CAP PARTIDA REALITZADA EL MODE SELECCIONAT".uppercase()} $RESET\n"
        assertEquals(expected, rankingModes("4"))
    }
    @Test
    fun checkOrderByTime () {
        val partidas = mutableListOf<MutableList<String>>(mutableListOf("","","","2","40"),mutableListOf("","","","2","30"),mutableListOf("","","","1","250"),mutableListOf("","","","3","10"))
        val expected = mutableListOf<MutableList<String>>(mutableListOf("","","","1","250"),mutableListOf("","","","2","30"),mutableListOf("","","","2","40"),mutableListOf("","","","3","10"))
        assertEquals(expected, ordenarPorTiempo(partidas))
    }
    @Test
    fun checkOrder () {
        val partidas = mutableListOf<MutableList<String>>(mutableListOf("","","","2","40"),mutableListOf("","","","2","30"),mutableListOf("","","","1","250"),mutableListOf("","","","3","10"))
        val expected = mutableListOf<MutableList<String>>(mutableListOf("","","","1","250"),mutableListOf("","","","2","40"),mutableListOf("","","","2","30"),mutableListOf("","","","3","10"))
        assertEquals(expected, ordenarRanking(partidas, 6))
    }
    @Test
    fun checkIfInputIs3 (){
        val expected = "groc"
        val input = "3"
        assertEquals(expected, inputFormater(input))
    }
    @Test
    fun checkIfInputIsm (){
        val expected = "marró"
        val input = "m"
        assertEquals(expected, inputFormater(input))
    }
    @Test
    fun checkIfInputIsg (){
        val expected = "verd"
        val input = "g"
        assertEquals(expected, inputFormater(input))
    }
}
