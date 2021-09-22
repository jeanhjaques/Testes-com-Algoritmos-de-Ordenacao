import java.util.Arrays;
import java.util.Random;

public class Main
{
    public static void main (String[] args){

        //Cria um vetor que será ordenado
        int[] vetor = new int[1000];
        
        Random gerador = new Random();
        
        //Preenche o vetor com números inteiros aleatórios dentro de 0 ao tamanho do vetor
        for(int i=0; i<vetor.length; i++){
            vetor[i] = gerador.nextInt();
        }
        
        //Imprime o vetor antes da ordenação
        System.out.println(Arrays.toString(vetor));
        
        //Ordena utilizando Bubblesort
        long tempoInicial = System.nanoTime(); 
        int[] vetorOrdenado = Ordenacao.bubleSort(vetor);
        long tempoFinal = System.nanoTime();


        //Imprime o vetor após a ordenação
        System.out.println(Arrays.toString(vetorOrdenado));

        double tempo = (double)(tempoFinal - tempoInicial)/1000000000;
        String tempoFormatado = String.format("%.6f", tempo);

        System.out.println(resultado);
    }
}
