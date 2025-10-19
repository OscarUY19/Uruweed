package proyectofinal;

import java.util.Arrays;
import java.util.Scanner;

public class ProyectoFinal {
      int salud = 100, danio=0;
      
    void bienvenida() {
        try {
        System.out.println("Bienvenido a URUWEED ");
        Thread.sleep(2000); 
        System.out.println("Este juego esta ambientado en nuestro pais y te enfrentaras a enemigos tipicos de cada parte del Uruguay");
        Thread.sleep(2000); 
        System.out.println("Estas preparado??");
        Thread.sleep(2000); 
        }catch (InterruptedException e) {
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
                int vida=salud-15;
                System.out.println("Comienzas con " + vida + " Salud");
                break;
            case "interior":
                System.out.println("Escenario Seleccionado");
                vida=salud-20;
                System.out.println("Comienzas  con " + vida + " Salud");
                break;
            case "frontera":
                System.out.println("Escenario Seleccionado");
                vida=salud-30;
                System.out.println("Comienzas con " + vida + " Salud");
                break;
            default:
                System.out.println("Debe introducir un escenario correcto");
                break;

        }
    }
    void personajeH(){
        String hombre= "Leon";
        String equipamiento[]={"Pistola", "Cuchillo","Chaleco","Boqtiquin"};
        int cantidad[]={50,20,100,25};
        System.out.println("HAZ elegido a leon");
        salud=200;
        
    }
    void personajeM(){
        String equipamiento[]={"Escopeta", "Cuchillo","Chaleco","Linterna"};
        int cantidad[]={75,20,100,0};
        
        System.out.println("Elegiste a Jill Valentine");
        salud=150;
    }
    void seleccion(Scanner entrada){
        System.out.println("Selecciona a un perosnaje antes de comenzar" + " Leon S Kennedy" + "Jill Valentine");
        String personaje=entrada.nextLine().toLowerCase();
        
    }
    

    void inventario() {
        System.out.println("Selecciona tus articulos");
        String[] objetos = {"agua", "linterna", "comida"};
        System.out.println(Arrays.toString(objetos));
        

    }
    void batalla(Scanner entrada){
        int enemigo=150;
        System.out.println("Con que cantidad de poder deseas atacar");
        
        while(enemigo<10){
            System.out.println("El enemigo tiene poca vida");
            enemigo=entrada.nextInt();
        }
    }

    public static void main(String[] args) {
        ProyectoFinal ejercicio = new ProyectoFinal();
        Scanner entrada = new Scanner(System.in);

        
        
        String suministros[] = {"agua", "linterna", "Hacha", "Escudo", "Pistola"};
        String valija[] = {"Espacio0"};
        ejercicio.bienvenida();
        ejercicio.seleccion(entrada);
        ejercicio.inicio(entrada);
        //ejercicio.inventario();
       // ejercicio.batalla(entrada);

        // TODO code application logic here
    }

}
