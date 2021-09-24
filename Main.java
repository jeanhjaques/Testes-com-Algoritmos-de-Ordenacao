import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*; 
import java.util.Scanner;

public class Main
{
    public static void main (String[] args){
        Scanner ler = new Scanner(System.in);

        //recebe os parametros do usuário
        System.out.println("Entre com o valor de inc: ");
        int inc = ler.nextInt();
        System.out.println("Entre com o valor de max: ");
        int max = ler.nextInt();
        System.out.println("Entre com o valor de stp: ");
        int stp = ler.nextInt();
        System.out.println("Entre com o valor de rpt: ");
        int rpt = ler.nextInt();

        System.out.println("ATENCAO: Se os valores escolhidos forem muito grandes talvez a tabela demore alguns minutos para ser gerada.");
        System.out.println("Exibindo resultados para inc = "+inc+" max = "+max+" stp = "+stp+" rpt = "+rpt);

        Random gerador = new Random();

        //imprime a base da tabela
        System.out.println("    n    |   BubbleSort  |  InsertionSort  |   ShellSort ");
        System.out.println("-------------------------------------------------------------");

        for(int n = inc; n<=max; n = n+stp){
            //cria vetores para armazenar os tempos de execução
            long[] temposBubbleSort = new long[rpt];
            long[] temposInsertionSort = new long[rpt];
            long[] temposShellSort = new long[rpt];

            //Testa com o bubleSort
            for(int i = 0; i<rpt; i++){
                int[] vetor = new int[n]; //cria um vetor com tamanho n

                
                
                //Preenche o vetor com números inteiros aleatórios
                for(int j=0; j<vetor.length; j++){
                    vetor[j] = gerador.nextInt();
                }

                //Ordena utilizando Bubblesort
                long tempoInicial = System.nanoTime();
                int[] vetorOrdenado = Ordenacao.bubleSort(vetor);
                long tempoFinal = System.nanoTime();

                

                long tempo = tempoFinal - tempoInicial;
                temposBubbleSort[i] = tempo;

            }

            //Testa com o insertionSort
            for(int i = 0; i<rpt; i++){
                int[] vetor = new int[n]; //cria um vetor com tamanho n

                
                
                //Preenche o vetor com números inteiros aleatórios
                for(int j=0; j<vetor.length; j++){
                    vetor[j] = gerador.nextInt();
                }

                //Ordena utilizando Bubblesort
                long tempoInicial = System.nanoTime();
                int[] vetorOrdenado = Ordenacao.insertionSort(vetor);
                long tempoFinal = System.nanoTime();

                

                long tempo = tempoFinal - tempoInicial;
                temposInsertionSort[i] = tempo;

            }

            //Testa com o shellSort   
            for(int i = 0; i<rpt; i++){
                int[] vetor = new int[n]; //cria um vetor com tamanho n

                
                
                //Preenche o vetor com números inteiros aleatórios
                for(int j=0; j<vetor.length; j++){
                    vetor[j] = gerador.nextInt();
                }

                //Ordena utilizando Bubblesort
                long tempoInicial = System.nanoTime();
                int[] vetorOrdenado = Ordenacao.shellSort(vetor);
                long tempoFinal = System.nanoTime();

                

                long tempo = tempoFinal - tempoInicial;
                temposShellSort[i] = tempo;

            }

            String bubbleSortTempoMedio = String.format("%.6f",Calculos.calcularValorMedioVetor(temposBubbleSort)/1000000000);
            String insertionSortTempoMedio = String.format("%.6f",Calculos.calcularValorMedioVetor(temposInsertionSort)/1000000000);
            String shellSortTempoMedio = String.format("%.6f",Calculos.calcularValorMedioVetor(temposShellSort)/1000000000);

            //Imprime os tempos médios para n - os if's servem para tentar manter a tabela alinhada
            if(n<=9){
                System.out.println(n+"            "+bubbleSortTempoMedio+"         "+insertionSortTempoMedio+"         "+shellSortTempoMedio);
            }
            else if(n<=99){
                System.out.println(n+"           "+bubbleSortTempoMedio+"         "+insertionSortTempoMedio+"         "+shellSortTempoMedio);
            }
            else if(n<=999){
                System.out.println(n+"          "+bubbleSortTempoMedio+"         "+insertionSortTempoMedio+"         "+shellSortTempoMedio);
            }
            else if(n<=9999){
                System.out.println(n+"         "+bubbleSortTempoMedio+"         "+insertionSortTempoMedio+"         "+shellSortTempoMedio);
            }
            else if(n<=99999){
                System.out.println(n+"        "+bubbleSortTempoMedio+"         "+insertionSortTempoMedio+"         "+shellSortTempoMedio);
            }
            else if(n<=999999){
                System.out.println(n+"       "+bubbleSortTempoMedio+"         "+insertionSortTempoMedio+"         "+shellSortTempoMedio);
            }
            else if(n<=9999999){
                System.out.println(n+"      "+bubbleSortTempoMedio+"         "+insertionSortTempoMedio+"         "+shellSortTempoMedio);
            }
            else if(n<=99999999){
                System.out.println(n+"     "+bubbleSortTempoMedio+"         "+insertionSortTempoMedio+"         "+shellSortTempoMedio);
            }
            else if(n<=999999999){
                System.out.println(n+"    "+bubbleSortTempoMedio+"         "+insertionSortTempoMedio+"         "+shellSortTempoMedio);
            }

        }



        //System.out.println("    n     | BubbleSort | InsertionSort |  MergeSort |  QuickSort  |  RadixSort |  ShellSort");
        //System.out.println("-------------------------------------------------------------------------------------------");
        //System.out.println("999999999    0.003434      1.033033        1.001000     0.000300      0.002333     0.220022");
    }
}
