package behdad222.realmrelationtest.Model;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/*
 * Created by behdad on 4/17/15.
 */

@RealmClass
public class UserModel extends RealmObject {
    private String serverID;
    private String name;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String avatarUrl;
    private String credit;
    private String lastLogin;
    private boolean active;
    private String token;

    public UserModel(
            String serverID,
            String name,
            String password,
            String firstName,
            String lastName,
            String email,
            String avatarUrl,
            String credit,
            String lastLogin,
            boolean active,
            String token) {

        this.serverID = serverID;
        this.name = name;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avatarUrl = avatarUrl;
        this.credit = credit;
        this.lastLogin = lastLogin;
        this.active = active;
        this.token = token;
    }

    public String getServerID() {
        return serverID;
    }

    public void setServerID(String serverID) {
        this.serverID = serverID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
