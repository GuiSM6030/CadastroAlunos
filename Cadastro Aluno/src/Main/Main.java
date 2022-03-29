package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import Modelos.Aluno;

public class Main {
	public static void main(String[] args) {

		// Classe do leitor dos dados (Tipo o Scanner)
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Array
		List<Aluno> listaAlunos = new ArrayList<Aluno>();
		// Menu
		int menu = 0;
		while (menu < 5) {
			// Interface do menu
			System.out.println("Digite 1 para Cadastrar um Aluno");
			System.out.println("Digite 2 para Mostrar a Lista de Alunos");
			System.out.println("Digite 3 para Deletar a Lista de Alunos");
			System.out.println("Digite 4 para Editar a Lista de Alunos");
			System.out.println("Digite 5 para Sair");

			// "Tentativa" e Erro
			try {

				menu = Integer.parseInt(reader.readLine());

				// Administra os casos do menu
				switch (menu) {

				case 1:

					// Salvar um Aluno

					listaAlunos.add(CrudAluno.SalvarAluno(reader));

					break;

				case 2:

					System.out.println();
					System.out.println();

//					for (Aluno a : listaAlunos)
//					System.out.println(a);

					CrudAluno.ListarAlunosSalvos(0);
//					String line = "Guilherme,Silva";
//					Aluno fabio = new Aluno(line);

					System.out.println();
					System.out.println();

					break;

				case 3:

					System.out.println();
					System.out.println();

					CrudAluno.DeletarAlunosSalvos(reader);

					System.out.println();
					System.out.println();

					break;
					
				case 4:

					System.out.println();
					System.out.println();

					CrudAluno.EditarAlunosSalvos(reader);

					System.out.println();
					System.out.println();

					break;
					
				case 5:

					System.out.println("Fim!");

					break;

				}

			}

			// Tentativa e "Erro"
			catch (NumberFormatException e1) {
				e1.printStackTrace();

			}

			// Tentativa e "Erro"
			catch (IOException e1) {
				e1.printStackTrace();
			}

		}

	}

}
