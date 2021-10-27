package Model;

public class Model_Alberi {
	
	private Model_Alberi left;
    private Model_Alberi right;
	private String nome;

	
	public Model_Alberi(String nome){
		this.nome = nome;
		left = null;
		right = null;
	}
	
	public Model_Alberi(String nome, Model_Alberi left, Model_Alberi right) {
		this.nome = nome;
		this.left = left;
		this. right = right;
	}

	public String getNome() {
		return nome;
	}

	public Model_Alberi getLeft() {
		return left;
	}

	public void setLeft(Model_Alberi left) {
		this.left = left;
	}

	public Model_Alberi getRight() {
		return right;
	}

	public void setRight(Model_Alberi right) {
		this.right = right;
	}
	
	
	//INSERIMENTO
	public class Inserimento{
		Model_Alberi root;
		
		public Inserimento() {
			root = null;
		}
		
		public void addValue(String nome) {
			root = insert(root, nome); 
		}
		
		private Model_Alberi insert(Model_Alberi actual, String nome){
			if (actual == null) {
				return new Model_Alberi(nome);
			}else{
				if (actual.getNome().equals(nome)) {
					return actual;
				}else {
					if (actual.getNome().compareTo(nome)>0) {
						actual.setLeft(insert(actual.getLeft(), nome));
					}else {
						actual.setRight(insert(actual.getRight(), nome));
					}
				}
			}
			return actual;
		}
	}
	
	
	
}
