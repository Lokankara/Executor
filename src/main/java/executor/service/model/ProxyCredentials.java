package executor.service.model;

import java.util.Objects;

public class ProxyCredentials {
    private String username;
    private String password;

    public ProxyCredentials() {
    }

    public ProxyCredentials(
            final String username,
            final String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(
            final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(
            final String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProxyCredentials that = (ProxyCredentials) o;

        if (!Objects.equals(username, that.username)) {
            return false;
        }
        return Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        int result = username != null
                     ? username.hashCode()
                     : 0;
        return 31 * result + (password != null
                              ? password.hashCode()
                              : 0);
    }

    @Override
    public String toString() {
        return String.format(
                "{username='%s', password='%s'}",
                username, password);
    }
}
