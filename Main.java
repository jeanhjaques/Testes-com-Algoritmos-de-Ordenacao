import java.util.Arrays;
import java.util.Random;

public class Main
{
    public static void main (String[] args){
        //Cria um vetor que será ordenado
        int[] vetor = new int[50];
        
        Random gerador = new Random();
        
        //Preenche o vetor com números inteiros aleatórios dentro de 0 ao tamanho do vetor
        for(int i=0; i<vetor.length; i++){
            vetor[i] = gerador.nextInt(vetor.length);
        }
        
        //Imprime o vetor antes da ordenação
        System.out.println(Arrays.toString(vetor));
        
        //Ordena utilizando Bubblesort
        int[] vetorOrdenado = Ordenacao.bublesort(vetor);

        //Imprime o vetor após a ordenação
        System.out.println(Arrays.toString(vetorOrdenado));
    }
}
