package EJERCICIOmcd;

import java.util.concurrent.RecursiveTask;

public class IterativoYRecursivo extends RecursiveTask<Integer> {
    private int max=20;
    private int A;
    private int B;
    //UN CONSTRUCTOR PARA PASAR LAS VARIABLES DE LOS NUMEROS
    public IterativoYRecursivo(int NumeroA, int NumeroB){
        A=NumeroA;
        B=NumeroB;

    }
    //EL CODIGO DE ITERATIVO QUE ES SENCILLO
    public int Iteractivo(int A, int B){
        int numero = 0;
        while (B !=0){
            numero = B;
            B = A%B;
            A = numero;
        }
        return numero;
    }
    //EL CODIGO DEL RECURSIVO QUE ES MAS COMPLICADO
    //NECESITAMOS PASARLE LOS NUMEROA Y NUMEROB
    public int Recursivo(int NumeroA, int NumeroB){
        if (NumeroB==0){
            return NumeroA;
        }else{
            //INSTANCIAMOS LA CLASE ITERATIVOYRECURSIVO Y QUE EJECUTE EL PROGRAMA QUE TENGA EL NUMEROB Y NUMEROA%NUMEROB
            IterativoYRecursivo iterativoYRecursivo = new IterativoYRecursivo(NumeroB,NumeroA%NumeroB);
            //Y LO GUARDE EN UN FORK QUE ES UNA COLA QUE HACE QUE SE EJECUTE CUANDO PUEDA
            iterativoYRecursivo.fork();
            //UNA VEZ HECHO LA RESPUESTA LA MANDE CON UN JOIN
            return iterativoYRecursivo.join();
        }
    }

    //ES LA VARIABLE QUE SE EJECUTA Y COMPARA QUE USAR SI ITERACTIVO O RECURSIVO
    @Override
    protected Integer compute() {
        if (A < max){
            return Iteractivo(A,B);
        }else {
            return Recursivo(A,B);
        }
    }
}
