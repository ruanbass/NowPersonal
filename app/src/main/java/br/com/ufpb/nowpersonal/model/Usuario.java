package br.com.ufpb.nowpersonal.model;

/**
 * Created by ruanm on 14/03/2016.
 */
public abstract class Usuario {

    private String login;
    private String password;

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
