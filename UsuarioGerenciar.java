
package com.mycompany.covidnotfound;

public class UsuarioGerenciar {
    private int id;
    private String tipo;
    private String login;
    private String senha;
    private String nome;
    private String cpf;

    public UsuarioGerenciar(int id, String tipo, String login, String senha, String nome, String cpf) {
        this(tipo, login, senha, nome, cpf);
        this.id = id;
//        this.tipo = tipo;
//        this.login = login;
//        this.senha = senha;
//        this.nome = nome;
//        this.cpf = cpf;
    }
    
    public UsuarioGerenciar (String tipo, String login, String senha, String nome, String cpf) {
        setTipo(tipo);
        setLogin(login);
        setSenha(senha);
        setNome(nome);
        setCpf(cpf);
    }
    
    public UsuarioGerenciar (int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + " / Nome: " + nome;
    }
    
    
    
    
}
