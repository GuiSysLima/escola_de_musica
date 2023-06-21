package basico;

import java.io.Serializable;
import java.util.ArrayList;

public class Aluno extends Pessoa implements IAluno, Serializable{
  //private double[] notas;
  private ArrayList<Double>notas = new ArrayList<>();
  Pessoa dado;
  
  public Aluno(){
    super();
  }
  public Aluno(String nome, String cpf, String endereco, int id){
    super(nome, cpf, endereco, id);
  }
  
  public void setNota(double nota){
    this.notas.add(nota);
  }

  @Override
  public String toString() {
    return "\n\nID: " + "[" + super.getID() + "]\n" + super.toString() + "\nNotas: " + notas;
  }
}