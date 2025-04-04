
public class Exercicio1 {

    public double calcularVotosValidos(int votos, int totalEleitores){
        verificaSeTotalEleitoresEValidos(totalEleitores);
        return (double) votos / totalEleitores * 100;
    }

    public double calcularVotosBrancos(int votosBrancos, int totalEleitores){
        verificaSeTotalEleitoresEValidos(totalEleitores);
        return (double) votosBrancos / totalEleitores * 100;
    }

    public double calcularVotosNulos(int votosNulos, int totalEleitores){
        verificaSeTotalEleitoresEValidos(totalEleitores);
        return (double) votosNulos / totalEleitores * 100;
    }


    private static void verificaSeTotalEleitoresEValidos(int totalEleitores){
        if (totalEleitores <= 0) {
            throw new IllegalArgumentException("O total de eleitores não pode ser zero.");
        }
    }

}
