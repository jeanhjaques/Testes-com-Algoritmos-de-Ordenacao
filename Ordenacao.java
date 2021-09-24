import java.util.*;

public class Ordenacao {

    //BubleSort - Ordenacao em bolha
    public static int[] bubleSort(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }
        }
        return vetor;
    }

    //InsertionSort - Ordenacao por inserção 
    public static int[] insertionSort(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int aux = vetor[i];
            int j = i;
            while ((j > 0) && (vetor[j - 1] > aux)) {
                vetor[j] = vetor[j - 1];
                j -= 1;
            }
            vetor[j] = aux;
        }
        return vetor;
    }

    //ShellSort - Ordenacao por incrementos diminutos
    public static int[] shellSort(int[] vetor) {
        int incremento = 1;
        while (incremento < vetor.length) {
            incremento = 3 * incremento + 1;
        }

        while (incremento > 1) {
            incremento /= 3;

            for (int i = incremento; i < vetor.length; i++) {
                int aux = vetor[i];
                int j = i - incremento;
                while (j >= 0 && aux < vetor[j]) {
                    vetor[j + incremento] = vetor[j];
                    j -= incremento;
                }
                vetor[j + incremento] = aux;
            }
        }
        return vetor;
    }


    // Função do Heapsort
    // Essa função provoca o desequilibrio do Max-Heap.
    // Ela faz com que o maior valor, que está no topo, seja trocado pelo último valor do Max-Heap.
    // Após a troca, diminui o valor de 'tam' para que o valor mais alto permaneça na última posição.
    // Então é chamada a função maxHeapifica para o novo valor que está no topo.

    private static int tam;
    private static int[] vetor;

    public static int[] heapSort(int[] array) {
        vetor = array;          // vetor global recebe o vetor passado como parâmetro
        tam = vetor.length - 1;     // o tamanho deste vetor é armazenado em 'tam', que também é global

        // Chama a função para construir um Max-Heap
        constroiHeap();

        // Assim que a Max-Heap foi criada, o processo de ordenação pode começar.
        // Através desse loop que a troca do valor do topo com o valor da última posição da Heap é feita
        for (int i = tam; i > 0; i--) {
            troca(0, tam);      // Troca a posição
            tam -= 1;           // Diminui 'tam' para não alterar a posição do maior valor nas próximas iterações
            maxHeapifica(0);    // Como existe um valor menor no topo, é necessário heapificar novamente a árvore inteira
        }
        return vetor;
    }

    // Função que constrói o Max-Heap
    private static void constroiHeap() {
        // Como o último nível da árvore não tem filhos, a construção se inicia no último elemento da penúltima.
        // Esse elemento se encontra bem no meio do vetor, ou seja, tam/2:
        int meio = (int) (tam / 2);

        // Para cada elemento do penúltimo nível, chama o maxHeapifica, ou seja
        // encontra o maior elemento e coloca como pai
        for (int i = meio - 1; i >= 0; i--) {
            maxHeapifica(i);
        }
    }

    // Função de troca
    // É uma função simples de swap, para auxiliar na troca de posição dos valores
    private static void troca(int i, int j) {
        int aux;

        aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
    }

    // Função maxHeapifica
    // Essa função é o core do algoritmo.
    // Ela faz a comparação entre os valores de um Heap e ao encontrar o maior, o coloca como pai da Heap.
    // Isso faz com que qualquer Heap se torne um Max-Heap.
    private static void maxHeapifica(int pai) {
        int maior = pai,            // O maior elemento é o pai, até que se prove o contrário.
                esquerda = 2 * pai + 1,     // Pega a posição do filho da esquerda
                direita = 2 * pai + 2;  // e a do filho da direita.

        // Se o filho da esquerda existe, ou seja, se ele está dentro do intervalo verificável do array E
        // Se este filho é maior que o pai (que no momento é o 'maior')
        if (esquerda <= tam && vetor[esquerda] > vetor[maior])
            maior = esquerda;

        // Se o filho da direita existe, ou seja, se ele está dentro do intervalo verificável do array E
        // Se este filho é maior que o 'maior' (que no momento pode ser o 'pai' ou o 'esquerda')
        if (direita <= tam && vetor[direita] > vetor[maior])
            maior = direita;

        // Se ao chegar até aqui o 'pai' deixou de ser o 'maior' valor
        if (maior != pai) {
            troca(pai, maior);      // Faz a troca de posições
            maxHeapifica(maior);    // Continua heapificando com o valor que foi trocado
        }
    }

    //radixSort
    public static int[] bucketSort(int[] arr) {
        int i, j;
        int[] bucket = new int[arr.length*5];
        Arrays.fill(bucket, 0);

        for (i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        int k=0;
        for (i = 0; i < bucket.length; i++) {
            for (j = 0; j<bucket[i]; j++) {
                arr[k++] = i;
            }
        }
        return arr;
    }

    //quickSort
    public static int[] quickSort(int[] numbers) {
        Stack stack = new Stack();
        stack.push(0);
        stack.push(numbers.length);
        while (!stack.isEmpty()) {
            int end = (int) stack.pop();
            int start = (int) stack.pop();
            if (end - start < 2) {
                continue;
            }
            int p = start + ((end - start) / 2);
            p = partition(numbers, p, start, end);
            stack.push(p + 1);
            stack.push(end);
            stack.push(start);
            stack.push(p);
        }
        return numbers;
    }

    private static int partition(int[] input, int position, int start, int end) {
        int l = start;
        int h = end - 2;
        int piv = input[position];
        swap(input, position, end - 1);
        while (l < h) {
            if (input[l] < piv) {
                l++;
            } else if (input[h] >= piv) {
                h--;
            } else {
                swap(input, l, h);
            }
        }
        int idx = h;
        if (input[h] < piv) {
            idx++;
        }
        swap(input, end - 1, idx);
        return idx;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
