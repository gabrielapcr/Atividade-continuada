package Telas.gui;

import java.util.Scanner;

public class CalcularMedias {
	public  static void main(String[] args) {

		double num;
		double soma = 0;
		int cont = 0;
		double mult = 0;

		Scanner in = new Scanner(System.in);

		while ((num = in.nextInt()) >= 0) {
		    soma += num;
		    mult *= num;
		    cont++;
		}

		in.close();

		double mediaAritmetica = soma/cont;
		System.out.println("\nA média aritmética dos numeros é : "+ mediaAritmetica);
		
		double mediaGeometrica = cont/(1/soma);
		System.out.println("\nA média geométrica dos numeros é : "+ mediaGeometrica);
		
		double mediaHarmonica = Math.exp((Math.log(mult/cont)));
		System.out.println("\nA média harmônica dos numeros é : "+ mediaHarmonica);

	}
}
