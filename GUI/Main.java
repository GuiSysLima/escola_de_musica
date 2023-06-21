package GUI;

import java.io.IOException;
import java.util.Scanner;

import basico.Aluno;
import basico.IGeral;
import basico.Professor;
import dados.Repositorio;
import dados.RepositorioProfessor;
import execoes.CadastroNaoEncontradoException;
import execoes.SalarioException;

public class Main {

	public static void main(String[] args) {
		
        String nome;
        String cpf;
        String endereco;
        int id = 0;
        double notas;
		boolean continuar = true;
		Scanner sc = new Scanner(System.in);
		

		Repositorio repositorio = null;
		String arquivoRepositorio = "./repositorioAluno.txt";

		RepositorioProfessor repositorioProfessor = null;
		String arquivoRepositorioProfessor = "./repositorioProfessor.txt";

		try {
			repositorio = Repositorio.carregarRepositorio(arquivoRepositorio);
		} catch (IOException e) {
			System.out.println("Não foi possível carregar o repositório.");
			repositorio = new Repositorio();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


		try {
			repositorioProfessor = RepositorioProfessor.carregarRepositorioProfessor(arquivoRepositorioProfessor);
		} catch (IOException e) {
			System.out.println("Não foi possível carregar o repositório.");
			repositorioProfessor = new RepositorioProfessor();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		while (continuar) {
            System.out.println("\n\t- - - - - Escola de Musica - - - - -\n\n");
            
			System.out.println("\n\t- - - - - Alunos - - - - -\n\n");
			System.out.println("\n1 - Cadastrar ALUNO");
			System.out.println("\n2 - Editar ''NOME'' ALUNO");
			System.out.println("\n3 - Editar ''CPF'' ALUNO");
			System.out.println("\n4 - Editar ''ENDERECO'' ALUNO");
			System.out.println("\n5 - Adicionar ''NOTA'' ALUNO");
			System.out.println("\n6 - Consultar ALUNO");
			System.out.println("\n7 - Remover ALUNO");
			System.out.println("\n8 - Mostrar Lista de ALUNOS");

			System.out.println("\n\n\t- - - - - Professores - - - - -\n\n");
            System.out.println("\n9 - Cadastrar PROFESSOR");
			System.out.println("\n10 - Editar ''NOME'' PROFESSOR");
			System.out.println("\n11 - Editar ''CPF'' PROFESSOR");
			System.out.println("\n12 - Editar ''ENDERECO'' PROFESSOR");
            System.out.println("\n13 - Consultar PROFESSOR");
			System.out.println("\n14 - Adicionar Salario PROFESSOR");
			System.out.println("\n15 - Adicionar Disciplinas PROFESSOR");
			System.out.println("\n16 - Remover PROFESSOR");
			System.out.println("\n17 - Mostrar Lista de PROFESSORES");

            System.out.println("\n\n\n0 - Sair."); 
			System.out.println("\nInforme uma opcao: ");
			int leitura = sc.nextInt();
			if (leitura == 1) {
				System.out.println("\n\n\n\n\t - - - - - CADASTRAR ALUNO - - - - -\n");
				sc.nextLine();
				System.out.println("\n\n\n\nDigite o Nome: ");
				nome = sc.nextLine();
                
                System.out.println("\nDigite o CPF: ");
				cpf = sc.next();
				sc.nextLine();
				
                System.out.println("\nDigite o Endereco: ");
				endereco = sc.nextLine();

				Aluno aluno = new Aluno(nome,cpf,endereco, id);
				System.out.println("\n\nAluno cadastrado!");
				repositorio.adicionarAluno(aluno);
				try {
					repositorio.salvarRepositorio(arquivoRepositorio);
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Não foi possível salvar o arquivo.");
				}

			}else if(leitura == 2){
				System.out.println("\n\n\n\n\t - - - - - EDITAR ''NOME''' ALUNO - - - - -\n");
				System.out.println("\n\n\n\nInforme o ID: ");
				id = sc.nextInt();
				try {
					Aluno resp = repositorio.recuperar(id);
					System.out.println("\n>>>Aluno encontrado!\n" + "\nInforme o novo ''NOME''': ");
					sc.nextLine();
					nome = sc.nextLine();
					repositorio.editarAlunoNome(resp, id, nome);
					System.out.println("\n>>>NOME do Aluno ID: " + "["+ id + "] foi alterado!");
					try {
						repositorio.salvarRepositorio(arquivoRepositorio);
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Não foi possível salvar a alteracao.");
					}
				} catch (CadastroNaoEncontradoException e) {
					System.out.println(e.getMessage());
				}
            }
			else if(leitura == 3){
				System.out.println("\n\n\n\n\t - - - - - EDITAR ''CPF''' ALUNO - - - - -\n");
				System.out.println("\n\n\n\nInforme o ID: ");
				id = sc.nextInt();
				try {
					Aluno resp = repositorio.recuperar(id);
					System.out.println("\n>>>Aluno encontrado!\n" + "\nInforme o novo ''CPF''': ");
					sc.nextLine();
					cpf = sc.nextLine();
					repositorio.editarAlunoCpf(resp, id, cpf);
					System.out.println("\n>>>CPF do Aluno ID: " + "["+ id + "] foi alterado!");
					try {
						repositorio.salvarRepositorio(arquivoRepositorio);
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Não foi possível salvar a alteracao.");
					}
				} catch (CadastroNaoEncontradoException e) {
					System.out.println(e.getMessage());
				}
            }
			else if(leitura == 4){
				System.out.println("\n\n\n\n\t - - - - - EDITAR ''ENDERECO''' ALUNO - - - - -\n");
				System.out.println("\n\n\n\nInforme o ID: ");
				id = sc.nextInt();
				try {
					Aluno resp = repositorio.recuperar(id);
					System.out.println("\n>>>Aluno encontrado!\n" + "\nInforme o novo ''ENDERECO''': ");
					sc.nextLine();
					endereco = sc.nextLine();
					repositorio.editarAlunoEndereco(resp, id, endereco);
					System.out.println("\n>>>ENDERECO do Aluno ID: " + "["+ id + "] foi alterado!");
					try {
						repositorio.salvarRepositorio(arquivoRepositorio);
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Não foi possível salvar a alteracao.");
					}
				} catch (CadastroNaoEncontradoException e) {
					System.out.println(e.getMessage());
				}
            }
			else if(leitura == 5){
				System.out.println("\n\n\n\n\t - - - - - ADICIONAR NOTA ALUNO - - - - -\n");
				System.out.println("\n\n\n\nInforme o ID: ");
				id = sc.nextInt();
				try {
					Aluno resp = repositorio.recuperar(id);
					System.out.println("\n>>>Aluno encontrado!\n" + "\nInforme a nota: ");
					notas = sc.nextDouble();
					repositorio.adicionarNota(resp, id, notas);
					System.out.println("\n>>>Nota adicionada ao Aluno ID: " + "["+ id + "]!");
					try {
						repositorio.salvarRepositorio(arquivoRepositorio);
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Não foi possível salvar a alteracao.");
					}
				} catch (CadastroNaoEncontradoException e) {
					System.out.println(e.getMessage());
				}
            }
			else if (leitura == 6) {
				System.out.println("\n\n\n\n\t - - - - - CONSULTAR ALUNO - - - - -\n");
				System.out.println("\n\n\n\nInforme o ID: ");
				id = sc.nextInt();
				Aluno resp = null;
				try {
					resp = repositorio.recuperar(id);
					System.out.println("\n>>>Aluno encontrado!\n" + resp);
				} catch (CadastroNaoEncontradoException e) {
					System.out.println(e.getMessage());
				}
			}
			else if (leitura == 9) {
				System.out.println("\n\n\n\n\t - - - - - CADASTRAR PROFESSOR - - - - -\n");
				sc.nextLine();
				System.out.println("\n\n\n\nDigite o Nome: ");
				nome = sc.nextLine();
                
                System.out.println("\nDigite o CPF: ");
				cpf = sc.next();
				sc.nextLine();
				
                System.out.println("\nDigite o Endereco: ");
				endereco = sc.nextLine();

				Professor professor = new Professor(nome,cpf,endereco,id);
				System.out.println("\n\nProfessor cadastrado!");
				repositorioProfessor.adicionarProfessor(professor);
				try {
					repositorioProfessor.salvarRepositorioProfessor(arquivoRepositorioProfessor);
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Não foi possível salvar o arquivo.");
				}
			}
			else if(leitura == 10){
				System.out.println("\n\n\n\n\t - - - - - EDITAR ''NOME''' PROFESSOR - - - - -\n");
				System.out.println("\n\n\n\nInforme o ID: ");
				id = sc.nextInt();
				try {
					Professor resp = repositorioProfessor.recuperarProfessor(id);
					System.out.println("\n>>>Professor encontrado!\n" + "\nInforme o novo ''NOME''': ");
					sc.nextLine();
					nome = sc.nextLine();
					repositorioProfessor.editarProfessorNome(resp, id, nome);
					System.out.println("\n>>>NOME do Professor ID: " + "["+ id + "] foi alterado!");
					try {
						repositorioProfessor.salvarRepositorioProfessor(arquivoRepositorioProfessor);
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Não foi possível salvar a alteracao.");
					}
				} catch (CadastroNaoEncontradoException e) {
					System.out.println(e.getMessage());
				}
            }
			else if(leitura == 11){
				System.out.println("\n\n\n\n\t - - - - - EDITAR ''CPF''' PROFESSOR - - - - -\n");
				System.out.println("\n\n\n\nInforme o ID: ");
				id = sc.nextInt();
				try {
					Professor resp = repositorioProfessor.recuperarProfessor(id);
					System.out.println("\n>>>Professor encontrado!\n" + "\nInforme o novo ''CPF''': ");
					sc.nextLine();
					cpf = sc.nextLine();
					repositorioProfessor.editarProfessorCpf(resp, id, cpf);
					System.out.println("\n>>>CPF do Professor ID: " + "["+ id + "] foi alterado!");
					try {
						repositorioProfessor.salvarRepositorioProfessor(arquivoRepositorioProfessor);
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Não foi possível salvar a alteracao.");
					}
				} catch (CadastroNaoEncontradoException e) {
					System.out.println(e.getMessage());
				}
            }
			else if(leitura == 12){
				System.out.println("\n\n\n\n\t - - - - - EDITAR ''ENDERECO''' PROFESSOR - - - - -\n");
				System.out.println("\n\n\n\nInforme o ID: ");
				id = sc.nextInt();
				try {
					Professor resp = repositorioProfessor.recuperarProfessor(id);
					System.out.println("\n>>>Professor encontrado!\n" + "\nInforme o novo ''ENDERECO''': ");
					sc.nextLine();
					endereco = sc.nextLine();
					repositorioProfessor.editarProfessorEndereco(resp, id, endereco);
					System.out.println("\n>>>ENDERECO do Professor ID: " + "["+ id + "] foi alterado!");
					try {
						repositorioProfessor.salvarRepositorioProfessor(arquivoRepositorioProfessor);
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Não foi possível salvar a alteracao.");
					}
				} catch (CadastroNaoEncontradoException e) {
					System.out.println(e.getMessage());
				}
            }
			else if (leitura == 13) {
				System.out.println("\n\n\n\n\t- - - - - CONSULTAR PROFESSOR - - - - -\n");
				System.out.println("\n\n\n\nInforme o ID: ");
				id = sc.nextInt();
				Professor respProfessor = null;
				try {
					respProfessor = repositorioProfessor.recuperarProfessor(id);
					System.out.println("\n>>>Professor encontrado!\n" + respProfessor);
				} catch (CadastroNaoEncontradoException e) {
					System.out.println(e.getMessage());
				}
			}
			else if (leitura == 8) {
				System.out.println("\n\n\n\n\t - - - - - ALUNOS NO REPOSITÓRIO - - - - -\n");
				for (int i = 0; i < repositorio.ultimoID(); i++) {
					try {
						IGeral a = repositorio.recuperar(i);
						System.out.println(a.toString());
					} catch (CadastroNaoEncontradoException e) {
						System.out.println("\nALUNO Nº: [" + i + "]" + " NÃO FOI ENCONTRADO!\n\n");
					}
				} 
			} 
			else if (leitura == 17) {
				System.out.println("\n\n\n\n\t - - - - - PROFESSORES NO REPOSITÓRIO - - - - -\n");
				for (int i = 0; i < repositorioProfessor.ultimoID(); i++) {
					try {
						IGeral a = repositorioProfessor.recuperarProfessor(i);
						System.out.println(a.toString());
					} catch (CadastroNaoEncontradoException e) {
						System.out.println("\nPROFESSOR Nº: [" + i + "]" + " NÃO FOI ENCONTRADO!\n\n");
					}
				}  
			}
			else if(leitura == 7){
				System.out.println("\n\n\n\n\t - - - - - REMOVER ALUNO - - - - -\n");
				System.out.println("\n\n\n\nInforme o ID: ");
				id = sc.nextInt();
				try {
					Aluno resp = repositorio.recuperar(id);
					System.out.println("\n>>>Aluno encontrado!\n");
					repositorio.removerAluno(resp, id);
					System.out.println("\n>>>Aluno ID: " + "["+ id + "] foi Removido!");
					try {
						repositorio.salvarRepositorio(arquivoRepositorio);
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Não foi possível salvar a alteracao.");
					}
				} catch (CadastroNaoEncontradoException e) {
					System.out.println(e.getMessage());
				}
            }
			else if(leitura == 14){
				System.out.println("\n\n\n\n\t - - - - - ADICIONAR SALARIO PROFESSOR - - - - -\n");
				System.out.println("\n\n\n\nInforme o ID: ");
				id = sc.nextInt();
				try {
					Professor resp = repositorioProfessor.recuperarProfessor(id);
					System.out.println("\n>>>Professor encontrado!\n" + "\nInforme o salario: ");
					double salario = sc.nextDouble();
					try {
						repositorioProfessor.adicionarSalario(resp, id, salario);
						System.out.println("\n>>>Salario do Professor: " + "["+ id + "]" + " foi atualizado!");
						try {
							repositorioProfessor.salvarRepositorioProfessor(arquivoRepositorioProfessor);
						} catch (IOException e) {
							e.printStackTrace();
							System.out.println("Não foi possível salvar a alteracao.");
						}
					} catch (SalarioException e) {
						System.out.println(e.getMessage());
					}
				} catch (CadastroNaoEncontradoException e) {
					System.out.println(e.getMessage());
				}
            }
			else if(leitura == 15){
				System.out.println("\n\n\n\n\t - - - - - ADICIONAR DISCIPLINA PROFESSOR - - - - -\n");
				System.out.println("\n\n\n\nInforme o ID: ");
				id = sc.nextInt();
				try {
					Professor resp = repositorioProfessor.recuperarProfessor(id);
					System.out.println("\n>>>Professor encontrado!\n" + "\nInforme a disciplina: ");
					sc.nextLine();
					String disciplina = sc.nextLine();
					repositorioProfessor.adicionarDisciplina(resp, id, disciplina);
					System.out.println("\n>>>Disciplina adicionada ao do Professor: " + "["+ id + "]!");
					try {
						repositorioProfessor.salvarRepositorioProfessor(arquivoRepositorioProfessor);
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Não foi possível salvar a alteracao.");
					}
				} catch (CadastroNaoEncontradoException e) {
					System.out.println(e.getMessage());
				}
            }
			else if(leitura == 16){
				System.out.println("\n\n\n\n\t - - - - - REMOVER PROFESSOR - - - - -\n");
				System.out.println("\n\n\n\nInforme o ID: ");
				id = sc.nextInt();
				try {
					Professor resp = repositorioProfessor.recuperarProfessor(id);
					System.out.println("\n>>>Professor encontrado!\n");
					repositorioProfessor.removerProfessor(resp, id);
					System.out.println("\n>>>Professor ID: " + "["+ id + "] foi Removido!");
					try {
						repositorioProfessor.salvarRepositorioProfessor(arquivoRepositorioProfessor);
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Não foi possível salvar a alteracao.");
					}
				} catch (CadastroNaoEncontradoException e) {
					System.out.println(e.getMessage());
				}
            }
			else if (leitura == 0) {
				System.out.println("\n\nEncerrando...");
				continuar = false;
			}
			

		}
	}

}
