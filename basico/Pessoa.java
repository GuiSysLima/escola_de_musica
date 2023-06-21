package basico;

import java.io.Serializable;

public abstract class Pessoa implements IGeral, Serializable {
  private String nome;
  private String cpf;
  private String endereco;
  private int id;

  public Pessoa(){
  }

  public Pessoa(String nome, String cpf, String endereco, int id){
    this.nome = nome;
    this.cpf = cpf;
    this.endereco = endereco;
    this.id = id;
  }

  @Override
  public String getNome(){
   return nome;
  }
  @Override
  public void setNome(String nome){
    this.nome = nome;
  }
  
  @Override
  public String getCpf(){
    return cpf;
  }
  @Override
  public void setCpf(String cpf){
    this.cpf = cpf;
  }

  @Override
  public String getEndereco(){
    return endereco;
  }
  @Override
  public void setEndereco(String endereco){
    this.endereco = endereco;
  }

  @Override
  public void setID(int id) {
    this.id = id;
  }
  @Override
  public int getID() {
    return id;
  }
  @Override
  public String toString() {
    return "\nNome: " + nome + "\nCPF: " + cpf + "\nEndereco: " + endereco ;
  }
}