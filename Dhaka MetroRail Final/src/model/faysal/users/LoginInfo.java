
package model.faysal.users;

import java.io.Serializable;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class LoginInfo implements Serializable {
    
    private String userIdentity;
    String userType;
    private String password;

    public LoginInfo(String userIdentity, String userType, String password) {
        this.userIdentity = userIdentity;
        this.userType = userType;
        this.password = password;
    }


    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginInfo{" + "userIdentity=" + userIdentity + ", userType=" + userType + ", password=" + password + '}';
    }
    
    
    
}
