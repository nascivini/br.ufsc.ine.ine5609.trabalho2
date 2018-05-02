package Hash;

import java.util.Scanner;

public class main {

	public static void main(String [] args) {
		Scanner data = new Scanner(System.in);
		System.out.println("Bem vindo! Para criar um novo Hash, insira os dados solicitados e tecle Enter");
		System.out.println("Tamanho do Hash: ");
		int sizeHash = data.nextInt();
		System.out.println("Tamanho do Espalhamento: ");
		int sizeScattering = data.nextInt();
		System.out.println("Você criou um hash com tamanho " + sizeHash + " e espalhamento " + sizeScattering + ".");
		System.out.println("Serão executados 3 baterias de teste automatizado. Iniciando ...");
		System.out.println("");
		
		for(int i = 0; i < 3; i++) {
			Hash teste = new Hash(sizeScattering, sizeHash);
			System.out.println("Executando teste "+ i + " ...");
			teste.insert(8);
			teste.insert(5);
			teste.insert(7);
			teste.insert(10);
			teste.insert(11);
			teste.insert(6);
			teste.insert(12);
			teste.printHash();
			teste.delete(12);
			teste.delete(6);
			teste.delete(11);
			teste.delete(10);
			teste.delete(7);
			teste.delete(5);
			teste.delete(8);
			teste.printHash();
		}
	}
}
