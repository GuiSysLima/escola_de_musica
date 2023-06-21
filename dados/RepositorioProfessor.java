package dados;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import basico.Professor;
import basico.IGeral;
import execoes.*;

public class RepositorioProfessor implements Serializable{
    ArrayList<Professor> repositorioProf;
    
    int verificar;
	int idCount;
	int cont;
    String nome;
    String cpf;
    String endereco;
	String disciplina;
    
    public RepositorioProfessor() {
		this.repositorioProf = new ArrayList<Professor>();
		idCount = 0;

	}

    public void adicionarProfessor(Professor itemProf) {
		itemProf.setID(idCount);
		this.repositorioProf.add(itemProf);
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

	public void editarProfessorNome(Professor item, int n, String nome){
		for(IGeral id : repositorioProf){
			if(id.getID() == n){
				item.setNome(nome);
				this.repositorioProf.add(item);
				break;
			}
		}
	}

	public void editarProfessorCpf(Professor item, int n, String cpf){
		for(IGeral id : repositorioProf){
			if(id.getID() == n){
				item.setCpf(cpf);
				this.repositorioProf.add(item);
				break;
			}
		}
	}

	public void editarProfessorEndereco(Professor item, int n, String endereco){
		for(IGeral id : repositorioProf){
			if(id.getID() == n){
				item.setEndereco(endereco);
				this.repositorioProf.add(item);
				break;
			}
		}
	}

    public Professor recuperarProfessor(int id) throws CadastroNaoEncontradoException {
		for (Professor idProfessor : repositorioProf) {
			if (idProfessor.getID() == id)
				return idProfessor ;
		}
		throw new CadastroNaoEncontradoException("\n\nPROFESSOR DA DISCIPLINA " + "[" + id + "]" + " NAO ENCONTRADO!\n\n\n");
	}

	public void adicionarSalario(Professor item, int n, double salario) throws SalarioException{
		for(IGeral id : repositorioProf){
			if(id.getID() == n){
				item.setSalario(salario);
				this.repositorioProf.add(item);
				break;
			}
			throw new SalarioException("Salario nao foi adicionado!");
		}
	}

	public void adicionarDisciplina(Professor item, int n, String disciplina){
		for(IGeral id : repositorioProf){
			if(id.getID() == n){
				item.setDisciplina(disciplina);
				this.repositorioProf.add(item);
				break;
			}
		}
	}


	public void removerProfessor(Professor item, int n){
		for(IGeral id : repositorioProf){
			if (id.getID() != n){
				cont++;
			} else {
			    break;
            }
		}
		this.repositorioProf.remove(cont);
	}

    public void salvarRepositorioProfessor(String caminhoArquivoProfessor) throws IOException {
		FileOutputStream fout = new FileOutputStream(caminhoArquivoProfessor);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(this);
		oos.close();
	}

	public static RepositorioProfessor carregarRepositorioProfessor(String caminhoArquivoProfessor) throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream(caminhoArquivoProfessor);
		ObjectInputStream ois = new ObjectInputStream(fin);
		RepositorioProfessor resp = (RepositorioProfessor) ois.readObject();
		ois.close();
		return resp;
	}
}
