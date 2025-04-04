import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        int totalEleitores = 1000;
        int votosValidos = 800;
        int votosBrancos  = 150;
        int votosNulos = 50;

        Exercicio1 exercicio1 = new Exercicio1();
        double result  =  exercicio1.calcularVotosValidos(votosValidos, totalEleitores);
        double resultVotosBrancos  =  exercicio1.calcularVotosBrancos(votosBrancos, totalEleitores);
        double resultVotosNulos  =  exercicio1.calcularVotosNulos(votosNulos, totalEleitores);


       System.out.println("Resultado da proporção dos votos validos: "+result);
       System.out.println("Resultado da proporção dos votos validos: "+resultVotosBrancos);
       System.out.println("Resultado da proporção dos votos validos: "+resultVotosNulos);







    }

}




