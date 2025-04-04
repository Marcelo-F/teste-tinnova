public class exercicio4 {

    public static void main(String[] args) {

            int limite = 10; // Defina o limite até onde você quer somar
            int soma = 0;

            for (int i = 0; i < limite; i++) {
                if (i % 3 == 0 || i % 5 == 0) {
                    soma += i;
                }
            }

            System.out.println("A soma dos múltiplos de 3 e 5 abaixo de " + limite + " é: " + soma);

    }
}
