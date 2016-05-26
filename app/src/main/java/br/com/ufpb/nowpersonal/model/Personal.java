package br.com.ufpb.nowpersonal.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by ruanm on 25/05/2016.
 */
@DatabaseTable(tableName = "personal")
public class Personal {

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
    @DatabaseField(dataType = DataType.STRING)
    private String cidade;
    @DatabaseField(dataType = DataType.STRING)
    private String bairro;
    public Personal(int _id, String nome, String sobrenome, String dataNascimento, String telefone, String email, String cidade, String bairro, String localAdendimento, String horarioAtendiemntoInicio, String horarioAtendiemntoFim, double preco, int cref) {
        this._id = _id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.cidade = cidade;
        this.bairro = bairro;
        this.localAdendimento = localAdendimento;
        this.horarioAtendiemntoInicio = horarioAtendiemntoInicio;
        this.horarioAtendiemntoFim = horarioAtendiemntoFim;
        this.preco = preco;
        this.cref = cref;
    }



    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalAdendimento() {
        return localAdendimento;
    }

    public void setLocalAdendimento(String localAdendimento) {
        this.localAdendimento = localAdendimento;
    }

    public String getHorarioAtendiemntoInicio() {
        return horarioAtendiemntoInicio;
    }

    public void setHorarioAtendiemntoInicio(String horarioAtendiemntoInicio) {
        this.horarioAtendiemntoInicio = horarioAtendiemntoInicio;
    }

    public String getHorarioAtendiemntoFim() {
        return horarioAtendiemntoFim;
    }

    public void setHorarioAtendiemntoFim(String horarioAtendiemntoFim) {
        this.horarioAtendiemntoFim = horarioAtendiemntoFim;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getCref() {
        return cref;
    }

    public void setCref(int cref) {
        this.cref = cref;
    }

    @DatabaseField(dataType = DataType.STRING)

    private String localAdendimento;
    @DatabaseField(dataType = DataType.STRING)
    private String horarioAtendiemntoInicio;
    @DatabaseField(dataType = DataType.STRING)
    private String horarioAtendiemntoFim;
    @DatabaseField(dataType = DataType.DOUBLE)
    private double preco;
    @DatabaseField(dataType = DataType.INTEGER)
    private int cref;

    public Personal() {
    }
}