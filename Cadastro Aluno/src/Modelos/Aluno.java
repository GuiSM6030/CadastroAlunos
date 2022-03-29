package Modelos;

public class Aluno {

	private String nome;
	private int cpf;
	private String curso;
	private Endereco end;
	
	//Getter's e Setter's das variáveis --->
	
	
	public Aluno(String dados) {
		//Array de String usa o Split para separar as informações com o auxílio da ","
		
//		System.out.println(dados);
		
		String[] atributos = dados.split(",");
		
		String[] nome = atributos[1].split("=");
		String[] cpf = atributos[2].split("=");
		String[] curso = atributos[3].split("=");
		
		Endereco enderecoFabio = new Endereco(atributos);
		
		this.nome = nome[1].trim();
		this.cpf = Integer.parseInt(cpf[1].trim());
		this.curso = curso[1].trim();
		this.end = enderecoFabio;
		
//		for(int x=0; x < atributos.length; x++)
//			System.out.println(atributos[x]);

	}
	
	public Aluno() {
		
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	

	public Endereco getEnd() {
		return end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}
	
	
	//<---Getter's e Setter's das variáveis

	//Estrutura para mostrar os dados do Aluno
	@Override
	public String toString() {
		return "Aluno, Nome = " + nome + ", CPF = " + cpf + ", Curso = " + curso + ", " + end;
	

	

	}
	
	
}
