package Hash;

public class main {
	
	public static void main(String [] args) {
		
		Hash teste = new Hash(5, 15);
		try {
			teste.inserir(8);
			teste.inserir(5);
			teste.inserir(7);
			teste.inserir(10);
			teste.inserir(11);
			teste.inserir(6);
			teste.inserir(12);
			teste.printHash();
			teste.excluir(12);
			teste.printHash();
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
