/*********************************************
 * Gabriela Martin                           *
 *                Curso de Programación Java *
 * Capitulo07/Diccionario.java               *
 *********************************************/

 /**
 * Esta clase implementa el sistema de       *
 * control de terminos de un diccionario     *
 * @author Gabriela Martin                   */

class Diccionario {
  static Diccionario diccionarioInicial = null;

  private int      codigoDiccionario;
  private  String   nombreDiccionario;
  Diccionario  siguienteDiccionario;
  private int      totalTerminos;
  Termino terminoInicial;

      /** Constructor básico          *
        *  - Requiere necesariamente  *
        *    un codigo y un nombre    */
   public Diccionario(int codigo,String nombre) {
      codigoDiccionario = codigo;
      nombreDiccionario = nombre;
      totalTerminos = 0;
      siguienteDiccionario = null;
      terminoInicial = null;

      if (diccionarioInicial == null)
         diccionarioInicial = this;
      else if (diccionarioInicial.codigoDiccionario > codigo) {
         this.siguienteDiccionario = diccionarioInicial;
         diccionarioInicial = this;
      } else {
         Diccionario diccionarioAux = diccionarioInicial;
         while (diccionarioAux.siguienteDiccionario != null) {
            if (diccionarioAux.siguienteDiccionario.codigoDiccionario > codigo) {
              this.siguienteDiccionario = diccionarioAux.siguienteDiccionario;
              diccionarioAux.siguienteDiccionario = this;
              return;
            }
            diccionarioAux = diccionarioAux.siguienteDiccionario;
         }
         diccionarioAux.siguienteDiccionario = this;
      }
   }


  public  void gestionDiccionario() {
    System.out.println
        ("Sistema Diccionario: Gestion de terminos");

    int operacion;
    do {
       System.out.println();
       System.out.println("Diccionario: " + codigoDiccionario + "  " 
                          + nombreDiccionario);
       System.out.println();
       System.out.println("[1] Crear un termino nuevo");
       System.out.println("[2] Buscar un termino");
       System.out.println("[3] Borrar un termino");
       System.out.println("[4] Listado de terminos");
       System.out.println("[0] Salir");
       do {
          operacion = Terminal.leeEntero
            ("Indique una operacion: ");
         } while ((operacion < 0) ||
          (operacion > 4));
         System.out.println();
         if (operacion == 1)
            crearTermino();
         else if (operacion == 2)
            buscarTermino();
         else if (operacion == 3)
            borrarTermino();
         else if (operacion == 4)
            listarTerminos();
      } while (operacion != 0);
   }

  public static Diccionario buscarDiccionario(int codigo) {
    Diccionario diccionarioAux = diccionarioInicial;

    while (diccionarioAux != null) {
      if (diccionarioAux.codigoDiccionario == codigo)
        return diccionarioAux;
      diccionarioAux = diccionarioAux.siguienteDiccionario;
    }
    return null;
  }

  public static void borrarDiccionario (int codigo) {
    if (diccionarioInicial.codigoDiccionario == codigo) {
     diccionarioInicial = diccionarioInicial.siguienteDiccionario;
    } else {
      Diccionario diccionarioAux = diccionarioInicial;
      while (diccionarioAux.siguienteDiccionario != null) {
        if (diccionarioAux.siguienteDiccionario.codigoDiccionario == codigo) {
          diccionarioAux.siguienteDiccionario = 
                     diccionarioAux.siguienteDiccionario.siguienteDiccionario;
          break;
        }
        diccionarioAux = diccionarioAux.siguienteDiccionario;
      }
    }
  }

  public static void listarDiccionarios() {
    Diccionario diccionarioAux = diccionarioInicial;

    while (diccionarioAux != null) {
      System.out.println(diccionarioAux);
      diccionarioAux = diccionarioAux.siguienteDiccionario;
    }
  }

      /** Método toString para la       *
        * impresión del contenido de    *
        * de un objeto de tipo Diccionario  */
   public String toString() {
      String imprime = "Diccionario: " +  "   "
                 + codigoDiccionario + "   " 
                 + nombreDiccionario + "  (Terminos: " 
                 + totalTerminos + ")";
      return imprime;
   }

  private  void crearTermino() {
    System.out.println("CREACION DE UN NUEVO TERMINO:");

    String palabra  ;
    do {
        palabra = Terminal.leeCadena("PALABRA?: ");
    } while (Termino.buscarTermino(terminoInicial,palabra) != null); 
    
    int numero = Terminal.leeEntero("CODIGO ?: ");         
    
    String raiz = Terminal.leeCadena("RAIZ?: ");
    String def = Terminal.leeCadena("DEFINICION?: ");
    


    Termino termino = new Termino(numero,palabra,raiz,def);

    if (terminoInicial == null)
       terminoInicial = termino;
    else
       terminoInicial = Termino.insertaTermino(terminoInicial,termino);

    totalTerminos++;
  }
  
  public void buscarTermino(){
    System.out.println("BUSCAR UN TERMINO");
    
    String palabra;

   
      palabra    = Terminal.leeCadena("PALABRA ?: ");
 if (Termino.buscarTermino(terminoInicial,palabra) == null ){
     System.out.println("NO EXISTE EL TÉRMINO");
    }
    else 
    System.out.println(Termino.buscarTermino(terminoInicial,palabra));
  }
  

  public void listarTerminos() {
    System.out.println(this);

    Termino.listarTerminos(terminoInicial);
  }

  private void borrarTermino() {
    System.out.println("BORRAR UN TERMINO");

    String palabra;

    do {
      palabra    = Terminal.leeCadena("PALABRA ?: ");
    } while (Termino.buscarTermino(terminoInicial,palabra) == null); 
      
    terminoInicial = Termino.borrarTermino(terminoInicial,palabra);
  }

}

/******** Fin de Diccionario.java ****************/
