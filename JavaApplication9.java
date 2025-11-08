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
            System.out.println("En esta aventura te toca ponerte en los zapatos de Obdulio, que con su termo y mate bajo el brazo"
                    + "le toca enfrentar a enemigos que quieren tomar su querido paisito");
            Thread.sleep(2000);
            System.out.println("Tendras el suficiente PODER para VENCER");
            Thread.sleep(2000);
            System.out.println("Este" + " PODER " + " que viene de la sangre Charrua y de la GARRA que posee Obdulio");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Manejo de la excepción si el hilo es interrumpido
            Thread.currentThread().interrupt();
        }
    }

    int iniciar(Scanner entrada) {
        int energia = 500, salud = -1;
        System.out.println("*******************************************");
        System.out.println("   PARA COMENZAR DEBES ELEGIR UN ESCENARIO  ");
        System.out.println("********************************************");

        System.out.println("LAS OPCIONES SON : 1-CAPITAL, 2-INTERIOR, 3-FRONTERA ");
        int escenario = entrada.nextInt();
        switch (escenario) {
            case 1:
                System.out.println("ESCENARIO SELECCIONADO");
                salud = energia - 15;
                System.out.println("Comienzas con " + salud + " Salud");
                break;
            case 2:
                System.out.println("ESCENARIO SELECCIONADO");
                salud = energia - 20;
                System.out.println("Comienzas  con " + salud + " Salud");
                break;
            case 3:
                System.out.println("ESCENARIO SELECCIONADO");
                salud = energia - 30;
                System.out.println("Comienzas con " + salud + " Salud");
                break;
            default:
                System.out.println("Debe introducir un escenario correcto");
                break;

        }
        return salud;
    }

    String[] inventario(String[] suministro, Scanner entrada) {
        String suministros[] = new String[6];
        System.out.println("*******************************************");
        System.out.println("Puedes seleccionar los siguientes articulos:");
        System.out.println("*******************************************");
        System.out.println("Armas: cuchillo, boleadora, revolver.");
        System.out.println("Salud: asado, milanesa, bizcochos.");
        System.out.println("Especiales: mate, agua, coquita.");
        System.out.println("********************************************");
        System.out.println("Selecciona tus articulos, PUEDES ELEGIR 2 DE CADA SECCION");
        System.out.println("Ingrese sus suministros (escriba 'eliminar' para borrar uno):");

        for (int i = 0; i < suministros.length; i++) {
            System.out.println("Ingrese el suministro que desea agregar " + i);

            suministros[i] = entrada.nextLine().toLowerCase();
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

    void mostrarInventario(String[] baul) {

        System.out.println("Los suministros ingresados son ");
        for (int i = 0; i < baul.length; i++) {
            System.out.println("suministros son " + i + " " + baul[i]);

        }
    }

    int pelea(String[] suministros, Scanner entrada) {
        Random azar = new Random();

        String villano1 = " EL BRAIAN";
        String villano2 = " EL GAUCHO";
        String villano3 = "EL BAYANO";
        String nombreVillano = "";

        int saludJugador = 200, enemigo = 0;

        System.out.println("Elije el enemigo a enfrentar 1-EL BRAIAN, 2-EL GAUCHO, 3-EL BAYANO");
        int escenario = entrada.nextInt();

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
                System.out.println("Vas a enfrenatar a: " + villano3);
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
        System.out.println("La batalla comienza. ¡Tendrás 3 rondas!");
        System.out.println("***************************************");

        for (int turno = 1; turno <= 3; turno++) {
            System.out.print("¿Con qué cantidad de poder deseas atacar? ");
            int poder = entrada.nextInt();
            if (poder <= 0) {
                System.out.println("No puedes atacar con poder 0 o negativo. Perdiste el turno.");
            } else {
                enemigo -= poder;
                System.out.println("Atacaste con " + poder + " de poder. Salud restante de " + nombreVillano + " es " + enemigo);
            }

            if (enemigo <= 0) {
                System.out.println("Lograste vencer al enemigo ");
                turno = 3;
            } else {
                System.out.println("La Batalla continua " + "Tu puedes!");
            }
            int golpeEnemigo = azar.nextInt(100) + 1;
            saludJugador -= golpeEnemigo;
            System.out.println(" te contraataca con " + golpeEnemigo + " de daño!");
            System.out.println("Tu salud restante es " + saludJugador);

        }
        System.out.println("***************************************");
        System.out.println("La batalla ha terminado.");

        if (enemigo <= 0) {
            System.out.println("¡GANASTE! " + nombreVillano);
        } else if (saludJugador <= 0) {
            System.out.println("PERDISTE... " + nombreVillano);
        }

        return saludJugador;

    }

    /*int decision(){
        
        
        if (saludJugador == 0) {
            System.out.println("¡Has perdido");

        } else {
            System.out.println("HAs ganado");
        }
    }*/
    boolean existe(String[] inventario, String suministros) {
        boolean encontrado = false;
        int i = 0;
        while (!encontrado && i < inventario.length) {
            if (inventario[i].equalsIgnoreCase(suministros)) {
                encontrado = true;
            }
            i++;
        }
        return encontrado;
    }

    int jefe(Scanner entrada, int saludJugador, String[] suministros) {
        Random azar = new Random();
        String boss = " EL GENERAL FRUCTUOSO RIVERA";

        int saludEnemigo = 400;
        System.out.println("************************************************************");
        System.out.println("****        ENFRENTAS  AL  JEFE  FINAL " + boss + "  ******");
        System.out.println("************************************************************");

        do {
            System.out.println("Con cuanto PODER deseas atacar??");
            int ataque = entrada.nextInt();
            int golpeEnemigo = azar.nextInt(80) + 1;
            saludJugador -= golpeEnemigo;
            saludEnemigo -= ataque;
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

        // String nombres[] = {"Shana", "OScar", "Lucas"};
        // int salud = ejercicio.iniciar(entrada);
        // System.out.println(salud);
        ejercicio.bienvenida();
        ejercicio.iniciar(entrada);

        String suministros[] = new String[6];
        suministros = ejercicio.inventario(suministros, entrada);
        int saludJugador = ejercicio.pelea(suministros, entrada);
        //ejercicio.existe(inventario,suministros);

        ejercicio.pelea(suministros, entrada);
        ejercicio.jefe(saludJugador, suministros, entrada);

        // TODO code application logic here
    }

}
