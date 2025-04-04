import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main2 {

    public static void main(String[] args) {


        List<Integer> arr = new ArrayList<>();
        Integer massaTeste[] = new Integer[]{-4 ,3 ,-9 ,0 ,4, 1};
        arr.addAll(Arrays.asList(massaTeste));
        Integer baseDivisao = arr.size();
        List<Integer> calculoDivisao = new ArrayList<>();


        if (baseDivisao >= 6) {

            getValorRepetidoNegativoEncontrado(arr, calculoDivisao);


            arr.removeIf(a -> a.intValue() < 0);


            int valorRepetidoEncontrado = getValorRepetidoPositivoEncontrado(arr);

            arr.removeIf(a -> a.intValue() > 0);

            calculoDivisao.add(valorRepetidoEncontrado);


        }


        if (arr.get(0).intValue() == 0) {

            int redundancia = (int) arr.stream().filter(a -> a.equals(0)).count();

            arr.removeIf(a -> a.equals(0));

            calculoDivisao.add(redundancia);

        }

        for (int pos = 0; arr.size() > pos; pos++) {

            int valorPosicaoQuePodeRepetir = arr.get(pos);
            int valorRepetidoEncontrado = 0;

            valorRepetidoEncontrado = (int) arr.stream().filter(a -> a.equals(valorPosicaoQuePodeRepetir)).count();

            arr.removeIf(a -> a.equals(valorPosicaoQuePodeRepetir));

            calculoDivisao.add(valorRepetidoEncontrado);
            pos--;


        }


        for (int y = 0; calculoDivisao.size() > y; y++) {
            ordenacaoLista(calculoDivisao);

            String resultFinal;
            double resultado = ((double) calculoDivisao.get(y)/ baseDivisao);


            DecimalFormat formatador = new DecimalFormat("0.000000");

            resultFinal = formatador.format(resultado).replaceAll(",", ".");
            System.out.println(resultFinal);


        }


    }

    private static void ordenacaoLista(List<Integer> calculoDivisao) {
        calculoDivisao.sort((s1, s2) -> {
            if (s1.intValue() > s2.intValue())
                return -1;
            if (s1.intValue() < s2.intValue())
                return 1;
            return 0;
        });
    }

    private static int getValorRepetidoPositivoEncontrado(List<Integer> arr) {
        int valorRepetidoEncontrado;


        valorRepetidoEncontrado = (int) arr.stream().filter(a -> a.intValue() > 0).count();
        return valorRepetidoEncontrado;
    }

    private static void getValorRepetidoNegativoEncontrado(List<Integer> arr, List<Integer> calculoDivisao) {
        int valorRepetidoEncontrado = 0;


        valorRepetidoEncontrado = (int) arr.stream().filter(a -> a.intValue() < 0).count();
        calculoDivisao.add(valorRepetidoEncontrado);
    }


}


