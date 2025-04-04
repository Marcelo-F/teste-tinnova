public class Exercicio3 {

    public static void main(String[] args) {
        int  valorFatorial = 5;
        int pos =0;
        int resultado=0;
        while(pos<valorFatorial){

            if(pos==0){
                resultado = 1;
            }else if (pos ==1) {

                resultado =  valorFatorial*pos;
            }else {
                resultado = resultado*pos;
            }

            System.out.println("Valor calculo : " + resultado);
            pos++;
        }

        System.out.println("Valor final do fatorial: " + resultado);

    }
}
