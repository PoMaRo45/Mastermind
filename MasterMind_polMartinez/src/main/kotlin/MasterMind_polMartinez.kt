//Projecte MasterMind
//Author : Pol Martínez
import java.util.*

const val RESET = "\u001B[0m"
const val FANTASY = "\u001B[48;5;240m"

/**
 * That funtion print on the terminal the instructions of the Masetermind.
 *
 */
fun instrucciones(){
   println ("!! MasterMind ¡¡\n")
   println ("Abans de començar a jugar farem una breu explicació de com funciona el joc:")
   println("El joc consisteix en endivinar la possició en la qual es troben els colors. Hi han 4 possicions en les quals poden haver-hi colors i 5 diferents colors: ")
   print("\t\t\t\uD83D\uDD34  (vermell), ")
   print ("\uD83D\uDFE2  (verd), ")
   print ("\uD83D\uDD35  (blau), ")
   print ("\uD83D\uDFE1 (groc) i ")
   println ("\uD83D\uDFE3 (lila).")
   println("")
   println ("Una vegada feta la introducció passem a les normes i funcionament:")
   println(""" - En la secuencia de colors es poden trobar colors repetits.
 - Per cada posició tindras un comprovador el qual tindra 3 senyals difrents per que sapigues si vas en bon camí: 
            - 🚫 Aquest simból a la posició d'un color significa que aquest color no es troba a la sequencia o que  has colocat el mateix color de manera correcte i no es troba a cap possició més.
            - 🔁 Aquest simból a la posició d'un color significa que aquest color es troba a la sequencia, pero no a la possició que has escollit.
            - ✅ Aquest simból a la posició d'un color significa que aquest color es troba a la sequencia i a la possició que has escollit.
 -La partida consisteix de 6 torns, en cas de no arribar a completar la seqüéncia haurás perdut.
 -Haurás d'introduir el nom dels colors en minuscules .
 """)
   print("Per simplificar la jugavilitat abans de confirmar la jugada t'apareixerà una representació amb els colors introduits,\n" +
           "en cas de que volguis corregir algo abans d'enviar la jugada haurás d'escriure NO sino SI.")

}

/**
 * Creates a visual box of tabs that have a background color to simulate an interface of the videogames rounds
 * counting the round which is playing the user and then printing the userName, the user's selection and the verification of the selection's from a list.
 *
 * @param {userName} string THe name of whose playing.
 * @param {times} number The round that's playing the user.
 * @param {userComprovationsList} List<String> The list that contains the symbols of the comprovations.
 * @param {userSelectionsList} List<String> The list that contains every selection of the user on the match.
 *
 */
fun interficie(userName:String, times:Int, userComprovationsList:MutableList<MutableList<String>>, userSelectionsList:MutableList<MutableList<String>>){
   println(FANTASY + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + RESET)
   println(FANTASY + "\t" + RESET + "\t\t\t\t\t\t\t\t\t\t\t\t" + FANTASY + "\t" + RESET)
   println(FANTASY + "\t" + RESET + "\t\t\t\t\t  $userName\t\t\t\t\t\t" + FANTASY + "\t" + RESET)
   println(FANTASY + "\t" + RESET + "\t\t\t\t\t\t\t\t\t\t\t\t" + FANTASY + "\t" + RESET)
   println(FANTASY + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + RESET )

   for (i in 0 until times){
      println(FANTASY + "\t" + RESET + "\t\t\t\t" +FANTASY +"\t"+ RESET + "\t\t\t\t\t\t\t" + FANTASY + "\t" + RESET)
      print(FANTASY + "\t" + RESET)
      print("  ")
      for (j in 0..3){
         print("${ userComprovationsList[i][j] } ")
      }
      print("\t")
      print(FANTASY +" \t"+ RESET )
      print("  ")
      for (j in 0 .. 3){
         print("  ")
         print(printColores(userSelectionsList[i][j]))
         print(" ")
      }
      print("\t")
      println(FANTASY + " \t" + RESET)
      println(FANTASY + "\t" + RESET + "\t\t\t\t" +FANTASY +"\t"+ RESET + "\t\t\t\t\t\t\t" + FANTASY + "\t" + RESET)
      println(FANTASY + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + RESET )
   }
}
/**
 *  A function that check if the input of the user is inside the options that needs the program, and if it's not inside it will demands a input, and don't stop executing
 *  until the input is valid.
 *
 *  @param {condition} int Determines how many arguments have to compare
 *  @param {input} string The input of the user
 *  @param {message} string The text that prints if the input is wrong
 *  @param {first} string One of the strings to compare with the input
 *  @param {second} string The other string to compare with the input
 *
 *  @return Returns a valid input
 */
fun inputChecker (condition : Int, input:String, message:String, first:String, second:String):String {
   val scanner = Scanner(System.`in`)
   var inputReworked = input
   when (condition) {
      1-> {
         if (input != first){
            do {
               println(message)
               inputReworked = scanner.next()
            }while (inputReworked.uppercase() != first)
            return inputReworked
         }
         return input
      }
      2 -> {
         if (input != first && input != second){
            do {
               println(message)
               inputReworked = scanner.next()
            }while (inputReworked.uppercase() != first && inputReworked.uppercase() != second)
            return inputReworked
         }
         return input
      }
   }
   return "error"
}
/**
 * Gets the color selectioned from the user and returns a emote color in string format
 *
 * @param {userSelection} string The name of the color selectioned for the user
 * @return {String} Returns a string of the user's color selection
 */
