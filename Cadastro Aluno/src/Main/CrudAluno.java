package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Modelos.Aluno;
import Modelos.Endereco;

public class CrudAluno {

	// Metodo
	public static Aluno SalvarAluno(BufferedReader reader) {

		// Contrutores
		Aluno fabio = new Aluno();
		Endereco enderecoFabio = new Endereco();

		// "Tentativa" e Erro
		try {
			// Coleta os dados do Aluno
			System.out.println("Digite o nome do Aluno:");

			fabio.setNome(reader.readLine());

			System.out.println("Digite o CPF do Aluno:");
			fabio.setCpf(Integer.parseInt(reader.readLine()));
			;

			System.out.println("Digite o curso do Aluno:");
			fabio.setCurso(reader.readLine());

			System.out.println();
			System.out.println("Digite o Endereço do aluno");
			System.out.println("Rua:");
			enderecoFabio.setRua(reader.readLine());

			System.out.println("Número:");
			enderecoFabio.setNum(Integer.parseInt(reader.readLine()));

			System.out.println("Bairro:");
			enderecoFabio.setBairro(reader.readLine());

			System.out.println("Cidade:");
			enderecoFabio.setCidade(reader.readLine());

			System.out.println("Estado:");
			enderecoFabio.setEstado(reader.readLine());

			System.out.println("CEP:");
			enderecoFabio.setCep(Integer.parseInt(reader.readLine()));

			fabio.setEnd(enderecoFabio);

			try (BufferedWriter buffer = new BufferedWriter(new FileWriter("CadastroAluno.txt", true));
					PrintWriter pw = new PrintWriter(buffer)) {
				pw.println(fabio);
			}

			System.out.println("______________________________________");
			System.out.println();
			System.out.println("Cadastro Realizado!!!");
			System.out.println();
			System.out.println();

			// Tentativa e "Erro"
		} catch (

				Exception e) {
			e.printStackTrace();
		}

		return fabio;

	}

	public static List<Aluno> ListarAlunosSalvos(int op) {

		List<Aluno> listaDeALunos = new ArrayList<Aluno>();
		String line = "";

		try (BufferedReader reader = new BufferedReader(new FileReader("CadastroAluno.txt"))) {

			while((line = reader.readLine())!= null) {

				Aluno fabio = new Aluno(line);
				listaDeALunos.add(fabio);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (op == 0)
			for(Aluno a: listaDeALunos)
				System.out.println(a);
		return listaDeALunos;
	}

	public static void DeletarAlunosSalvos(BufferedReader reader) throws NumberFormatException, IOException {

		List<Aluno> listaDeALunos = ListarAlunosSalvos(1);

		for (int i = 0; i < listaDeALunos.size();i++)
			System.out.println(i + "-" + listaDeALunos.get(i));
		System.out.println();
		System.out.println("Escolha o indice que deseja deletar: ");

		int indice = Integer.parseInt(reader.readLine());

		listaDeALunos.remove(indice);

		System.out.println("Aluno Deletado!");

		try (BufferedWriter buffer = new BufferedWriter(new FileWriter("CadastroAluno.txt"))) {
			PrintWriter pw = new PrintWriter(buffer);
			for (Aluno aluno : listaDeALunos)
				pw.println(aluno);
		}
	}

	public static void EditarAlunosSalvos(BufferedReader reader) throws NumberFormatException, IOException {
		List<Aluno> listaDeALunos = ListarAlunosSalvos(1);

		for (int i = 0; i < listaDeALunos.size(); i++)
			System.out.println(i + "-" + listaDeALunos.get(i));
		System.out.println();

		int indice = Integer.parseInt(reader.readLine());

		Aluno fabio = listaDeALunos.get(indice);
		Endereco enderecoFabio = fabio.getEnd();

		System.out.println("Escolha o tributo que deseja editar: ");
		System.out.println("1 - Nome \n"
				+ "2 - CPF \n"
				+ "3 - Curso \n"
				+ "4 - Rua \n"
				+ "5 - Número \n"
				+ "6 - Bairro \n"
				+ "7 - Cidade \n"
				+ "8 - Estado \n"
				+ "9 - CEP \n"
				+ "10 - Cancelar ");

		int alt = Integer.parseInt(reader.readLine());
		System.out.println("Escreva o novo atributo: ");
		String edit = reader.readLine();

		switch(alt) {

		case 1:
			fabio.setNome(edit);
			break;

		case 2:
			fabio.setCpf(Integer.parseInt(edit));
			break;

		case 3:
			fabio.setCurso(edit);
			break;

		case 4:
			fabio.getEnd().setRua(edit);
			break;

		case 5:
			fabio.getEnd().setNum(Integer.parseInt(edit));
			break;

		case 6:
			fabio.getEnd().setBairro(edit);
			break;

		case 7:
			fabio.getEnd().setCidade(edit);
			break;

		case 8:
			fabio.getEnd().setEstado(edit);
			break;

		case 9:
			fabio.getEnd().setCep(Integer.parseInt(edit));
			break;

		case 10:
			System.out.println("Voltando ao menu.......");
			break;

		}

		listaDeALunos.set(indice, fabio);

		System.out.println();
		System.out.println("Cadastro Alterado!");
		System.out.println();

		try (BufferedWriter buffer = new BufferedWriter(new FileWriter("CadastroAluno.txt"))) {
			PrintWriter pw = new PrintWriter(buffer);
			for (Aluno aluno : listaDeALunos)
				pw.println(aluno);
		}
	}
}
