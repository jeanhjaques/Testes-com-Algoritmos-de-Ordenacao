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
  
}