fun printColores(userSelection:String): String {
   when(userSelection){
      "vermell" -> return "\uD83D\uDD34 "
      "groc" -> return ( "\uD83D\uDFE1 ")
      "blau" -> return ( "\uD83D\uDD35 ")
      "lila" -> return ( "\uD83D\uDFE3 ")
      "verd" -> return ( "\uD83D\uDFE2 ")
   }
   return "error"
}
/**
 *  A function that check the user input compared to the sequence and returns the list of emotes to print.
 *
 *  @param {userSelectionsList} MutableList<String> The list of selections of the user
 *  @param {sequencia} MutableList<String> The sequence of the match on a list
 *
 *  @return {userComprovationsList} A list that contains the results of the round ready to print
 */
fun sequenceCheker (userSelectionsList: MutableList<String>, sequencia:MutableList<String>): MutableList<String> {
    val userComprovationsList = MutableList(4){""}
   var remain = mutableListOf<String>()
   for (j in 0..3){
      if (userSelectionsList[j] == sequencia[j]){
         userComprovationsList[j] = "✅"
      }
      else remain.add(sequencia[j])
   }
   for (j in 0..3){
      if (userSelectionsList[j] in remain && userComprovationsList[j] == "") userComprovationsList[j] = "\uD83D\uDD01"
      else if (userSelectionsList[j] !in remain && userComprovationsList[j] == "") userComprovationsList[j] = "\uD83D\uDEAB"
   }
   return userComprovationsList
}

/**
 * The function main is where all the game is executed, here there are three parts, first the welcome to the user,
 * second the sequence generator and the last part is the user match.
 */
fun main() {
   val scanner = Scanner(System.`in`).useLocale(Locale.UK)
   var userSelectionsList : MutableList<MutableList<String>>
   var userComprovationsList : MutableList<MutableList<String>>
   var userSelection:String
   println("Introdueix un username de 5 caracters:")
   var userName = scanner.next()
   if (userName.length != 5){
      do {
         println("Introdueix un username de 5 caracters:")
         userName = scanner.next()
      }while (userName.length != 5)
   }
   // BENVINGUDA A L'USUARI ----------------------------------------------------------------------------------
   println("Benvingut $userName a Mastermind \n Per començar a jugar introdueix CONTINUE, si no saps jugar introdueix HELP")
   do {
      var start = scanner.next().uppercase()
      if (start=="HELP"){
         instrucciones()
         println("\n\n Introdueix CONTINUE quan estiguis preparat")
         start = scanner.next().uppercase()
         start = inputChecker(1, start, "Introdueix CONTINUE quan estiguis preparat", "CONTINUE", "")
      }
      else if (start!="CONTINUE"){
         println("Per començar a jugar introdueix CONTINUE, si no saps jugar introdueix HELP")
      }
   }while (start!="CONTINUE")
   //--------------------------------------------------------------------------------------------------------
   do{
      //GENERADOR DE LA SEQÜENCIA-------------------------------------------------------------------------------
      var colores = mutableListOf("vermell","verd", "groc", "blau", "lila")
      var rnd: Int
      var sequencia = MutableList(4) {""}
      for (i in 0..3){
         rnd = (0..4).random()
         sequencia[i]= colores[rnd]
      }
      // RONDAS DE PARTIDA ---------------------------------------------------------------------------------------
      userSelectionsList = mutableListOf()
      userComprovationsList = mutableListOf()
      var restart = ""
      for (i in 0..5){
         userSelectionsList.add(mutableListOf())
         do {
            userSelectionsList[i] = mutableListOf()
            println("RONDA ${i+1}: ")
            for (j in 0..3){
               println("COLOR ${j+1}:")
               userSelection = scanner.next()
               if (!(colores.contains(userSelection))) {
                  do {
                     println("Introdueix un color vàlid")
                     userSelection = scanner.next()
                  }while (!(colores.contains(userSelection)) )
               }
               userSelectionsList[i].add(userSelection)
            }
            for (j in 0..3){
               print("${printColores(userSelectionsList[i][j])} ")
            }
            println("\n Es aquesta la seqüéncia que volias posar? \n Escriu SI / NO")
            var sentenceConfirmation = scanner.next().uppercase()
            sentenceConfirmation = inputChecker(2, sentenceConfirmation, "Introdueix una de les opcions", "SI", "NO")
         }while (sentenceConfirmation.uppercase() !="SI")
         println()
         userComprovationsList.add(sequenceCheker(userSelectionsList[i], sequencia))
         interficie(userName, i+1, userComprovationsList, userSelectionsList)
         if (userSelectionsList[i] == sequencia) {
            println("\n Has encertat enhorabona!! \n " +
                    "Si vols tornar a jugar NEW, si vols sortir EXIT.")
            val final = scanner.next().uppercase()
            restart = inputChecker(2, final, "Introdueix una de les opcions", "NEW", "EXIT")
            break
         }
         if (i==5){
            println("\n Has perdut :( \n " +
                    "Si vols tornar a jugar NEW, si vols sortir EXIT.")
            val final = scanner.next().uppercase()
            restart = inputChecker(2, final, "Introdueix una de les opcions", "NEW", "EXIT")
         }
      }
   }while (restart.uppercase()!= "EXIT")
   //-------------------------------------------------------------------------------------------------------
}