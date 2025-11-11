package javaapplication9;

import java.util.Random;
import java.util.Scanner;

public class JavaApplication9 {

    void bienvenida() {
        try {
            System.out.println("********************************************************************************");
            System.out.println("********                 BIENVENIDO    A    URUWEED            *****************");
            System.out.println("********************************************************************************");
            Thread.sleep(2000);
            System.out.println("En esta aventura te toca ponerte en los zapatos de Obdulio, que con su termo y mate bajo el brazo");
            System.out.println("Le toca enfrentar a enemigos que quieren tomar su querido paisito");
            Thread.sleep(2000);
            System.out.println("Tendras la suficiente GARRA para VENCER");
            Thread.sleep(2000);
            System.out.println("Esta" + " GARRA " + " que proviene de la sangre Charrua que posee Obdulio en su interior");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Manejo de la excepción si el hilo es interrumpido
            Thread.currentThread().interrupt();
        }
    }
    
    int fuerza(){
       int garra=200;
        return garra;
    }

    int iniciar(Scanner entrada,int garra) {
        int energia = 300, saludJugador = -1;
        System.out.println("*******************************************");
        System.out.println("   PARA COMENZAR DEBES ELEGIR UN ESCENARIO  ");
        System.out.println("********************************************");

        System.out.println("LAS OPCIONES SON : 1-CAPITAL, 2-INTERIOR, 3-FRONTERA ");
        int escenario = entrada.nextInt();
        switch (escenario) {
            case 1:
                System.out.println("ESCENARIO SELECCIONADO");
                saludJugador = energia - 15;
                System.out.println("Cominezas con " + garra + " Garra");
                System.out.println("Comienzas con " + saludJugador + " Salud");
                break;
            case 2:
                System.out.println("ESCENARIO SELECCIONADO");
                saludJugador = energia - 20;
                System.out.println("Cominezas con " + garra + " Garra");
                System.out.println("Comienzas  con " + saludJugador + " Salud");
                break;
            case 3:
                System.out.println("ESCENARIO SELECCIONADO");
                saludJugador = energia - 30;
                System.out.println("Cominezas con " + garra + " Garra");
                System.out.println("Comienzas con " + saludJugador + " Salud");
                break;
            default:
                System.out.println("Debe introducir un escenario correcto");
                break;

        }
      
        return saludJugador;
        
        
    }

    String[] inventario(String[] suministro, Scanner entrada, boolean existe) {
        String suministros[] = new String[5];
        System.out.println("*******************************************");
        System.out.println("Puedes seleccionar los siguientes articulos:");
        System.out.println("*******************************************");
        System.out.println("Armas: cuchillo, boleadora, revolver.");
        
       
        System.out.println("Especiales: mate, agua, coquita.");
        System.out.println("********************************************");
        System.out.println("Selecciona tus articulos, PUEDES ELEGIR 2 DE CADA SECCION");
        System.out.println("Ingrese sus suministros (escriba 'eliminar' para borrar uno):");

        for (int i = 0; i < suministros.length; i++) {
            System.out.println("Ingrese el suministro que desea agregar " + i);
            String temporal = entrada.next();
           // System.out.println("Los suministros en la mochila " + suministros[i]);
            while (existe(suministros, temporal) == true) {
                System.out.println("Elemento repetido");
                temporal = entrada.next();
            }
            suministros[i] = temporal;
            if (i == 3) {
                System.out.println("Tienes el numero maximo de suministros");
            }
            if (suministros[i].equals("eliminar")) {
                System.out.println("Ingrese el numero de suministro a eliminar(1-6)");
                int eliminar = entrada.nextInt();
                entrada.nextLine();
                if (eliminar >= 1 && eliminar <= 6) {
                    System.out.println("Se elimino: " + suministros[eliminar - 1]);
                    suministros[eliminar - 1] = "eliminado";

                } else {
                    System.out.println("Numero invalido");
                }
            }

        }

        mostrarInventario(suministros);
        return suministros;

    }
     int potenciador(Scanner entrada, int saludJugador){
        System.out.println("Puedes recuperar algo de vida antes de enfrentar al jefe final");
         System.out.println("Selecciona 1-bizcochos, 2-milanesa, 3-asado");
        int eleccion=entrada.nextInt();
       
         switch (eleccion) {
            case 1:
                saludJugador+=20;
                System.out.println("Tenes " + saludJugador + " puntos de salud");
                break;
            case 2:
                saludJugador+=50;
                 System.out.println("Tenes " + saludJugador + " puntos de salud");
                break;
            case 3:
                saludJugador+=100;
                 System.out.println("Tenes " + saludJugador + " puntos de salud");
                 break;



            default:
                System.out.println("Eleccion invalida");
                break;
        }
        return saludJugador;
    }


    void mostrarInventario(String[] baul) {

        System.out.println("Los suministros ingresados son ");
        for (int i = 0; i < baul.length; i++) {
            System.out.println("suministros son " + i + " " + baul[i]);

        }
    }

