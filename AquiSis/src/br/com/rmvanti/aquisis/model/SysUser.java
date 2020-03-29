package br.com.rmvanti.aquisis.model;

import br.com.rmvanti.aquisis.core.AbstractAutoNumberEntity;
import javax.persistence.Entity;

/**
 * @author rmvanti
 */
@Entity
public class SysUser extends AbstractAutoNumberEntity {
    
    private String userName;
    private String email;    
    
    public SysUser(){}//end constructor
    
    public SysUser(String userName, String email){
        this.userName = userName;
        this.email = email;
    }//end constructor

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
            
}//end class
