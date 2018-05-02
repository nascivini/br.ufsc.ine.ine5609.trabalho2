package Hash;

/*
@author Vinicius Nascimento
@author Marco Aurélio Geremias
Data Structures, 2018-1. Profº De Lucca - Federal University of Santa Catarina, Brazil, UFSC
*/
public class Hash {

	private int [][] hash;
	private int scatteringAreaSize;

	public Hash(int scatteringAreaSize, int hashSize){
		this.hash = new int [hashSize][2];
		this.scatteringAreaSize = scatteringAreaSize;
		for(int i = 0; i < hashSize; i++){
			this.hash[i][1] = -1;
		}
		//set all the positions with an -1
	}

	public void insert(int newElement){
		int group = newElement % scatteringAreaSize;
		if(group == -1) {
			group = group + 1;
		}
		if(this.hash[group][1] == -1){
			this.hash[group][0] = newElement;
			this.hash[group][1] = group + scatteringAreaSize;
		}

		else{
			int control = group + scatteringAreaSize;
			while(control != -1){
				group = group + scatteringAreaSize;
				control = this.hash[group][1];
			}
			//find the next empty position

			this.hash[group][0] = newElement; 
			// insert the element

			if(group + scatteringAreaSize <= this.hash.length -1){
				this.hash[group][1] = group + scatteringAreaSize;
			}
			else{
				System.out.println("The structure is full for elements which end on " + newElement%scatteringAreaSize + ".");
			}
		}

	}

	public void delete (int element){
		if(this.search(element)) {
			//verify if the element is on the scattering area
			int group = element % scatteringAreaSize;
			if(this.hash[group][0] == element) {
				//verify if the element has next elements
				if(this.hasNext(group)) {
					for(int i = group; hasNext(i); i = i + scatteringAreaSize) {
						this.hash[group][0] = this.hash[this.hash[group][1]][0];
						this.hash[group][1] = group + scatteringAreaSize;
					}
					if(group > scatteringAreaSize) {
						this.hash[group - scatteringAreaSize][1] = -1;
					}
					else {
						this.hash[group][1] = -1;
					}
				}
				this.hash[group][0] = 0;
			}
			else {
				for(int i = group; hasNext(i); i = i + scatteringAreaSize) {
					if(this.hash[i][0] == element) {
						group = i;
					}
				}
				if(this.hasNext(group)) {
					for(int i = group; hasNext(i); i = i + scatteringAreaSize) {
						this.hash[group][0] = this.hash[this.hash[group][1]][0];
						this.hash[group][1] = group + scatteringAreaSize;
					}
					if(group > scatteringAreaSize) {
						this.hash[group - scatteringAreaSize][1] = -1;
					}
					else {
						this.hash[group][1] = -1;
					}
					}
				this.hash[group][0] = 0;
				this.hash[group][1] = -1;
			}		
		}
		else {
			System.out.println("Element " + element + " was not found.");
		}
	}


	public boolean search (int element){
		int group = element % scatteringAreaSize;

		for (int i = group; i < this.hash.length; i = i + this.scatteringAreaSize){
			if (this.hash[group][0] == element){
				return true;
			}
			else {
				group = group + scatteringAreaSize;
			}
		}
		return false;

	}

	public boolean hasNext(int position) {
		if(this.hash[position][1] != -1) {
			return true;
		}
		return false;
	}

	public void printHash() {

		for(int i = 0; i < this.hash.length; i ++) {
			System.out.println("Posição: " + i + ", Dado: " + this.hash[i][0] + ", Próxima Posição:  " + this.hash[i][1]);
		}
		System.out.println("------------------------------------------------------------------------");

	}


















}
