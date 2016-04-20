package br.com.ufpb.nowpersonal.model;

import java.util.Date;

/**
 * Created by ruanm on 14/03/2016.
 */
public class Aluno {
    private String nome;
    private String login;
    private String password;
    private Date data;
    private String email;
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
