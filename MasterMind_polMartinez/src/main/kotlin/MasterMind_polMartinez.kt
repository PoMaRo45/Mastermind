/**
 * @author POL MARTÍNEZ
 */
import java.io.File
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
const val RESET = "\u001B[0m"
const val FANTASY = "\u001B[48;5;240m"
const val bold = "\u001b[1m"
const val CYAN = "\u001b[36m"
const val GREEN = "\u001b[32m"
const val RED = "\u001b[31m"
const val BACK_CYAN = "\u001b[46m"
const val BLACK = "\u001b[30m"
const val BACK_LEMON = "\u001b[48;5;229m"
const val BACK_YELLOW = "\u001B[48;5;226m"
const val BACK_BLUE = "\u001B[48;5;18m"
const val BACK_RED = "\u001B[48;5;196m"
const val BACK_GREEN = "\u001B[48;5;40m"
const val BACK_BLUE_LIGHT = "\u001B[48;5;20m"
/**
 * That funtion print on the terminal the instructions of the Masetermind.
 *
 */
fun instrucciones(instruction: Int) {
   println ("!! MasterMind ¡¡")
   when(instruction){
      1->{
         println ("Abans de començar a jugar farem una breu explicació de com funciona el mode classic:")
      }
      2-> {
         println("Abans de començar a jugar farem una breu explicació de com funciona el mode 777:")
         println("Aquest mode consisteix en endivinar la possició en la qual es troben els colors. Hi han 7 possicions en les quals poden haver-hi colors i 7 diferents colors:")
         print("\t\t\t\uD83D\uDD34  (vermell), ")
         print("\uD83D\uDFE2  (verd), ")
         print("\uD83D\uDD35  (blau), ")
         print("\uD83D\uDFE1 (groc), ")
         print("\uD83D\uDFE3 (lila),")
         print("\uD83D\uDFE0 (taronja) i ")
         println("\uD83D\uDFE4 (marró).")
      }
      3->{
         println ("Abans de començar a jugar farem una breu explicació de com funciona el mode a contre rellotge:")
         println("La diferencia entre aquest mode i els altres és que en aquest el temps que tardes en endevinar la seqüencia repercutira en la teva possició la ranking")
      }
   }
   if (instruction == 1 || instruction == 3){
      println("Aquest mode consisteix en endivinar la possició en la qual es troben els colors. Hi han 4 possicions en les quals poden haver-hi colors i 5 diferents colors:")
      print("\t\t\t\uD83D\uDD34  (vermell), ")
      print ("\uD83D\uDFE2  (verd), ")
      print ("\uD83D\uDD35  (blau), ")
      print ("\uD83D\uDFE1 (groc) i ")
      println ("\uD83D\uDFE3 (lila).")
   }
   println("")
   println ("Una vegada feta la introducció passem a les normes i funcionament:")
   println(""" - En la secuencia de colors es poden trobar colors repetits.
 - Per cada posició tindras un comprovador el qual tindra 3 senyals difrents per que sapigues si vas en bon camí: 
            - 🚫 Aquest simból a la posició d'un color significa que aquest color no es troba a la sequencia o que  has colocat el mateix color de manera correcte i no es troba a cap possició més.
            - 🔁 Aquest simból a la posició d'un color significa que aquest color es troba a la sequencia, pero no a la possició que has escollit.
            - ✅ Aquest simból a la posició d'un color significa que aquest color es troba a la sequencia i a la possició que has escollit.
 -Haurás d'introduir els colors tal qual surten a les instruccions.
 """)
   if (instruction == 1 || instruction == 3){
      println("-La partida consisteix de 6 torns, en cas de no arribar a completar la seqüéncia haurás perdut.")
   }
   else println("-La partida consisteix de 7 torns, en cas de no arribar a completar la seqüéncia haurás perdut.")
   print("Per simplificar la jugavilitat abans de confirmar la jugada t'apareixerà una representació amb els colors introduits,\n" +
           "en cas de que volguis corregir algo abans d'enviar la jugada haurás d'escriure NO sino SI.\n")
}

