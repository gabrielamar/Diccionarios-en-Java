/*********************************************
 * Gabriela Martin                           *
 *                Curso de Programación Java *
 * Capitulo07/Lexico.java                    *
 *********************************************/

 /**
 * Esta clase implementa el sistema de       *
 * control de diccionarios                   *
 * @author Gabriela Martin                   */

class Lexico {
  public static void main (String args[]) {
    System.out.println
        ("Sistema Lexico");

    int operacion;
    do {
       System.out.println();
       System.out.println("[1] Crear un diccionario nuevo");
       System.out.println("[2] Gestión de un diccionario");
       System.out.println("[3] Borrar un diccionario");
       System.out.println("[4] Listado de los diccionarios creados");
       System.out.println("[5] Buscar un termino en todos los diccionarios");
       System.out.println("[6] Buscar un subtermino en todos los diccionarios");
       System.out.println("[0] Salir");
       do {
          operacion = Terminal.leeEntero
            ("Indique una operacion: ");
         } while ((operacion < 0) ||
          (operacion > 6));
         System.out.println();
         if (operacion == 1)
            crearDiccionario();
         else if (operacion == 2)
            gestionDiccionario();
         else if (operacion == 3)
            borrarDiccionario();
         else if (operacion == 4)
            Diccionario.listarDiccionarios();
         else if (operacion == 5)
            buscarTerminoTodos();
         else if (operacion == 6)
         buscarSubterminoTodos();
      } while (operacion != 0);
   }

  private static void crearDiccionario() {
    System.out.println("CREACION DE UN DICCIONARIO:");

    int codigo;
    do {
      codigo    = Terminal.leeEntero("CODIGO ?: ");
    } while ((codigo <= 0) ||
             (Diccionario.buscarDiccionario(codigo) != null)); 
      
    String nombre = Terminal.leeCadena("NOMBRE?: ");

    new Diccionario(codigo,nombre);
  }

  private static void gestionDiccionario() {
    System.out.println("ACCESO A LA GESTION DE UN DICCIONARIO");

    int codigo;
    Diccionario dicc;

    do {
      codigo    = Terminal.leeEntero("CODIGO ?: ");
    } while ((codigo <= 0) ||
             ((dicc = Diccionario.buscarDiccionario(codigo)) == null)); 
      
    dicc.gestionDiccionario();
  }


  private static void borrarDiccionario() {
    System.out.println("BORRAR UN DICCIONARIO");

    int codigo;

    do {
      codigo    = Terminal.leeEntero("CODIGO ?: ");
    } while ((codigo <= 0) ||
             (Diccionario.buscarDiccionario(codigo) == null)); 
      
    Diccionario.borrarDiccionario(codigo);
  }

 public static void buscarTerminoTodos(){
 System.out.println("BUSCAR UN TERMINO EN TODOS LOS DICCIONARIOS");
    
 String  palabra = Terminal.leeCadena("PALABRA ?: ");
    
Diccionario diccionarioAux = Diccionario.diccionarioInicial;

    while (diccionarioAux != null) {
     
   if (Termino.buscarTermino(diccionarioAux.terminoInicial,palabra) != null) {
    System.out.println(Termino.buscarTermino(diccionarioAux.terminoInicial,palabra));
   }

 diccionarioAux = diccionarioAux.siguienteDiccionario;
 
}
 
}

public static void buscarSubterminoTodos() {
    System.out.println("BUSCAR UN SUBTERMINO EN TODOS LOS DICCIONARIOS");
    String palabra = Terminal.leeCadena("SUBPALABRA ? : ");
    Diccionario diccionarioAux = Diccionario.diccionarioInicial;
    while (diccionarioAux != null) {

        Termino terminoAux = diccionarioAux.terminoInicial;
        String palabraAux = terminoAux.palabraTermino;
        while (terminoAux != null) {
                palabraAux = terminoAux.palabraTermino;
                if(palabraAux.indexOf(palabra)>-1){
                System.out.println(palabraAux);}
                
                terminoAux = terminoAux.siguienteTermino;

        }
                diccionarioAux = diccionarioAux.siguienteDiccionario;

            }
}
 
}


/******** Fin de Lexico.java ****************/
