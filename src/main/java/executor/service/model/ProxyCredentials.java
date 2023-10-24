package executor.service.model;

import java.io.Serializable;
import java.util.Objects;

public class ProxyCredentials
        implements Serializable {

    private static final long serialVersionUID = 321L;
    String username;
    String password;

    public ProxyCredentials() {
    }

    public ProxyCredentials(
            String username,
            String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProxyCredentials that = (ProxyCredentials) o;

        if (!Objects.equals(username, that.username)) return false;
        return Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("ProxyCredentials{username='%s', password='%s'}",
                             username,
                             password);
    }
}
