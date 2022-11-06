//Projecte MasterMind
//Author:Pol Martínez
import java.util.*

const val RED = "\u001B[31m"
const val RESET = "\u001B[0m"
const val PURPLE = "\u001B[35m"
const val BLUE = "\u001B[34m"
const val GREEN = "\u001B[32m"
const val YELLOW = "\u001B[33m"
const val BROWN = "\u001B[38;5;52m"
fun instrucciones(){
   println ("!! MasterMind ¡¡\n")
   println ("Abans de començar a jugar farem una breu explicació de com funciona el joc:")
   println("El joc consisteix en endivinar la possició en la qual es troben els colors. Hi han 4 possicions en les quals poden haver-hi colors i 5 diferents colors: ")
   print(RED + "\t\t\to" + RESET +" (vermell), ")
   print (GREEN + "o" + RESET + " (verd), ")
   print (BLUE + "o" + RESET + " (blau), ")
   print (YELLOW + "o" + RESET + " (groc) i ")
   println (PURPLE + "o" + RESET + " (lila).")
   println("")
   println ("Una vegada feta la introducció passem a les normes i funcionament:")
   println(""" - En la secuencia de colors no es trobará cap color repetit.
 - Per cada posició tindras un comprovador el qual tindra 3 senyals difrents per que sapigues si vas en bon camí: 
            - × Aquest simból a la posició d'un color significa que aquest color no es troba a la sequencia.
            - Ø Aquest simból a la posició d'un color significa que aquest color es troba a la sequencia, pero no a la possició que has escollit.
            - O Aquest simból a la posició d'un color significa que aquest color es troba a la sequencia i a la possició que has escollit.
 -La partida consisteix de 6 torns, en cas de no arribar a completar la seqüéncia haurás perdut.
 -Haurás d'introduir el nom dels colors en minuscules.
 """)
   print("Per simplificar la jugavilitat abans de confirmar la jugada t'apareixerà una representació amb els colors introduits,\n" +
           "en cas de que volguis corregir algo abans d'enviar la jugada haurás d'escriure RETURN sino CONFIRM.")

}
fun finalWin(){
   val scanner=Scanner(System.`in`).useLocale(Locale.UK)
   println()
   println("\n Has encertat enhorabona!! \n " +
           "Per veure l'historial de la partida escriu GAME si vols tornar a jugar NEW, si vols sortir EXIT.")
   var finalWin = scanner.next()
   if(finalWin!="GAME" && finalWin != "NEW" && finalWin != "EXIT"){
      do {
         println("Introdueix una de les opcions")
         finalWin=scanner.next()
      }while (finalWin!="GAME" && finalWin != "NEW" && finalWin != "EXIT")
   }
   when (finalWin){
      "GAME"-> print("mic")
      "NEW"-> print("mic")
   }
}
fun finalLose(){
   val scanner=Scanner(System.`in`).useLocale(Locale.UK)
   println()
   println("\n Has perdut :( \n " +
           "Per veure l'historial de la partida escriu GAME si vols tornar a jugar NEW, si vols sortir EXIT.")
   var finalLose = scanner.next()
   if(finalLose!="GAME" && finalLose != "NEW" && finalLose != "EXIT"){
      do {
         println("Introdueix una de les opcions")
         finalLose=scanner.next()
      }while (finalLose!="GAME" && finalLose != "NEW" && finalLose != "EXIT")
   }
   when (finalLose){
      "GAME"-> print("mic")
      "NEW"-> print("mic")
   }
}
fun colores(n:String){
   if (n=="vermell"){
      print( RED + " o " + RESET )
   }
   else if(n=="groc"){
      print( YELLOW + " o " + RESET )
   }
   else if (n == "blau"){
      print( BLUE + " o " + RESET )
   }
   else if (n == "lila"){
      print( PURPLE + " o " + RESET )
   }
   else if (n == "verd"){
      print( GREEN + " o " + RESET )
   }
}
fun main() {
   val scanner=Scanner(System.`in`).useLocale(Locale.UK)
   println("Benvingut a Mastermind \n Per començar a jugar introdueix CONTINUE, si no saps jugar introdueix HELP")
   do {
      var instructions=false
      val start=scanner.next()
      if (start=="HELP"){
         instrucciones()
         println("\n Introdueix CONTINUE cuan estiguis preparat")
         do {
            val enter = scanner.next()
            if (enter!="CONTINUE") {
               println("Introdueix CONTINUE cuan estiguis preparat")
            }
         }while (enter!= "CONTINUE")
         instructions=true
      }
      else if (start!="HELP" && start!="CONTINUE"){
         println("Per començar a jugar introdueix CONTINUE, si no saps jugar introdueix HELP")
      }
   }while (start!="CONTINUE" && !instructions)

   //GENERADOR DE LA SEQUENCIA-------------------------------------------------------------------------------
   var colores = arrayOf("vermell","verd", "groc", "blau", "lila")
   var rnd = (0..4).random()
   var sequencia = arrayOf<String>("","","","")
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
   for (i in 0..3){
      println(sequencia[i])
   }
   //--------------------------------------------------------------------------------------------
   // RONDAS DE PARTIDA -------------------------------------------------------------------------
   for (i in 1..5){
      var correctSequencia=0
      var userSequence= arrayOf("","","","")
      println("RONDA $i: ")
      for (i in 0..3){
         var userSelection = scanner.next()
         if (userSelection!="vermell" && userSelection!="verd" && userSelection!="groc" && userSelection!="blau" && userSelection!="lila"){
            do {
               println("Introdueix un color vàlid")
               userSelection = scanner.next()
            } while (userSelection!="vermell" && userSelection!="verd" && userSelection!="groc" && userSelection!="blau" && userSelection!="lila")
         }
         userSequence[i]=userSelection
      }
      for (i in 0..3){
         colores(userSequence[i])
      }
      println("Es aquesta la seqüéncia que volias posar? \n Escriu SI / NO")
      var sequenceConfirmation=scanner.next()
      if(sequenceConfirmation!="SI" && sequenceConfirmation!="NO"){
         do {
            println("Introdueix una de les opcions")
            sequenceConfirmation=scanner.next()
         }while (sequenceConfirmation!="SI" && sequenceConfirmation!="NO")
      }
      when(sequenceConfirmation)
      println()
      for (i in 0..3){
         var position=0
         if (userSequence[i] == sequencia[i]) position=2
         else if (userSequence[i] in sequencia) position = 1
         else position = 0
         when (position){
            0-> print ("×")
            1-> print ("Ø")
            2-> print ("O")
         }
      }
      for (i in 0..3){
         if (userSequence[i]==sequencia[i]) correctSequencia+=1
      }
      if (correctSequencia==4) {
         finalWin()
         break
      }
      if (i==5){
         finalLose()
         break
      }
      println()
   }
   //-----------------------------------------------------------------------------------------
}