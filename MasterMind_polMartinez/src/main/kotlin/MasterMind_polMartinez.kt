//Projecte MasterMind
//Author:Pol Martínez
import java.util.*
fun main() {

   println { "!! MasterMind ¡¡\n".bold}
   println { ("Abans de començar a jugar farem una breu explicació de com funciona el joc:").underline }
   println("El joc consisteix en endivinar la possició en la qual es troben els colors. Hi han 4 possicions en les quals poden haver-hi colors i 5 diferents colors: ")
   print{("\t\t\to".red+ " (vermell), ") }
   print { ("o".green+" (verd), ") }
   print { ("o".blue+" (blau), ") }
   print { ("o".yellow+" (groc) i ") }
   println { ("o".purple+" (lila).") }
   println("")
   println { ("Una vegada feta la introducció passem a les normes i funcionament:").underline }
   println(""" - En la secuencia de colors no es trobará cap color repetit.
 - Per cada posició tindras un comprovador el qual tindra 3 senyals difrents per que sapigues si vas en bon camí: 
            - × Aquest simból a la posició d'un color significa que aquest color no es troba a la sequencia.
            - Ø Aquest simból a la posició d'un color significa que aquest color es troba a la sequencia, pero no a la possició que has escollit.
            - O Aquest simból a la posició d'un color significa que aquest color es troba a la sequencia i a la possició que has escollit.
 -La partida consisteix de 6 torns, en cas de no arribar a completar la seqüéncia haurás perdut.
 -Haurás d'introduir el nom dels colors en minuscules.
 """)
print{("Per simplificar la jugavilitat abans de confirmar la jugada t'apareixerà una representació amb els colors introduits,\n" +
        "en cas de que volguis corregir algo abans d'enviar la jugada haurás d'escriure RETURN sino CONFIRM.").underline}

}