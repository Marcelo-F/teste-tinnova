import java.util.Arrays;

public class exercicio2 {

    public static void main(String[] args) {

        int[] v = {5,3,2,4,7,1,0,6};

        boolean swapped;

            for (int i = 0; i < v.length - 1; i++) {
                swapped = false;
                for (int j = 0; j < v.length - i - 1; j++) {
                    if (v[j] > v[j + 1]) {
                        // Troca arr[j] e arr[j+1]
                        int temp = v[j];
                        v[j] = v[j + 1];
                        v[j + 1] = temp;
                        swapped = true;
                    }
                }
                // Se não houve troca, a lista já está ordenada
                if (!swapped) {
                    break;
                }
            }

        for (int pos=0;  pos< v.length; pos++){
            System.out.println("Lista organizada com metodo bubble sort: " +v[pos]);

        }
    }
}
