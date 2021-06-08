package EJERCICIOBATERIA;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // CREADO INSTANCIA DE LA BATERIA PARA SACAR LOS DATOS DE LA BATERIA POR EJEMPLO EL NIVEL Y SI ESTA LLENA
        Bateria bateria = new Bateria();
        // CREADO INSTANCIA DEL CONTROL PARA SACAR LOS DATOS DEL CONTROL COMO EL CARGAR Y DESCARGAR CON THREAD SE PONE ENTRE PARENTESIS BATERIA PORQUE CONTROL TAMBIEN NECESITA ACCEDER A BATERIA
        Control control = new Control(bateria);
        boolean bateriassssd=true;
        int respuesta;
        Scanner sc = new Scanner(System.in);
        while (bateriassssd==true){
            System.out.println("Que quieres hacer");
            System.out.println("1.Cargar bateria");
            System.out.println("2.Jugar");
            System.out.println("3.Info bateria");
            System.out.println("4.SALIR");
            respuesta = sc.nextInt();
            if (respuesta==1){
                if (bateria.carregada()==false){
                    control.carregar();
                    System.out.println("Cargando bateria");
                }
                System.out.println("Finalizado");
            }
            else if (respuesta==2){
                if (bateria.carregada()==true){
                    if (bateria.plena==true){
                        System.out.println("Jugando");
                        control.descargar();
                    }
                    System.out.println("carga la bateria para volver a jugar");
                }
                else if (bateria.carregada()==false){
                    System.out.println("Juego aun no esta listo");
                }
            }
            else if (respuesta==3){
                System.out.println("La bateria va por el " + bateria.getNivell() +  " Porciento" );
                System.out.println("EJERCICIOBATERIA.Bateria cargada? "+ bateria.carregada());
            }
            else if (respuesta==4){
                 bateriassssd=false;
            }
            else {
                System.out.println("Seleccion no valida");
            }
        }
        System.out.println("Fin");
    }
}
