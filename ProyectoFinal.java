package proyectofinal;

import java.util.Scanner;
import java.util.Random;


public class ProyectoFinal {
 String suministros[] = new String[6];
    

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

    void inicio(Scanner entrada) {
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

    void personajeH() {
        String hombre = "Leon";
        String equipamiento[] = {"Pistola", "Cuchillo", "Chaleco", "Boqtiquin"};
        int cantidad[] = {50, 20, 100, 25};
        System.out.println("HAZ elegido a leon");
        int salud = 200;

    }

    void personajeM() {
        String equipamiento[] = {"Escopeta", "Cuchillo", "Chaleco", "Linterna"};
        int cantidad[] = {75, 20, 100, 0};

        System.out.println("Elegiste a Jill Valentine");
      int  salud = 150;
    }

    void seleccion(Scanner entrada) {
        System.out.println("Selecciona a un perosnaje antes de comenzar" + " Leon S Kennedy" + "Jill Valentine");
        String personaje = entrada.nextLine().toLowerCase();

    }

    void inventario(String suministro, Scanner entrada) {
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

    void batalla(Scanner entrada) {
         Random azar = new Random();
        System.out.println("Elije el enemigo a enfrentar 1-EL BRAIAN, 2-EL GAUCHO, 3-EL VALLANO");
        int escenario=entrada.nextInt();
        int saludJugador=200, enemigo=0;
        
        if(escenario==1){
            System.out.println("Enemigo seleccionado EL BRAIAN");
           enemigo=150;
        }else if(escenario==2){
            System.out.println("Enemigo seleccionado EL GAUCHO");
            enemigo=200;
        }else if(escenario==3){
            System.out.println("Enemigo seleccionado EL VALLANO");
            enemigo=250;
        }else{
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
        int golpeEnemigo=azar.nextInt(50)+1;
        saludJugador -= golpeEnemigo;
        System.out.println( " te contraataca con " + golpeEnemigo+ " de daño!");
    }

        
         if (saludJugador > enemigo) {
            System.out.println("¡Has derrotado");
            
        }
            
        }
        
       

        
    }

    public static void main(String[] args) {
        ProyectoFinal ejercicio = new ProyectoFinal();
        Scanner entrada = new Scanner(System.in);
        Random azar = new Random();
        

        String valija[] = {"Espacio0"};
       // ejercicio.bienvenida();
        // ejercicio.seleccion(entrada);
         ejercicio.inicio(entrada);
        //  ejercicio.inventario(entrada);
         ejercicio.batalla(entrada);
      

        // TODO code application logic here
    }