    int pelea(String[] suministros, Scanner entrada, int saludJugador, int garra) {
        Random azar = new Random();

        String villano1 = " EL BRAIAN";
        String villano2 = " EL GAUCHO";
        String villano3 = "EL BAYANO";
        String nombreVillano = "";

        int enemigo = 0;

        System.out.println("Elije el enemigo a enfrentar 1-EL BRAIAN, 2-EL GAUCHO, 3-EL BAYANO");
        int escenario = entrada.nextInt();
        System.out.println("Emepezas " + saludJugador + " puntos de salud");
        System.out.println("Vas a tener  " + garra + " GARRA");

        switch (escenario) {
            case 1:
                System.out.println("Vas a enfrentar a: " + villano1);
                enemigo = 150;
                nombreVillano = villano1;
                break;
            case 2:
                System.out.println("Vas a enfrentar a: " + villano2);
                enemigo = 200;
                nombreVillano = villano2;
                break;
            case 3:
                System.out.println("Vas a enfrentar a: " + villano3);
                enemigo = 300;
                nombreVillano = villano3;
                break;
            default:
                System.out.println("OPCION INVALIDA, ELIJA UNA OPCION ENTRE 1-3");
                break;
        }

        System.out.println("Elige un objeto para usar:");
        for (int i = 0; i < suministros.length; i++) {
            System.out.println((i) + " - " + suministros[i]);
        }
        int itemElegido = entrada.nextInt();
        System.out.println("Elegiste " + itemElegido);
        switch (itemElegido) {
            case 0:
                 garra+=20;
                System.out.println("obtienes " + garra + " GARRA");
               
                break;
                case 1:
                  garra+=30;  
                System.out.println("obtienes " + garra + " GARRA");
                
                break;
                case 2:
                  garra+=40;   
                System.out.println("obtienes " + garra + " GARRA");
               
                break;
                case 3:
                  garra+=50;  
                System.out.println("obtienes " + garra + " GARRA");
                
                break;
                case 4:
                  garra+=60;  
                System.out.println("obtienes " + garra + " GARRA");
                
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }
        System.out.println("****************************************");
        System.out.println("          EMPIEZA EL COMBATE ");
        System.out.println("***************************************");

        for (int turno = 1; turno <= 3; turno++) {
            System.out.print("¿Con qué cantidad de GARRA deseas atacar? ");
            int poder = entrada.nextInt();
            if (poder<= 0) {
                System.out.println("No puedes atacar con GARRA 0 o negativo. Perdiste el turno.");
            } else {
                enemigo -= poder;
                System.out.println("Atacaste con " + poder + " de GARRA. Salud restante de " + nombreVillano + " es " + enemigo);
            }

            if (enemigo <= 0) {
                System.out.println("Lograste vencer al enemigo ");
                turno = 3;
            } else {
                System.out.println("La Batalla continua " + "Tu puedes!");
            }
            int golpeEnemigo = azar.nextInt(100) + 1;
            saludJugador -= golpeEnemigo;
            garra-=poder;
            System.out.println(" te contraataca con " + golpeEnemigo + " de daño!");
            System.out.println("Tu salud restante es " + saludJugador);
            System.out.println("Tu GARRA restante es " + garra);

        }
        System.out.println("***************************************");
        System.out.println("           COMBATE TERMINADO           ");
        System.out.println("***************************************");

        if (enemigo <= 0) {
            System.out.println("¡GANASTE! " + nombreVillano);
        } else if (saludJugador <= 0) {
            System.out.println("PERDISTE... " + nombreVillano);
        }

        return saludJugador;
        

    }

    
    boolean existe(String[] inventario, String suministros) {
        boolean encontrado = false;
        int i = 0;
        while (!encontrado && i < inventario.length) {
            if (inventario[i] == null) {
                i++;
            } else if (inventario[i].equalsIgnoreCase(suministros)) {
                encontrado = true;
            } else {
                i++;
            }
        }
        return encontrado;
    }

    int jefe(Scanner entrada, int saludJugador, String[] suministros, int potenciador, int garra) {
        Random azar = new Random();
        String boss = " EL GENERAL FRUCTUOSO RIVERA";

        int saludEnemigo = 400;
        System.out.println("************************************************************");
        System.out.println("****   ENFRENTAS  AL  JEFE  FINAL " + boss + "  ******");
        System.out.println("************************************************************");
        
        System.out.println(garra);

        do {
            System.out.println("Con cuanta GARRA deseas atacar??");
            garra = entrada.nextInt();
            int golpeEnemigo = azar.nextInt(80) + 1;
            saludJugador -= golpeEnemigo;
            saludEnemigo -= garra;
            System.out.println("Atacas a " + boss + ". ¡Le quedan " + "---" + " de salud!");
            if (saludEnemigo <= 0) {
                System.out.println("Enemigo muerto");
            } else {
                System.out.println("Debes continuar Sobreviviendo");
            }
            System.out.println(boss + " te ataca por " + golpeEnemigo + " de daño.");
            System.out.println("Te quedan " + saludJugador + " de salud.");

            if (saludJugador < 50) {
                System.out.println("¡Estás en estado crítico!");
            }

            if (saludJugador <= 0) {
                System.out.println("Moriste " + saludJugador);
            }

        } while (saludJugador > 0 && saludEnemigo > 0);
        if (saludEnemigo <= 0) {
            System.out.println("GANASTE " + boss);
        } else {
            System.out.println("FUISTE DERROTADO POR:  " + boss);
        }
        System.out.println("***********************************");
        System.out.println("            FIN DEL JUEGO          ");
        System.out.println("***********************************");

        return saludJugador;
        
    }

    public static void main(String[] args) {
        JavaApplication9 ejercicio = new JavaApplication9();
        Scanner entrada = new Scanner(System.in);
        boolean existe = false;
        String suministros[] = new String[6];
        // String nombres[] = {"Shana", "OScar", "Lucas"};
       
       int garra=ejercicio.fuerza();
        // System.out.println(salud);
       // ejercicio.bienvenida();
        int saludJugador = ejercicio.iniciar(entrada, garra);
       // int garra=ejercicio.iniciar(entrada);

        suministros = ejercicio.inventario(suministros, entrada, existe);
      

        saludJugador = ejercicio.pelea(suministros, entrada, saludJugador, garra);
        int potenciador=ejercicio.potenciador(entrada, saludJugador);
        saludJugador = ejercicio.jefe(entrada, saludJugador, suministros,potenciador, garra);

        // TODO code application logic here
    }

}
