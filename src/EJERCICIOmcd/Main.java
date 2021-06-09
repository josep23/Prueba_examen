package EJERCICIOmcd;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int NumeroA;
        int NumeroB;
        Boolean Bucle = true;
        while (Bucle !=false){
            System.out.println("Quieres salir?");
            System.out.println("0-SI 1-NO");
            n = sc.nextInt();
            if (n==1){
                System.out.println("dime 2 numeros");
                NumeroA=sc.nextInt();
                NumeroB=sc.nextInt();

                //CREAMOS LA PISCINA
                ForkJoinPool executor = new ForkJoinPool();
                //CREAMOS UNA INSTANCIA A LA CLASE ITERATIVOYRECURSIVO QUE ES DONDE SE EJECUTA LOS PARAMETROS PARA HACER LO DE EL MCD
                 IterativoYRecursivo iterativoYRecursivo = new IterativoYRecursivo(NumeroA,NumeroB);
                 //EJECUTAMOS LA CLASE
                executor.execute(iterativoYRecursivo);
                //LE DECIMOS QUE LA R QUE SIGNIFICA RESPUESTA SEA IGUAL AL JOIN QUE NOS HAN PASADO ES DECIR LA RESPUESTA DEL FORK
                int r = iterativoYRecursivo.join();
                //IMPRIMIMOS EL R ES DECIR EL JOIN
                System.out.println(r);

            }else if (n==0){
                //ROMPE EL BUCLE
                Bucle=false;
            }else {
                System.out.println("Esa opcion no existe");
            }
        }
    }
}

