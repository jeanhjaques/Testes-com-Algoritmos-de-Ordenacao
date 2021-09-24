public class Calculos{
	public static double calcularValorMedioVetor(long[] vetor){
		long soma = 0;
		for(int i = 0; i<vetor.length;i++){
			soma = soma + vetor[i];
		}
		double media = (double)soma/vetor.length;
		return media;
	}
}