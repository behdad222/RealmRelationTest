package behdad222.realmrelationtest.Model;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by behdad on 4/17/15.
 */


@RealmClass
public class UserModel extends RealmObject {
    private String userServerID;
    private String userUserName;
    private String userPassword;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userAvatarUrl;
    private String userCredit;
    private String userLastLogin;
    private boolean userActive;
    private String userToken;

    public UserModel(String userServerID, String userUserName, String userPassword,
                     String userFirstName, String userLastName, String userEmail,
                     String userAvatarUrl, String userCredit, String userLastLogin,
                     boolean userActive, String userToken) {
        this.userServerID = userServerID;
        this.userUserName = userUserName;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userAvatarUrl = userAvatarUrl;
        this.userCredit = userCredit;
        this.userLastLogin = userLastLogin;
        this.userActive = userActive;
        this.userToken = userToken;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getUserServerID() {
        return userServerID;
    }

    public void setUserServerID(String userServerID) {
        this.userServerID = userServerID;
    }

    public String getUserUserName() {
        return userUserName;
    }

    public void setUserUserName(String userUserName) {
        this.userUserName = userUserName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl;
    }

    public String getUserCredit() {
        return userCredit;
    }

    public void setUserCredit(String userCredit) {
        this.userCredit = userCredit;
    }

    public String getUserLastLogin() {
        return userLastLogin;
    }

    public void setUserLastLogin(String userLastLogin) {
        this.userLastLogin = userLastLogin;
    }

    public boolean isUserActive() {
        return userActive;
    }

    public void setUserActive(boolean userActive) {
        this.userActive = userActive;
    }

}
