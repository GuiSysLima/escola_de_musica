package basico;

import java.io.Serializable;
import java.util.ArrayList;

public class Professor extends Pessoa implements IProfessor, Serializable{
    private ArrayList<String>disciplinas = new ArrayList<>();
    private double salario;
    Pessoa dado;

    public Professor(){
        super();
    }
    public Professor(String nome, String cpf, String endereco, int id){
        super(nome, cpf, endereco, id);
    }

    @Override
    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public void setDisciplina(String disciplina) {
        this.disciplinas.add(disciplina);
        
    }


    @Override
    public String toString() {
        return "\n\nID: " + "[" + super.getID() + "]\n" + super.toString() + "\nDisciplinas: " + disciplinas + "\nSalario: " + salario;
    }

}