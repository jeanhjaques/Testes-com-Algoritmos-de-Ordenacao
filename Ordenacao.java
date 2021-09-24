public class Ordenacao{
    
    //BubleSort - Ordenacao em bolha
    public static int[] bubleSort(int[] vetor){
        for(int i = 0; i<vetor.length; i++){
            for(int j = 0; j<vetor.length-1; j++){
                if(vetor[j] > vetor[j + 1]){
                    int aux = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = aux;
                }
            }
        }
        return vetor;
    }
  
    //InsertionSort - Ordenacao por inserção 
    public static int[] insertionSort(int[] vetor){
		for (int i = 1; i < vetor.length; i++){
			int aux = vetor[i];
			int j = i;
			while ((j > 0) && (vetor[j-1] > aux)){
				vetor[j] = vetor[j-1];
				j -= 1;
			}
			vetor[j] = aux;
		}
		return vetor;
	}
	
	//QuickSort - Ordenação
	private int dividir(int[] vetor, int inicio, int fim) {
    	int pivo, pontEsq, pontDir = fim;
	pontEsq = inicio + 1;
	pivo = vetor[inicio];
		
	 while(pontEsq <= pontDir) {
	 	while(pontEsq <= pontDir && vetor[pontEsq] <= pivo) {
		pontEsq++;
	 }
	 while(pontDir >= pontEsq && vetor[pontDir] > pivo) {
		pontDir--;
	 }
	 if(pontEsq < pontDir) {
	 	trocar(vetor, pontDir, pontEsq);
		pontEsq++;
		pontDir--;
	      }
	 }
	    trocar(vetor, inicio, pontDir);
	    return pontDir;
	  }

	//ShellSort - Ordenacao por incrementos diminutos
	public static int[] shellSort(int[] vetor){
	    int incremento = 1;
	    while(incremento < vetor.length){
	        incremento = 3 * incremento + 1;
	    }
	     
	    while (incremento > 1) {
	        incremento /= 3;
	        
	        for(int i = incremento; i < vetor.length; i++) {
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

	public static int[] radixSort(int vector[]){
		for(int digit = 0; digit < 3; digit ++){
			int power = (int) Math.pow(10, digit+1);
			
			int z[][] = new int[vector.length][10];
			int n[] = new int[10];

			for(int i = 0; i < vector.length; i ++){
				int num = vector[i];
				z[n[(num%power)/(power/10)]][(num%power)/(power/10)] = num;
				n[(num%power)/(power/10)]++;
				
			}
			int c = 0;
			for(int i = 0; i < 10; i ++){
				
				for(int j = 0; j < vector.length; j ++){
					if(j < n[i]){
						vector[c] = z[j][i];
						c++;
					}else{break;}
				}
			}
		}
		return vector;
	}
  
}
