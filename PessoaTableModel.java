
package com.mycompany.covidnotfound;

import java.util.List;
import javax.swing.table.AbstractTableModel;


public class PessoaTableModel extends AbstractTableModel {
    private List<Pessoa>pessoas;
    private String[] colunas = {"CPF", "Nome", "Idade", "Profissão", "Endereço", "Data", "Prioridade"};
    
    public PessoaTableModel (Pessoa pessoa) throws Exception{
        DAO dao = new DAO();
        this.pessoas = dao.buscaPessoa(pessoa);
    }
    
    @Override
    public int getRowCount(){
        return pessoas.size();
    }
    
    @Override
    public int getColumnCount(){
        return 7;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0: 
                return this.pessoas.get(rowIndex).getCpf();
            case 1: 
                return this.pessoas.get(rowIndex).getNome();
            case 2:
                return this.pessoas.get(rowIndex).getIdade();
            case 3:
                return this.pessoas.get(rowIndex).isSaude();
            case 4:
                return this.pessoas.get(rowIndex).getEndereco();
            case 5:
                return this.pessoas.get(rowIndex).getVacinacao();
            case 6:
                return this.pessoas.get(rowIndex).getPrioridade();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        return this.colunas[column];
    }
    
}
