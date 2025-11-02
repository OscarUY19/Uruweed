package javaapplication9;

import java.util.Random;
import java.util.Scanner;

public class JavaApplication9 {

    void bienvenida() {
        try {
            System.out.println("Bienvenido a URUWEED ");
            Thread.sleep(2000);
            System.out.println("Este juego esta ambientado en nuestro pais y te enfrentaras a enemigos tipicos de cada parte del Uruguay");
            Thread.sleep(2000);
            System.out.println("Estas preparado??");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Manejo de la excepción si el hilo es interrumpido
            Thread.currentThread().interrupt();
        }
    }

    void iniciar(Scanner entrada) {
        int salud = 100;
        System.out.println("Selecciona uno de los siguientes escenarios");
        System.out.println("Elige entre: 1-CAPITAL, 2-INTERIOR,3-FRONTERA");
        int escenario = entrada.nextInt();
        switch (escenario) {
            case 1:
                System.out.println("Escenario Seleccionado");
                int vida = salud - 15;
                System.out.println("Comienzas con " + vida + " Salud");
                break;
            case 2:
                System.out.println("Escenario Seleccionado");
                vida = salud - 20;
                System.out.println("Comienzas  con " + vida + " Salud");
                break;
            case 3:
                System.out.println("Escenario Seleccionado");
                vida = salud - 30;
                System.out.println("Comienzas con " + vida + " Salud");
                break;
            default:
                System.out.println("Debe introducir un escenario correcto");
                break;

        }
    }

    void inventario(String[] suministro, Scanner entrada) {
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
        System.out.println("Los suministros ingresados son ");
        for (int i = 0; i < suministros.length; i++) {
            System.out.println("suministros son " + i + " " + suministros[i]);

        }

    }

    void pelea(Scanner entrada) {
        String suministros[] = new String[6];

        Random azar = new Random();
        System.out.println("Elije el enemigo a enfrentar 1-EL BRAIAN, 2-EL GAUCHO, 3-EL VALLANO");
        int escenario = entrada.nextInt();
        int saludJugador = 200, enemigo = 0;

        if (escenario == 1) {
            System.out.println("Enemigo seleccionado EL BRAIAN");
            enemigo = 150;
        } else if (escenario == 2) {
            System.out.println("Enemigo seleccionado EL GAUCHO");
            enemigo = 200;
        } else if (escenario == 3) {
            System.out.println("Enemigo seleccionado EL VALLANO");
            enemigo = 250;
        } else {
            System.out.println("Opcion Invalida");
        }
        System.out.println("Elige un objeto para usar:");
        for (int i = 0; i < suministros.length; i++) {
            System.out.println((i) + " - " + suministros[i]);
        }
        int itemElegido = entrada.nextInt();
        System.out.println("Elegiste " + itemElegido);
        System.out.println("La batalla comienza. ¡Tendrás 3 rondas!");
        for (int turno = 1; turno <= 3; turno++) {
            System.out.print("¿Con qué cantidad de poder deseas atacar? ");
            int poder = entrada.nextInt();
            if (poder <= 0) {
                System.out.println("No puedes atacar con poder 0 o negativo. Perdiste el turno.");
            } else {
                enemigo -= poder;
                System.out.println("Atacaste con " + poder + " de poder. Salud restante del enemigo: " + enemigo);
            }
            int golpeEnemigo = azar.nextInt(100) + 1;
            saludJugador -= golpeEnemigo;
            System.out.println(" te contraataca con " + golpeEnemigo + " de daño!");
            System.out.println("Tu salud restante es " + saludJugador);

        }
        if (saludJugador == 0) {
            System.out.println("¡Has perdido");

        } else {
            System.out.println("HAs ganado");
        }
    }

    public static void main(String[] args) {

        JavaApplication9 ejercicio = new JavaApplication9();
        Scanner entrada = new Scanner(System.in);
        ejercicio.bienvenida();
        ejercicio.iniciar(entrada);
       // ejercicio.inventario(suministros, entrada);
        ejercicio.pelea(entrada);

        // TODO code application logic here
    }

}
