/*********************************************
 * Gabriela Martin Torres                   *
 *                Curso de Programación Java *
 * Capitulo07/Terminos.java                  *
 *********************************************/

 /**
 * Esta clase representa estructuras de tipo
 * Termino utilizando un modelo dinámico
 *
 * Cada objeto de esta clase contendrá las
 * siguientes variables:
 * 	- Palabra (tipo String)
 *	- Raiz (tipo String)
 *	- Definicion (tipo String)
 *	- codigo (entero)
 *
 * Los métodos soportados por esta clase son:
 *   * Constructores
 *	- Termino (palabra, raiz, definicion, codigo)
 *   * Acceso a campos
 *	- raiz
 *	- definicion
 *	- poalabra
 *   * Operaciones sobre el objeto
 *	- 
 *
 * @author Gabriela
 */

class Termino {  
   private int      codigoTermino;
   String   palabraTermino;
   private String   raizTermino;
   private String   defTermino;
   Termino siguienteTermino;

      /** Constructor básico          *
        *  - Requiere necesariamente  *
        *        */
   public Termino (int codigo,String palabra,String raiz, String def) {
      codigoTermino = codigo;
      palabraTermino = palabra;
      raizTermino = raiz;
      defTermino = def ;

   }

      /** Funciones de acceso a los   *
        * campos privados de la clase */ 


   public int codigoTermino () {
      return codigoTermino;
   }


   public String palabraTermino () {
      return palabraTermino;
   }


    public String raizTermino () {
      return raizTermino;
   }


   public String defTermino () {
      return defTermino;
   }

      /** Funciones de modificacion de los   *
        * campos privados de la clase */ 


   public static Termino insertaTermino (Termino terminoInicial,
                                         Termino terminoNuevo) {
     if (terminoNuevo.codigoTermino < terminoInicial.codigoTermino) {
        terminoNuevo.siguienteTermino = terminoInicial;
        return terminoNuevo;
     } else {
        Termino terminoAux = terminoInicial;
        while (terminoAux != null) {
           if (terminoAux.siguienteTermino == null) {
              terminoAux.siguienteTermino = terminoNuevo;
              break;
           } else if (terminoAux.siguienteTermino.codigoTermino >
                      terminoNuevo.codigoTermino) {
              terminoNuevo.siguienteTermino = terminoAux.siguienteTermino;
              terminoAux.siguienteTermino = terminoNuevo;
              break;
           } else
              terminoAux = terminoAux.siguienteTermino;
        }
     }
     return terminoInicial;
  }



      /** Método toString para la       *
        * impresión del contenido de    *
	* de un objeto de tipo Termino */
   public String toString() {
      String imprime = palabraTermino + ":   "
                 + defTermino + "Raíz:" + raizTermino;
      return imprime;
   }

   public static Termino buscarTermino(Termino terminoInicial, String palabra) {
      Termino terminoAux = terminoInicial;
      while (terminoAux != null) {
         if (terminoAux.palabraTermino.equals(palabra))
           return terminoAux;
         terminoAux = terminoAux.siguienteTermino;
      }

      return null;
   }

   public static void listarTerminos(Termino terminoInicial) {
      System.out.println();
      System.out.println("LISTADO DE TERMINOS");
      Termino terminoAux = terminoInicial;
      while (terminoAux != null) {
         System.out.println(terminoAux);
         terminoAux = terminoAux.siguienteTermino;
      }
      System.out.println();
   }

   public static Termino borrarTermino (Termino terminoInicial,String palabra) {
      if (palabra.equals(terminoInicial.palabraTermino)) {
         terminoInicial = terminoInicial.siguienteTermino;
      } else {
         Termino terminoAux = terminoInicial;
         while (terminoAux != null) {
            if (terminoAux.siguienteTermino.palabraTermino.equals(palabra)) {
               terminoAux.siguienteTermino =
                            terminoAux.siguienteTermino.siguienteTermino;
               break;
            }
            terminoAux = terminoAux.siguienteTermino;
         }
      }
      return terminoInicial;
   }
}

/******** Fin de Terminos.java ***************/
