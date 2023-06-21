package dados;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import basico.*;
import execoes.*;

public class Repositorio implements Serializable {
			//IGeral;;
	ArrayList<Aluno> repositorio;
	
	int cont;
	int id;
	int verificar;
	int idCount;
    String nome;
    String cpf;
    String endereco;
	String disciplina;
    double notas;
	double soma = 0.0;

	public Repositorio() {
		this.repositorio = new ArrayList<Aluno>();
		idCount = 0;

	}
	public void adicionarAluno(Aluno item) {
        item.setID(idCount);
		this.repositorio.add(item);
		idCount++;
	}

	public int ultimoID() {
		if(idCount > 0){
			verificar = idCount;
		}else{
			System.out.println("\n\t\t\tLISTA VAZIA!\n\n");
		}
		return verificar;
	}
	
	public void editarAlunoNome(Aluno item, int n, String nome){
		for(IGeral id : repositorio){
			if(id.getID() == n){
                int posicao = this.repositorio.indexOf(item);
				item.setNome(nome);
				this.repositorio.set(posicao,item);
				break;
			}
		}

	}

	public void editarAlunoCpf(Aluno item, int n, String cpf){
		for(IGeral id : repositorio){
			if(id.getID() == n){
				item.setCpf(cpf);
				this.repositorio.add(item);
				break;
			}
		}
	}

	public void editarAlunoEndereco(Aluno item, int n, String endereco){
		for(IGeral id : repositorio){
			if(id.getID() == n){
				item.setEndereco(endereco);
				this.repositorio.add(item);
				break;
			}
		}
	}

	public void removerAluno(Aluno item, int n){
		for(IGeral id : repositorio){
			if (id.getID() != n){
				cont++;
			} else {
			    break;
            }
		}
		this.repositorio.remove(cont);
	}

	public Aluno recuperar(int id) throws CadastroNaoEncontradoException {
		for (IGeral idCoItem : repositorio){
			if (idCoItem.getID() == id)
				return (Aluno) idCoItem;
		}
		throw new CadastroNaoEncontradoException("\n\nID: " + "[" + id + "]" + ", NÃO ENCONTRADO!\n\n\n");
	}

	public void adicionarNota(Aluno item, int n, double nota){
		for(IGeral id : repositorio){
			if(id.getID() == n){
				item.setNota(nota);
				this.repositorio.add(item);
				break;
			}
		}
	}

	public void salvarRepositorio(String caminhoArquivo) throws IOException {
		FileOutputStream fout = new FileOutputStream(caminhoArquivo);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(this);
		oos.close();
	}

	public static Repositorio carregarRepositorio(String caminhoArquivo) throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream(caminhoArquivo);
		ObjectInputStream ois = new ObjectInputStream(fin);
		Repositorio resp = (Repositorio) ois.readObject();
		ois.close();
		return resp;
	}
}
