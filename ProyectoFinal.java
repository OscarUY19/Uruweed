package proyectofinal;

import java.util.Scanner;

public class ProyectoFinal {

    int salud = 100, danio = 0;

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
        System.out.println("Selecciona uno de los siguientes escenarios");
        System.out.println("Elige entre:CAPITAL, INTERIOR, FRONTERA");
        String escenario = entrada.nextLine().toLowerCase();
        switch (escenario) {
            case "capital":
                System.out.println("Escenario Seleccionado");
                int vida = salud - 15;
                System.out.println("Comienzas con " + vida + " Salud");
                break;
            case "interior":
                System.out.println("Escenario Seleccionado");
                vida = salud - 20;
                System.out.println("Comienzas  con " + vida + " Salud");
                break;
            case "frontera":
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
        salud = 200;

    }

    void personajeM() {
        String equipamiento[] = {"Escopeta", "Cuchillo", "Chaleco", "Linterna"};
        int cantidad[] = {75, 20, 100, 0};

        System.out.println("Elegiste a Jill Valentine");
        salud = 150;
    }

    void seleccion(Scanner entrada) {
        System.out.println("Selecciona a un perosnaje antes de comenzar" + " Leon S Kennedy" + "Jill Valentine");
        String personaje = entrada.nextLine().toLowerCase();

    }

    void inventario(Scanner entrada) {
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
        int enemigo = 150;
        System.out.println("Con que cantidad de poder deseas atacar");

        while (enemigo < 10) {
            System.out.println("El enemigo tiene poca vida");
            enemigo = entrada.nextInt();
        }
    }

    public static void main(String[] args) {
        ProyectoFinal ejercicio = new ProyectoFinal();
        Scanner entrada = new Scanner(System.in);

        String valija[] = {"Espacio0"};
        ejercicio.bienvenida();
        // ejercicio.seleccion(entrada);
        // ejercicio.inicio(entrada);
        //ejercicio.inventario();
        // ejercicio.batalla(entrada);
        ejercicio.inventario(entrada);

        // TODO code application logic here
    }

}