/**
 * Creates a visual box of tabs that have a background color to simulate an interface of the videogames rounds
 * counting the round which is playing the user and then printing the userName, the user's selection and the verification of the selection's from a list.
 *
 * @param {userName} string THe name of whose playing.
 * @param {times} number The round that's playing the user.
 * @param {userComprovationsList} List<String> The list that contains the symbols of the comprovations.
 * @param {userSelectionsList} List<String> The list that contains every selection of the user on the match.
 * @param {mode777} Boolean True if the mode played is 777, false if not.
 *
 */
fun interficie(userName:String, times:Int, userComprovationsList:MutableList<MutableList<String>>, userSelectionsList:MutableList<MutableList<String>>, mode777:Boolean){
   println(FANTASY + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + RESET)
   println(FANTASY + "\t" + RESET + "\t\t\t\t\t\t\t\t\t\t\t\t" + FANTASY + "\t" + RESET)
   println(FANTASY + "\t" + RESET + "\t\t\t\t\t  $userName\t\t\t\t\t\t" + FANTASY + "\t" + RESET)
   println(FANTASY + "\t" + RESET + "\t\t\t\t\t\t\t\t\t\t\t\t" + FANTASY + "\t" + RESET)
   println(FANTASY + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + RESET )
   for (i in 0 until times){
      println(FANTASY + "\t" + RESET + "\t\t\t\t" +FANTASY +"\t"+ RESET + "\t\t\t\t\t\t\t" + FANTASY + "\t" + RESET)
      if (mode777){
         for (k in 0..1){
            print(FANTASY + "\t" + RESET)
            if (k == 0) print("\t")
            else print("  ")
            val inicio = if (k == 0) 0
            else userComprovationsList[i].size/2
            val final = if (k == 0) (userComprovationsList[i].size/2)
            else userComprovationsList[i].size
            for (j in inicio until final){
               print("${ userComprovationsList[i][j] } ")
            }
            print("\t")
            print(FANTASY +" \t"+ RESET )
            if (k  == 0) print("\t ")
               else print("  ")

            for (j in inicio until final){
               print("  ")
               print(printColores(userSelectionsList[i][j]))
               print(" ")
            }
            if (k == 0) print("\t")
            else print("\t")
            println("$FANTASY \t$RESET")
         }
      }else{
         print(FANTASY + "\t" + RESET)
         print("  ")
         for (j in 0 until userComprovationsList[i].size){
            print("${ userComprovationsList[i][j] } ")
         }
         print("\t")
         print("$FANTASY \t$RESET")
         print("  ")
         for (j in 0 until userComprovationsList[i].size){
            print("  ")
            print(printColores(userSelectionsList[i][j]))
            print(" ")
         }
         print("\t")
         println("$FANTASY \t$RESET")
      }
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
 *  @return Returns a valid input
 */
fun inputChecker (condition : Int, input:String, message:String, first:String, second:String):String {
   val scanner = Scanner(System.`in`)
   var inputReworked :String
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
      "taronja" -> return ( "\uD83D\uDFE0 ")
      "marró" -> return ( "\uD83D\uDFE4 ")
   }
   return "error"
}

/**
 * A function that generete the sequence that will be used on the match, the size of the game depends on the mode selected
 *
 * @param {colors} MutableList<String> The colors that will be use to generete the seqyence
 * @param {number} Int The numbers of colors that have to be on the sequence
 *
 * @return {sequencia} : MutableList<String> A list with the colors of the match.
 */
fun secuenceGenerator (colors:MutableList<String>, number: Int): MutableList<String> {
   var rnd: Int
   val sequencia = MutableList(number) {""}
   for (i in 0 until number){
      rnd = (0 until number).random()
      sequencia[i]= colors[rnd]
   }
   return sequencia
}
/**
 *  A function that check the user input compared to the sequence and returns the list of emotes to print.
 *
 *  @param {userSelectionsList} MutableList<String> The list of selections of the user
 *  @param {sequencia} MutableList<String> The sequence of the match on a list
 *  @param colorsSize Int The number of colors in the sequence
 *
 *  @return {userComprovationsList} A list that contains the results of the round ready to print
 */

fun sequenceCheker (userSelectionsList: MutableList<String>, sequencia:MutableList<String>, colorsSize:Int): MutableList<String> {
   val userComprovationsList = MutableList(colorsSize){""}
   val remain = mutableListOf<String>()
   for (j in 0 until colorsSize){
      if (userSelectionsList[j] == sequencia[j]){
         userComprovationsList[j] = "✅"
      }
      else remain.add(sequencia[j])
   }
   for (j in 0 until colorsSize){
      if (userSelectionsList[j] in remain && userComprovationsList[j] == "") userComprovationsList[j] = "\uD83D\uDD01"
      else if (userSelectionsList[j] !in remain && userComprovationsList[j] == "") userComprovationsList[j] = "\uD83D\uDEAB"
   }
   return userComprovationsList
}

/**
 *  A function that cehck if exists information from the user selected, if exists returns a list with the information, if not return an empty list.
 *
 *  @param {userName} String The userName thst put the user.
 *
 *  @return {userInformation} MutableList<String> A list with the information about the user, password and username, if not exists any type of information it return it empty.
 */
fun checkUser(userName: String):MutableList<String> {
   val lineas = File("src/main/kotlin/DATA/usuarios.txt").readLines()
   val userInformation = mutableListOf<String>()
   for (i in lineas.indices){
      if (lineas[i].split(",")[0].split(":")[1] == userName){
         userInformation.add(lineas[i].split(",")[0].split(":")[1])
         userInformation.add(lineas[i].split(",")[1].split(":")[1])
      }
   }
   return userInformation
}

/**
 *  A function that pass a time from a format HH:MM:SS to all seconds.
 *
 *  @param time LocalDateTime the time on format that you want to pass to seconds
 *
 *  @return The time passed to seconds
 */
fun timeToSecond (time: LocalDateTime): Int {
   var horas = time.toString().split("T")[1].split(":")[0].toInt()
   horas *= 3600
   var minutos = time.toString().split("T")[1].split(":")[1].toInt()
   minutos += 60
   val segundos = time.toString().split("T")[1].split(":")[2].split(".")[0].toInt()
   return horas + minutos + segundos
}
/**
 * A function that format a information to an antoher format that makes easier to save and posterior read.
 *
 * @param userName String The name of the user
 * @param mode Int the mode played on the match
 * @param result Int The number of tries at the final of the match
 * @param firstDate LocalDateTime The hour at the start of the match
 *
 * @return A string of the information formated to be save
 */
fun formaterToSave(userName: String, mode: Int, result: Int, firstDate: LocalDateTime):String {
   val currentDate = LocalDate.now()
   val time = LocalDateTime.now().toString().split("T")[1]
   var win = false
   val tempsDeRonda : Int
   when (mode){
      1->{
         if (result != 5) win = true
         return "$userName,$mode,$win,$result,,$currentDate,$time\n"
      }
      2-> {
         if (result != 6) win = true
         return "$userName,$mode,$win,$result,,$currentDate,$time\n"
      }
      3->{
         if (result != 5) win = true
         if (firstDate.toString().split("T")[0] == LocalDateTime.now().toString().split("T")[0]){
            val tempsInici = timeToSecond(firstDate)
            val tempsFinal = timeToSecond(LocalDateTime.now())
            tempsDeRonda = tempsFinal - tempsInici
         }
         else{
            val tempsInici = timeToSecond(firstDate)
            var tempsFinal = timeToSecond(LocalDateTime.now())
            tempsFinal += ( 24 * 3600 )
            tempsDeRonda = tempsFinal-tempsInici
         }
         return "$userName,$mode,$win,$result,$tempsDeRonda,$currentDate,$time\n"
      }
   }
   return ""
}

/**
 *  A function that prints on the terminal a visual box with the information of the historial of the user.
 *
 *  @param informacion MutableList<MutableList<String>> A bidimensional list that contains the information of all the matches played of the user
 */
fun interficieHistorial (informacion: MutableList<MutableList<String>>) {
   println("$BACK_BLUE\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$RESET")
   for (i in informacion){
      val modeDeJoc = when(i[1]) {
         "1" -> "Mode Clàssic\t\t\t"
         "2" -> "Mode 777\t\t\t\t"
         "3" -> "Mode a contre Rellotge"
         else -> {""}
      }
      val tempsPartida = i[4]
      val victoria = if (i[2].toBoolean()) "${BACK_GREEN}${BLACK} VICTORIA $RESET\t"
      else "${BACK_RED}${BLACK} DERROTA $RESET\t"
      val intents = if (victoria == "${BACK_GREEN}${BLACK} VICTORIA $RESET\t") "$GREEN${i[3]}$RESET"
      else "$RED${i[3]}$RESET"
      val dia = i[5]
      val hora = i[6].subSequence(0,7)
      println("$BACK_BLUE\t$RESET\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t$BACK_BLUE\t$RESET")
      println("$BACK_BLUE\t$RESET\t${bold}MODE DE JOC:$RESET $modeDeJoc \t\t\t${bold}$RESET $victoria$BACK_BLUE\t$RESET")
      println("$BACK_BLUE\t$RESET\t\t\t\t\t\t\t\t\t\t\t\t\t\tEN\t\t$BACK_BLUE\t$RESET")
      if (i[1] != "3"){
         println("$BACK_BLUE\t$RESET\t\t${bold}DIA:$RESET $dia\t\t\t\t\t\t\t\t $intents intents\t$BACK_BLUE\t$RESET")
         println("$BACK_BLUE\t$RESET\t\t${bold}HORA:$RESET $hora\t\t\t\t\t\t\t\t\t\t\t$BACK_BLUE\t$RESET")
      }
      else{
         println("$BACK_BLUE\t$RESET\t\t${bold}DIA:$RESET $dia\t\t\t${bold}  TEMPS$RESET\t\t\t\t $intents intents\t$BACK_BLUE\t$RESET")
         println("$BACK_BLUE\t$RESET\t\t${bold}HORA:$RESET $hora\t\t\t  $tempsPartida s\t\t\t\t\t\t\t$BACK_BLUE\t$RESET")
      }
      println("$BACK_BLUE\t$RESET\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t$BACK_BLUE\t$RESET")
      if (i != informacion[informacion.lastIndex]) println("$BACK_BLUE\t$RESET$BACK_BLUE_LIGHT\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$BACK_BLUE\t$RESET")
   }
   println("$BACK_BLUE\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$RESET")
}

/**
 * A function that returns a string to print with the ranking of the users by every mode
 *
 * @param modeSelected String The mode that the users wants to know the ranking
 *
 * @return A string with the ranking of the mode
 */
fun rankingModes(modeSelected : String):  String {
   val file = File("src/main/kotlin/DATA/historial.txt")
   val lineas = file.readLines()
   var partidas = mutableListOf<MutableList<String>>()
   for (i in lineas.indices){
      val modes = lineas[i].split(",")[1]
      if (modes == modeSelected ) partidas.add(lineas[i].split(",").toMutableList())
   }
   if (partidas.isEmpty()) return "$BACK_YELLOW$BLACK$bold ${"No hi han dades sobre cap partida realitzada el mode seleccionat".uppercase()} $RESET\n"
   else {

      when(modeSelected){
         "1", "2" -> {
            partidas = ordenarRanking(partidas, if (modeSelected == "1" || modeSelected == "3") 6 else 7)
            var stringFinal = "\t${bold}USUARIO\t INTENTOS$RESET\n"
            for (i in partidas.indices){
               stringFinal += "${i+1}.    ${partidas[i][0]}\t\t${partidas[i][3]}\n"
               if (i == 2) return  stringFinal
            }
            return  stringFinal
         }
         "3" -> {
            partidas = ordenarPorTiempo(partidas)
            var stringFinal = "\t${bold}USUARIO\t INTENTOS\t TIEMPO$RESET\n"
            for (i in partidas.indices){
               stringFinal += "${i+1}.    ${partidas[i][0]}\t\t${partidas[i][3]}\t\t ${partidas[i][4]}\n"
               if (i == 2) return  stringFinal
            }
            return  stringFinal
         }
         else -> return "ERROR"
      }
   }
}

/**
 * A function to order a list with an specific nummber that means the time of the match and the  use another to order it with the number of tries
 *
 * @param partidas MutableList<MutableList<String>> the information of the games played of the mode selected
 *
 * @return listaOrdenada MutableList<MutableList<String>> A list with the matches ordered by time and tries
 */
fun ordenarPorTiempo(partidas: MutableList<MutableList<String>>): MutableList<MutableList<String>> {
   var listaOrdenada = mutableListOf<MutableList<String>>()
   var iterator = 0
   val tiempo = mutableListOf<Int>()
   for (i in partidas.indices){
      tiempo.add(partidas[i][4].toInt())
   }
   iterator = tiempo.max()
   for (i in 1 .. iterator ){
      for (j in partidas.indices){
         if (partidas[j][4].toInt() == i) listaOrdenada.add(partidas[j])
      }
   }
   listaOrdenada = ordenarRanking(listaOrdenada, 6)
   return listaOrdenada
}

/**
 * A function that order the games by the tries from 1 to the max tries of the mode
 *
 * @param partidas MutableList<MutableList<String>> the information about the matches played on the games
 * @param iterator Int The max number of tries that can do on the match
 *
 * @return listaOrdenada MutableList<MutableList<String>> A list ordered by the tries
 */
fun ordenarRanking(partidas: MutableList<MutableList<String>>, iterator: Int): MutableList<MutableList<String>> {
   val listaOrdenada = mutableListOf<MutableList<String>>()
   for (i in 1 .. iterator ){
      for (j in partidas.indices){
         if (partidas[j][3].toInt() == i) listaOrdenada.add(partidas[j])
      }
   }
   return listaOrdenada
}

/**
 * A function that format the inputs of the user to a string for posterior read on the program
 *
 * @param userInput String The input of the user
 *
 * @return String The input formated.
 */

fun inputFormater (userInput: String) :String {
   when (userInput){
      "1","r", "vermell" -> return "vermell"
      "2","g", "verd" -> return "verd"
      "3", "y", "groc" -> return "groc"
      "4", "b","blau" -> return "blau"
      "5", "p", "lila" -> return "lila"
      "6", "o", "taronja" -> return "taronja"
      "7", "m", "marró" -> return "marró"
      else ->return "ERROR"
   }
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
   var userName = ""
   var userInformation :MutableList<String>
   var firstDate = LocalDateTime.now()
   val partidas = mutableListOf<MutableList<String>>()
   File("src/main/kotlin/DATA/usuarios.txt").createNewFile()
   File("src/main/kotlin/DATA/historial.txt").createNewFile()
   do {
      println("Si has jugat anteriorment i vols continuar jugant amb el teu histoial" +bold+CYAN+" INCIA SESSIÓ,\n" +RESET+
              "sino pots "+bold+CYAN+ "CREAR UN USUARI"+RESET+", introdueix "+bold+BACK_CYAN+BLACK+ " INICIAR "+RESET+" o "+bold+BACK_CYAN+BLACK+" CREAR "+RESET+" segons el que volguis fer.")
      var initiated = false
      var createUser = scanner.next().uppercase()
      createUser = inputChecker(2, createUser,
         "Introdueix $bold$BACK_CYAN$BLACK INICIAR $RESET o $bold$BACK_CYAN$BLACK CREAR $RESET segons el que volguis fer.", "CREAR", "INICIAR" )
      if (createUser.uppercase() == "INICIAR") {
         do {
            println("Introdueix el teu $BACK_LEMON$BLACK USERNAME $RESET de 5 caracters:")
            userName = scanner.next()
            if (userName.length != 5) {
               do {
                  println("Introdueix un $BACK_LEMON$BLACK USERNAME $RESET de 5 caracters:")
                  userName = scanner.next()
               } while (userName.length != 5)
            }
            userInformation = checkUser(userName)
         } while (userInformation.isEmpty())
         println("Introdueix la teva $BACK_LEMON$BLACK CONTRASENYA $RESET.")
         var password = scanner.next()
         var fails = 0
         if (password != userInformation[1]) {
            do {
               println("La contrasenya introduïda no es la correcta\n")
               fails += 1
               if (fails > 2) {
                  println("Si no t'enrecordes pots tornar al menú d'inici, escriu MENU sino esccriu el que sigui.")
                  val restart = scanner.next().uppercase()
                  if (restart == "MENU") break
                  else fails = 0
               }
               println("Introdueix la teva $BACK_LEMON$BLACK CONTRASENYA $RESET.")
               password = scanner.next()
            }while (password != userInformation[1])
            if (password == userInformation[1]) initiated = true
         }
         else initiated = true
      }
      else if(createUser.uppercase()  == "CREAR"){
         do {
            println("Introdueix el  $BACK_LEMON$BLACK USERNAME $RESET de 5 caracters que vols tenir:")
            userName = scanner.next()
            if (userName.length != 5){
               do {
                  println("Introdueix un $BACK_LEMON$BLACK USERNAME $RESET de 5 caracters:")
                  userName = scanner.next()
               }while (userName.length != 5)
            }
            userInformation = checkUser(userName)
            if (userInformation.isNotEmpty()){
               println("Aquest nom ja està en ús.")
            }
         } while (userInformation.isNotEmpty())
         println("Introdueix la teva $BACK_LEMON$BLACK CONTRASENYA $RESET.")
         val password = scanner.next()
         File("src/main/kotlin/DATA/usuarios.txt").appendText("userName:$userName,password:$password\n")
         initiated = true
      }
   }while (!initiated)

   // BENVINGUDA A L'USUARI ----------------------------------------------------------------------------------
   println("Benvingut $userName a Mastermind \n En aquesta nova entrega de Mastermind disposem de nous modes de joc disponibles,  " +
           "pel que abans de començar a jugar haurás d'escollir mode de joc,\n si no coneixes com funciona algún mode pots entrar al menú d'ajuda on podrás escollir de quin mode vols aprendre a jugar.")
   do {
      println("Menu Principal:\n" +
              "\t1. Mode clàssic\n" +
              "\t2. Mode 777\n" +
              "\t3. A contra rellotge")
      println("\t4. Menú d'ajudas")
      println("\t5. Historial personal")
      println("\t6. Rankings")
      println("7. SORTIR")
      val menuSelection = scanner.next()
      when(menuSelection){
         "1","2", "3"->{
            do {
               var colores = mutableListOf<String>()
               var inputsValidos = mutableListOf<String>()
               var sequencia = mutableListOf<String>()
               when (menuSelection){
                  "1" -> {
                     println("Mode Classic")
                     colores = mutableListOf("vermell","verd", "groc", "blau", "lila")
                     inputsValidos = mutableListOf("1","2","3","4", "5","vermell","verd", "groc", "blau", "lila", "r","g","y","b","p")
                     sequencia = secuenceGenerator(colores, 4)
                  }
                  "2" -> {
                     println("Mode 777")
                     colores = mutableListOf("vermell","verd", "groc", "blau", "lila", "taronja", "marró")
                     inputsValidos = mutableListOf("1","2","3","4", "5","6","7","vermell","verd", "groc", "blau", "lila","taronja", "marró", "r","g","y","b","p","o","m")
                     sequencia = secuenceGenerator(colores, 7)
                  }
                  "3" -> {
                     println("Mode a contra rellotge")
                     colores = mutableListOf("vermell","verd", "groc", "blau", "lila")
                     inputsValidos = mutableListOf("1","2","3","4", "5","vermell","verd", "groc", "blau", "lila", "r","g","y","b","p")
                     sequencia = secuenceGenerator(colores, 4)
                     firstDate = LocalDateTime.now()
                  }
               }
               userSelectionsList = mutableListOf()
               userComprovationsList = mutableListOf()
               var restart = ""
               val rondas = if (colores.size == 7) 6
                                              else 5
               for (i in 0 .. rondas){
                  userSelectionsList.add(mutableListOf())
                  do {
                     for (j in colores.indices){
                        print(printColores(colores[j]))
                        var iterator = 0
                        for (k in 1..3){
                           print("${inputsValidos[j + if (colores.size == 5) 5 * iterator else 7 * iterator]} ")
                           iterator ++
                        }
                        println()
                     }
                     userSelectionsList[i] = mutableListOf()
                     println("RONDA ${i+1}: ")
                     for (j in 0 until sequencia.size){
                        println("COLOR ${j+1}:")
                        userSelection = scanner.next().lowercase()
                        if (!(inputsValidos.contains(userSelection))) {
                           do {
                              println("Introdueix un color vàlid")
                              userSelection = scanner.next().lowercase()
                           }while (!(inputsValidos.contains(userSelection)) )
                        }
                        userSelectionsList[i].add(inputFormater(userSelection))
                     }
                     for (j in 0 until sequencia.size){
                        print("${printColores(userSelectionsList[i][j])} ")
                     }
                     println("\n Es aquesta la seqüéncia que volias posar? \n Escriu SI / NO")
                     var sentenceConfirmation = scanner.next().uppercase()
                     sentenceConfirmation = inputChecker(2, sentenceConfirmation, "Introdueix una de les opcions", "SI", "NO")
                  }while (sentenceConfirmation.uppercase() !="SI")
                  println()
                  userComprovationsList.add( sequenceCheker(userSelectionsList[i], sequencia, sequencia.size))
                  interficie(userName, i+1, userComprovationsList, userSelectionsList, !(menuSelection == "1" || menuSelection == "3"))
                  if (userSelectionsList[i] == sequencia) {
                     println("\n Has encertat enhorabona!! \n " +
                             "Si vols tornar a jugar NEW, si vols sortir EXIT.")
                     val final = scanner.next().uppercase()
                     restart = inputChecker(2, final, "Introdueix una de les opcions", "NEW", "EXIT")
                     File("src/main/kotlin/DATA/historial.txt").appendText(formaterToSave(userName, menuSelection.toInt(), i+1, firstDate))
                     break
                  }
                  if (i==rondas){
                     println("\n Has perdut :( \n " +
                             "Si vols tornar a jugar NEW, si vols sortir EXIT.")
                     val final = scanner.next().uppercase()
                     restart = inputChecker(2, final, "Introdueix una de les opcions", "NEW", "EXIT")
                     File("src/main/kotlin/DATA/historial.txt").appendText(formaterToSave(userName, menuSelection.toInt(), i+1, firstDate))
                  }
               }
            }while (restart.uppercase() != "EXIT")
         }
         "4"->{
            do {
               println("\nSobre quin mode vols ajuda?\n" +
                    "\t 1) Mode clàssic\n" +
                    "\t 2) Mode 777\n" +
                    "\t 3) A contre rellotge\n" +
                    "4) Tornar a l'altre menú")
               val menuAjuda = scanner.next()
               when (menuAjuda){
                  "1"-> instrucciones(1)
                  "2"-> instrucciones(2)
                  "3"-> instrucciones(3)
                  "4"->{}
                  else -> println("Introdueix una de les opcions possibles")
               }
            }while (menuAjuda != "4")}
         "5"->{
            val file = File ("src/main/kotlin/DATA/historial.txt")
            if (file.readText() != ""){
               val lineas = file.readLines()
               for (i in lineas.indices){
                  val names = lineas[i].split(",")[0]
                  if (names == userName) partidas.add(lineas[i].split(",").toMutableList())
               }
               if (partidas.isEmpty()) println("$BACK_YELLOW$BLACK$bold ${"No hi ha ninguna partida associada al teu usuari".uppercase()} $RESET\n")
               else {
                  interficieHistorial(partidas)
               }
            }
            else println("$BACK_YELLOW$BLACK$bold ${"No hi ha ninguna partida associada al teu usuari".uppercase()} $RESET\n")
         }
         "6"->{
            do {
               println(" De quin mode vols veure el ranking:\n" +
                       "\t1) Mode Clàssic\n" +
                       "\t2) Mode 777\n" +
                       "\t3) Mode A contra rellotge\n" +
                       "4)Tornar al menú principal")
               val rankingSelection = scanner.next()
               val file = File("src/main/kotlin/DATA/historial.txt")
               if (file.readText() != ""){
                  when(rankingSelection){
                     "1", "2", "3" -> println(rankingModes(rankingSelection))
                     "4"-> {}
                     else -> println("Introdueix una de les opcions possibles")
                  }
               }
               else println("$BACK_YELLOW$BLACK$bold ${"No hi han dades sobre cap partida realitzada".uppercase()} $RESET\n")
            } while (rankingSelection != "4")
         }
         "7"-> {}
         else -> {
            println("Has d'introduir una de les opcions del menú")
         }
      }
   }while (menuSelection != "7")
}