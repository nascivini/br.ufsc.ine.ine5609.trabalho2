package Hash;

//@author Vinicius Nascimento
//@author Marco Aurélio Geremias
//Estruturas de Dados, 2018-1. De Lucca - Universidade Federal de Santa Catarina, UFSC

public class Hash {

	private int [][] hash;
	private int tamanhoEspalhamento;

	public Hash(int tamanhoEspalhamento, int tamanhoHash){
		this.hash = new int [tamanhoHash][2];
		this.tamanhoEspalhamento = tamanhoEspalhamento;
		for(int i = 0; i < tamanhoHash; i++){
			this.hash[i][1] = -1;
		}
		//seta os próximos do hash como "-1";
	}

	public void inserir(int novoElemento){
		int grupo = novoElemento % tamanhoEspalhamento;
		if(grupo == -1) {
			grupo = grupo + 1;
		}
		if(this.hash[grupo][1] == -1){
			this.hash[grupo][0] = novoElemento;
			this.hash[grupo][1] = grupo + tamanhoEspalhamento;
		}

		else{
			int controle = grupo + tamanhoEspalhamento;
				while(controle != -1){
					grupo = grupo + tamanhoEspalhamento;
					controle = this.hash[grupo][1];
				}
				//busca a próxima posição do grupo vazia

				this.hash[grupo][0] = novoElemento; 
				// realiza a inserção
				
				if(grupo + tamanhoEspalhamento <= this.hash.length -1){
					this.hash[grupo][1] = grupo + tamanhoEspalhamento;
				}
				else{
					System.out.println("O hash está cheio para elementos com final " + novoElemento%tamanhoEspalhamento + ".");
				}
		}

	}

	public void excluir (int elemento) throws Exception{
      if (this.buscar(elemento)){
      	int controle;
      	for(int i = elemento % tamanhoEspalhamento; i > 0; i = i - tamanhoEspalhamento){
      		if (this.hash[i][0] == elemento){
      			if (this.hash [i][1] != -1){
      				controle = this.hash[i][1];
      				for (int j = controle; j < this.hash.length; j = j + tamanhoEspalhamento){
      					this.hash[j][0] = this.hash[controle][0];
      					if(this.hash[j][1] != -1){
							this.hash[j][1] = controle;
							controle = this.hash[j][1];
						}
      				}
      			}
      		}
      	}
      	throw new Exception("Elemento não encontrado! Por gentileza, inseri-lo antes da exclusão.");
   	  }
       
    }
	

	public boolean buscar (int elemento){
       int grupo = elemento % tamanhoEspalhamento;
       
       for (int i = grupo; i < this.hash.length; i = i + this.tamanhoEspalhamento){
       	if (this.hash[grupo][0] == elemento){
       		return true;
       	}
       	else {
       		grupo = grupo + tamanhoEspalhamento;
       	}
       }
       return false;
       
	}
	
	public void printHash() {
		
		for(int i = 0; i < this.hash.length; i ++) {
		System.out.println("[ " + this.hash[i][0] + " ] "+ "[ " + this.hash[i][1] + " ]");
		}
		
	}


















}
    