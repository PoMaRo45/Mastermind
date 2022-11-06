//Projecte MasterMind
//Author:Pol Martínez
import java.util.*

const val RED = "\u001B[31m"
const val RESET = "\u001B[0m"
const val PURPLE = "\u001B[35m"
const val BLUE = "\u001B[34m"
const val GREEN = "\u001B[32m"
const val YELLOW = "\u001B[33m"
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

   //GENERADOR DE LA SEQUENCIA---------------------------------------
   var colores = arrayOf("vermell","verd", "groc", "blau", "lila")
   val rnd = (0..4).random()
   var sequencia = arrayOf<String>("","","","")
   for (i in 0..3){
      val rnd = (0..4).random()
      if (colores[rnd]=="used"){
         do {
            val rnd = (0..4).random()
            sequencia[i]= colores[rnd]
         }while (colores[rnd]=="used")
         colores[rnd]= "used"
      }
      else {
         sequencia[i]= colores[rnd]
         colores[rnd]= "used"
      }
   }
   //-----------------------------------------------
   // RONDAS DE PARTIDA -----------
   val correctSequencia=false
   for (i in 1..5){
      var userSequence= arrayOf("","","","")
      var position = 0
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
//      if (userSelection == sequencia[i]) position=2
//      else if (userSelection in sequencia) position = 1
//      else position = 0
   }
}