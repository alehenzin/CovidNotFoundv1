
package com.mycompany.covidnotfound;

public class Pessoa {
    private int id;
    private String cpf;
    private String nome;
    private int idade;
    private boolean saude;
    private String endereco;
    private String vacinacao;
    private int prioridade;

    public Pessoa() {
    }

    public Pessoa(int id, String cpf, String nome, int idade, boolean saude, String endereco) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.saude = saude;
        this.endereco = endereco;
    }
    

    public Pessoa(int id, String cpf, String nome, int idade, boolean saude, String endereco, String vacinacao, int prioridade) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.saude = saude;
        this.endereco = endereco;
        this.vacinacao = vacinacao;
        this.prioridade = prioridade;
    }
    

    public Pessoa(int id, String cpf, String nome, int idade, boolean saude, String endereco, int prioridade) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.saude = saude;
        this.endereco = endereco;
        this.prioridade = prioridade;
    }

    public Pessoa(int id) {
        this.id = id;
    }
    
    
    public Pessoa(String cpf) {
        this.cpf = cpf;
    }

    public Pessoa(String cpf, String nome, int idade, boolean saude, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.saude = saude;
        this.endereco = endereco;
    }

    public Pessoa(String cpf, String nome, int idade, boolean saude, String endereco, String vacinacao, int prioridade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.saude = saude;
        this.endereco = endereco;
        this.vacinacao = vacinacao;
        this.prioridade = prioridade;
    }    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isSaude() {
        return saude;
    }

    public void setSaude(boolean saude) {
        this.saude = saude;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getVacinacao() {
        return vacinacao;
    }

    public void setVacinacao(String vacinacao) {
        this.vacinacao = vacinacao;
    }
    
    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
    
    public void definirPrioridade(Pessoa p) {
        if(p.getIdade() >= 70){
            p.setPrioridade(1);
        }
        else if(p.isSaude() == true){
            p.setPrioridade(2);
        }
        else{
            p.setPrioridade(3);
        }
    }
        @Override
        public String toString() {
        return "Nome: " + nome + " / Cpf: " + cpf;
    }
}

