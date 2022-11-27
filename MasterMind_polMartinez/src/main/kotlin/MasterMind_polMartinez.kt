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
   println(""" - En la secuencia de colors no es trobará cap color repetit.
 - Per cada posició tindras un comprovador el qual tindra 3 senyals difrents per que sapigues si vas en bon camí: 
            - ❎ Aquest simból a la posició d'un color significa que aquest color no es troba a la sequencia.
            - 🔁 Aquest simból a la posició d'un color significa que aquest color es troba a la sequencia, pero no a la possició que has escollit.
            - ✅ Aquest simból a la posició d'un color significa que aquest color es troba a la sequencia i a la possició que has escollit.
 -La partida consisteix de 6 torns, en cas de no arribar a completar la seqüéncia haurás perdut.
 -Haurás d'introduir el nom dels colors en minuscules.
 """)
   print("Per simplificar la jugavilitat abans de confirmar la jugada t'apareixerà una representació amb els colors introduits,\n" +
           "en cas de que volguis corregir algo abans d'enviar la jugada haurás d'escriure RETURN sino CONFIRM.")

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
         colores(userSelectionsList[i][j])
         print(" ")
      }
      print("\t")
      println(FANTASY + " \t" + RESET)
      println(FANTASY + "\t" + RESET + "\t\t\t\t" +FANTASY +"\t"+ RESET + "\t\t\t\t\t\t\t" + FANTASY + "\t" + RESET)
      println(FANTASY + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + RESET )
   }
}


/**
 *  Depends of the results of the match gets a different boolean which do that print differents thing's,
 *  then ask you if you want to replay the game and returns to the main the users answer.
 *
 *  @param {win} boolean Determines the text that's went to print
 *  @return {final} Returns a string of the user's answer
 */
fun final(win:Boolean):String{
   val scanner=Scanner(System.`in`).useLocale(Locale.UK)
   println()
   if (win){
      println("\n Has encertat enhorabona!! \n " +
              "Si vols tornar a jugar NEW, si vols sortir EXIT.")
   }
   else {
      println("\n Has perdut :( \n " +
              "Si vols tornar a jugar NEW, si vols sortir EXIT.")
   }
   var final = scanner.next().uppercase()
   if(final != "NEW" && final != "EXIT"){
      do {
         println("Introdueix una de les opcions")
         final=scanner.next().uppercase()
      }while (final != "NEW" && final != "EXIT")
   }
   return(final)
}

/**
 * Gets the color selectioned from the user and prints a color emote
 *
 * @param {userSelection} string The name of the color selectioned for the user
 */
fun colores(userSelection:String){
   when(userSelection){
      "vermell" -> print("\uD83D\uDD34 ")
      "groc" -> print( "\uD83D\uDFE1 ")
      "blau" -> print( "\uD83D\uDD35 ")
      "lila" -> print( "\uD83D\uDFE3 ")
      "verd" -> print( "\uD83D\uDFE2 ")
   }
}

/**
 * The function main is where all the game is executed, here there are three parts, first the welcome to the user,
 * second the sequence generator and the last the user match.
 */
fun main() {
   val scanner = Scanner(System.`in`).useLocale(Locale.UK)
   var userSelectionsList : MutableList<MutableList<String>>
   var userComprovationsList : MutableList<MutableList<String>>
   var times:Int
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
      var instructions=false
      val start=scanner.next().uppercase()
      if (start=="HELP"){
         instrucciones()

         println("\n\n Introdueix CONTINUE quan estiguis preparat")
         do {
            val enter = scanner.next().uppercase()
            if (enter!="CONTINUE") {
               println("Introdueix CONTINUE quan estiguis preparat")
            }
         }while (enter!= "CONTINUE")
         instructions=true
      }
      else if (start!="HELP" && start!="CONTINUE"){
         println("Per començar a jugar introdueix CONTINUE, si no saps jugar introdueix HELP")
      }
   }while (start!="CONTINUE" && !instructions)
   //--------------------------------------------------------------------------------------------------------
   do{
      //GENERADOR DE LA SEQÜENCIA-------------------------------------------------------------------------------
      var colores = mutableListOf("vermell","verd", "groc", "blau", "lila")
      var rnd: Int
      var sequencia = MutableList(4) {""}
      for (i in 0..3){
         rnd = (0..4).random()
         if (colores[rnd]=="used"){
            do {
               rnd = (0..4).random()
               sequencia[i]= colores[rnd]
            }while (colores[rnd]=="used")
            colores[rnd]= "used"
         }
         else {
            sequencia[i]= colores[rnd]
            colores[rnd]= "used"
         }
      }
      //----------------------------------------------------------------------------------------------------------
      // RONDAS DE PARTIDA ---------------------------------------------------------------------------------------
      userSelectionsList = mutableListOf()
      userComprovationsList = mutableListOf()
      colores = mutableListOf("vermell","verd", "groc", "blau", "lila")
      var restart = ""
      times = 0
      for (i in 0..5){
         userComprovationsList.add(mutableListOf())
         userSelectionsList.add(mutableListOf())
         do {
            println("RONDA ${i+1}: ")
            for (j in 0..3){
               println("COLOR ${j+1}:")
               userSelection = scanner.next()
               if (!(colores.contains(userSelection)) || userSelection in userSelectionsList[i]) {
                  do {
                     println("Introdueix un color vàlid o que no hagis introduit a la ronda")
                     userSelection = scanner.next()
                  }while (!(colores.contains(userSelection)) || userSelection in userSelectionsList[i])
               }
               userSelectionsList[i].add(userSelection)
            }
            for (j in 0..3){
               colores(userSelectionsList[i][j])
            }
            println("\n Es aquesta la seqüéncia que volias posar? \n Escriu SI / NO")
            var sentenceConfirmation = scanner.next().uppercase()
            if(sentenceConfirmation!="SI" && sentenceConfirmation!="NO"){
               do {
                  println("Introdueix una de les opcions")
                  sentenceConfirmation=scanner.next()
               }while (sentenceConfirmation!="SI" && sentenceConfirmation!="NO")
            }
         }while (sentenceConfirmation!="SI")
         println()
         for (j in 0..3){
            if (userSelectionsList[i][j] == sequencia[j]) userComprovationsList[i].add("✅")
            else if (userSelectionsList[i][j] in sequencia) userComprovationsList[i].add("\uD83D\uDD01")
            else userComprovationsList[i].add("❎")
         }
         println()
         times+=1
         interficie(userName, times, userComprovationsList, userSelectionsList)
         if (userSelectionsList[i] == sequencia) {
            restart = final(true)
            break
         }
         if (i==5){
            restart = final(false)
         }
      }
   }while (restart!="EXIT" && restart!="EXIT")
   //-------------------------------------------------------------------------------------------------------
}