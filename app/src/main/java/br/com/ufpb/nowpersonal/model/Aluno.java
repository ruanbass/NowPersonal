package br.com.ufpb.nowpersonal.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by ruanm on 28/04/2016.
 */
@DatabaseTable(tableName = "aluno")
public class Aluno {

    @DatabaseField(generatedId = true)
    private int _id;
    @DatabaseField(dataType = DataType.STRING)
    private String nome;
    @DatabaseField(dataType = DataType.STRING)
    private String sobrenome;
    @DatabaseField(dataType = DataType.STRING)
    private String dataNascimento;
    @DatabaseField(dataType = DataType.STRING)
    private String telefone;
    @DatabaseField(dataType = DataType.STRING)
    private String email;

    public Aluno() {
    }

    public Aluno(String nome, String sobrenome, String dataNascimento, String telefone, String email, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private String senha;

}
