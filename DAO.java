
package com.mycompany.covidnotfound;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public boolean existe (UsuarioLogin u) throws Exception{
        String sql = "SELECT * FROM tb_usuario WHERE login = ? AND senha = ?";
        try (Connection conexao = ConexaoDB.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql);){
            ps.setString(1, u.getLogin());
            ps.setString(2, u.getSenha());
            try (ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }
    }
    public boolean eAdm(UsuarioLogin user) throws Exception{
        String sql = "SELECT * FROM tb_usuario WHERE tipo = 'adm' AND login= ? AND senha= ?";
        try(Connection conexao = ConexaoDB.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getSenha());
            try(ResultSet rs= ps.executeQuery()){
                return rs.next();
            }
        }
    }
    public UsuarioGerenciar[] obterUsuarios () throws Exception {
        String sql = "SELECT * FROM tb_usuario";
        try (Connection conexao = ConexaoDB.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = ps.executeQuery()){
            int totalDeUsuarios = rs.last() ? rs.getRow() : 0;
            UsuarioGerenciar[] usuariogerenciar = new UsuarioGerenciar[totalDeUsuarios];
            rs.beforeFirst();
            int contador = 0;
            while (rs.next()){
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                usuariogerenciar[contador] = new UsuarioGerenciar(id, tipo, login, senha, nome, cpf);
                contador++;
            }   
            return usuariogerenciar;
        }
    }
    public void inserirUsuario (UsuarioGerenciar usuariogerenciar) throws Exception{
        String sql = "INSERT INTO tb_usuario (tipo, login, senha, nome, cpf) VALUES (?, ?, ?, ?, ?)";
        try(Connection conexao = ConexaoDB.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1,usuariogerenciar.getTipo());
            ps.setString(2,usuariogerenciar.getLogin());
            ps.setString(3,usuariogerenciar.getSenha());
            ps.setString(4,usuariogerenciar.getNome());
            ps.setString(5,usuariogerenciar.getCpf());
            ps.execute();
        }
    }
    public void atualizarUsuarios (UsuarioGerenciar usuariogerenciar) throws Exception{
        String sql = "UPDATE tb_usuario SET tipo = ?, login = ?, senha = ?, nome = ?, cpf = ? WHERE id = ?";
        try(Connection conexao = ConexaoDB.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1,usuariogerenciar.getTipo());
            ps.setString(2,usuariogerenciar.getLogin());
            ps.setString(3,usuariogerenciar.getSenha());
            ps.setString(4,usuariogerenciar.getNome());
            ps.setString(5,usuariogerenciar.getCpf());
            ps.setInt(6,usuariogerenciar.getId());
            ps.execute();
            
        }
    }
    public void removerUsuarios (UsuarioGerenciar usuariogerenciar) throws Exception{
        String sql = "DELETE FROM tb_usuario WHERE id = ?";
        try (Connection conexao = ConexaoDB.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql);){
            ps.setInt (1, usuariogerenciar.getId());
            ps.execute();
    
        }
    }
 //verificar CPF da pessoa
    public boolean verificarCPFPes(Pessoa p) throws Exception{
        String sql = "SELECT * FROM tb_paciente WHERE cpf = ?";
        try(Connection conexao = ConexaoDB.obterConexao();
            PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1, p.getCpf());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
    //adicionar pessoa
    public void adicionarPessoa (Pessoa p) throws Exception{
        String sql = "INSERT INTO tb_paciente (cpf, nome, idade, saude, endereco, prioridade) VALUES (?, ?, ?, ?, ?, ?)";
        try(Connection conexao = ConexaoDB.obterConexao();
            PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1, p.getCpf());
            ps.setString(2, p.getNome());
            ps.setInt(3, p.getIdade());
            ps.setBoolean(4, p.isSaude());
            ps.setString(5, p.getEndereco());
            ps.setInt(6, p.getPrioridade());
            ps.execute();
        }
    }
        public void removerPessoa (Pessoa p) throws Exception{
        String sql = "DELETE FROM tb_paciente WHERE id = ?";
        try (Connection conexao = ConexaoDB.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql);){
            ps.setInt (1, p.getId());
            ps.execute();
    
        }
    }
        public void atualizarPessoa (Pessoa p) throws Exception{
        String sql = "UPDATE tb_paciente SET cpf = ?, nome = ?, idade = ?, saude = ?, endereco = ?, prioridade = ? WHERE id = ?";
        try(Connection conexao = ConexaoDB.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1,p.getCpf());
            ps.setString(2,p.getNome());
            ps.setInt(3,p.getIdade());
            ps.setBoolean(4,p.isSaude());
            ps.setString(5,p.getEndereco());
            ps.setInt(6, p.getPrioridade());
            ps.setInt(7, p.getId());
            ps.execute();
            
        }
    }
    //adicionar data
    public void adicionarData(Pessoa p) throws Exception{
        String sql = "UPDATE tb_paciente SET vacinacao = ? WHERE cpf = ?";
        try(Connection conexao = ConexaoDB.obterConexao();
            PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1, p.getVacinacao());
            ps.setString(2, p.getCpf());
            ps.execute();
        }
    }
    //busca pessoa
    public List <Pessoa> buscaPessoa (Pessoa pessoa) throws Exception{
        String sql = "SELECT cpf, nome, idade, saude, endereco, DATE_FORMAT(vacinacao, \"%d/%m/%Y\"), prioridade FROM tb_paciente";
        List<Pessoa> pessoas = new ArrayList<>();
        try(Connection conexao = ConexaoDB.obterConexao();
            PreparedStatement ps = conexao.prepareStatement(sql)){
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    String cpf = rs.getString("cpf");
                    String nome = rs.getString("nome");
                    int idade = rs.getInt("idade");
                    boolean saude = rs.getBoolean("saude");
                    String endereco = rs.getString("endereco");
                    String vacinacao = rs.getString("DATE_FORMAT(vacinacao, \"%d/%m/%Y\")");
                    int prioridade = rs.getInt("prioridade");
                    pessoas.add(new Pessoa(cpf, nome, idade, saude, endereco, vacinacao, prioridade));
                }
            }
        }
        return pessoas;
    }
        public Pessoa[] obterPessoa () throws Exception {
        String sql = "SELECT * FROM tb_paciente";
        try (Connection conexao = ConexaoDB.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = ps.executeQuery()){
            int totalDePessoas = rs.last() ? rs.getRow() : 0;
            Pessoa[] p = new Pessoa[totalDePessoas];
            rs.beforeFirst();
            int contador = 0;
            while (rs.next()){
                int id = rs.getInt("id");
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                boolean saude = rs.getBoolean("saude");
                String endereco = rs.getString("endereco");
                String vacinacao = rs.getString("vacinacao");
                int prioridade = rs.getInt("prioridade");      
                p[contador] = new Pessoa(id, cpf, nome, idade, saude, endereco, vacinacao, prioridade);
                contador++;
            }   
            return p;
        }
    }  
}