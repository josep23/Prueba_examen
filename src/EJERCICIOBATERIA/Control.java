package EJERCICIOBATERIA;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Control extends Thread{
    Bateria bateria;
    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

    public Control(Bateria bateria) {
        this.bateria = bateria;
    }

    //EJECUTA EL RUNNABLE
    void descargar() {
        executor.submit(descarregar);
    }

    //ENCIENDE EL RUNABLE ES DECIR LO EJECUTA
    Runnable descarregar = new Runnable() {
        public void run() {
            //MIENTRAS LA BATERIA NO LLEGUE A 0 LE HACE UN BATERIA DESCARGAR QUE LE RESTA 1 A NIVEL
            // Y APARTE ESPERA 300 MILISEGUNDOS PARA VOLVER A PROBAR
            //EL BATERIA.GETNIVELL!=0 SE PONE PORQUE ASI TE ASEGURAS DE QUE LA BATERIA LLEGUE A 0
            //Y NO SE QUEDE AL 60 POR EJEMPLO
            // EL THREAD SLEEP SE HACE PARA QUE ESPERE 300 MILISEGUNDOS SOLO LA OPCION DE CARGAR Y NO TODO EL PROGRAMA
            while (bateria.getNivell()!=0) {
                bateria.descarregar();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    void carregar() {
        System.out.println("Carregant bateria...");
        executor.submit(carrega);
    }

    Runnable carrega = new Runnable() {
        public void run() {
            //MIENTRAS LA BATERIA NO LLEGUE A 100 LE HACE UN BATERIA CARGAR QUE LE SUMA 1 A NIVEL
            // Y APARTE ESPERA 300 MILISEGUNDOS PARA VOLVER A PROBAR
            //EL BATERIA.GETNIVELL!=100 SE PONE PORQUE ASI TE ASEGURAS DE QUE LA BATERIA LLEGUE A 100
            //Y NO SE QUEDE AL 60 POR EJEMPLO
            // EL THREAD SLEEP SE HACE PARA QUE ESPERE 300 MILISEGUNDOS SOLO LA OPCION DE CARGAR Y NO TODO EL PROGRAMA
            while (bateria.getNivell()!=100) {
                bateria.carregar();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (bateria.plena==true){
                System.out.println("////////////////");
                System.out.println("LISTO PARA JUGAR");
                System.out.println("////////////////");
            }
        }
    };
}
