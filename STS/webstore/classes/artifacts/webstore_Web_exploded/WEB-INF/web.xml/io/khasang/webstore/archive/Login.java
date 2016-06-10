package io.khasang.webstore.archive;

public class Login {
    private int id;
    private String login;
    private String password;
    private String security;

    public Login() {
    }

    public Login(int id, String login, String password, String security) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.security = security;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public boolean passwordMatches(final String password) {
        return password.equals(this.password);
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(final String security) {
        this.security = security;
    }
}
