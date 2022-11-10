//Projecte MasterMind
//Author:Pol Martínez
import java.util.*

const val RED = "\u001B[31m"
const val RESET = "\u001B[0m"
const val PURPLE = "\u001B[35m"
const val BLUE = "\u001B[34m"
const val GREEN = "\u001B[32m"
const val YELLOW = "\u001B[33m"
const val FANTASY = "\u001B[48;5;240m"
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
fun interficie(userName:String, times:Int, userComprovationsList:MutableList<String>, userSelectionsList:MutableList<String>){
   var iterator=0
   println(FANTASY + "\t\t\t\t\t\t\t\t\t\t\t\t\t" + RESET )
   println(FANTASY + "\t" + RESET + "\t\t\t\t\t\t\t\t\t\t\t" + FANTASY + "\t" + RESET)
   println(FANTASY + "\t" + RESET + "\t\t\t\t\t$userName\t\t\t\t\t" + FANTASY + "\t" + RESET)
   println(FANTASY + "\t" + RESET + "\t\t\t\t\t\t\t\t\t\t\t" + FANTASY + "\t" + RESET)
   println(FANTASY + "\t\t\t\t\t\t\t\t\t\t\t\t\t" + RESET )

   for (i in 1..times){
      println(FANTASY + "\t" + RESET + "\t\t\t" +FANTASY +"\t"+ RESET + "\t\t\t\t\t\t\t" + FANTASY + "\t" + RESET)
      print(FANTASY + "\t" + RESET)
      print("  ")
      when(i){
         1-> iterator=0
         2-> iterator=4
         3-> iterator=8
         4-> iterator=12
         5-> iterator=16
      }
      for (i in 0..3){
         print("${ userComprovationsList[iterator] } ")
         iterator+=1
      }
      when(i){
         1-> iterator=0
         2-> iterator=4
         3-> iterator=8
         4-> iterator=12
         5-> iterator=16
      }
      print("  ")
      print(FANTASY +" \t"+ RESET )
      for (i in 0 .. 3){
         print("  ")
         colores(userSelectionsList[iterator])
         print("  ")
         iterator+=1
      }
      println( FANTASY + "\t" + RESET)
      println(FANTASY + "\t" + RESET + "\t\t\t" +FANTASY +"\t"+ RESET + "\t\t\t\t\t\t\t" + FANTASY + "\t" + RESET)
      println(FANTASY + "\t\t\t\t\t\t\t\t\t\t\t\t\t" + RESET )
   }
}
fun finalWin(n:Boolean):String{
   val scanner=Scanner(System.`in`).useLocale(Locale.UK)
   println()
   if (n){
      println("\n Has encertat enhorabona!! \n " +
              "Per veure l'historial de la partida escriu GAME si vols tornar a jugar NEW, si vols sortir EXIT.")
   }
   else {
      println("\n Has perdut :( \n " +
              "Per veure l'historial de la partida escriu GAME si vols tornar a jugar NEW, si vols sortir EXIT.")
   }
   var finalWin = scanner.next()
   if(finalWin!="GAME" && finalWin != "NEW" && finalWin != "EXIT"){
      do {
         println("Introdueix una de les opcions")
         finalWin=scanner.next()
      }while (finalWin!="GAME" && finalWin != "NEW" && finalWin != "EXIT")
   }
   return(finalWin)
}
fun colores(n:String){ //TO DO: canviar colores por emotes
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
   var userSelectionsList: MutableList<String> = mutableListOf()
   var userComprovationsList: MutableList<String> = mutableListOf()
   var times =0
   println("Introdueix un username de 5 caracters:")
   val userName= scanner.next()
   println("Benvingut $userName a Mastermind \n Per començar a jugar introdueix CONTINUE, si no saps jugar introdueix HELP")
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
   var rnd: Int
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
   do{
      var userSelectionsList: MutableList<String> = mutableListOf()
      var restart=""
      var userSequence: Array<String>
      for (i in 1..5){
         var correctSequencia=0
         userSequence= arrayOf("","","","")
         do {
            println("RONDA $i: ")
            for (i in 0..3){
               var userSelection = scanner.next()
               if (userSelection!="vermell" && userSelection!="verd" && userSelection!="groc" && userSelection!="blau" && userSelection!="lila" || userSelection in userSequence){
                  do {
                     println("Introdueix un color vàlid o que no hagis introduit a la ronda")
                     userSelection = scanner.next()
                  } while (userSelection!="vermell" && userSelection!="verd" && userSelection!="groc" && userSelection!="blau" && userSelection!="lila" || userSelection in userSequence)
               }
               userSequence[i]=userSelection
               userSelectionsList.add(userSelection)
            }
            for (i in 0..3){
               colores(userSequence[i])
            }
            println("\n Es aquesta la seqüéncia que volias posar? \n Escriu SI / NO")
            var sequenceConfirmation=scanner.next()
            if(sequenceConfirmation!="SI" && sequenceConfirmation!="NO"){
               do {
                  println("Introdueix una de les opcions")
                  sequenceConfirmation=scanner.next()
               }while (sequenceConfirmation!="SI" && sequenceConfirmation!="NO")
            }
         }while (sequenceConfirmation!="SI")
         println()
         for (i in 0..3){
            var position: Int
            if (userSequence[i] == sequencia[i]) position=2
            else if (userSequence[i] in sequencia) position = 1
            else position = 0
            when (position){
               0-> userComprovationsList.add("×")
               1-> userComprovationsList.add("Ø")
               2-> userComprovationsList.add("O")
            }
         }
         for (i in 0..3){
            if (userSequence[i]==sequencia[i]) correctSequencia+=1
         }
         println()
         times+=1
         interficie(userName, times, userComprovationsList, userSelectionsList)
         if (correctSequencia==4) {
            restart = finalWin(true)
            break
         }
         if (i==5){
            restart = finalWin(false)
            break
         }

      }
   }while (restart!="EXIT" && restart!="EXIT")
   //-----------------------------------------------------------------------------------------
}