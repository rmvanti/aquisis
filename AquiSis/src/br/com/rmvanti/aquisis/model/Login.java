package br.com.rmvanti.aquisis.model;

import br.com.rmvanti.aquisis.core.AbstractAutoNumberEntity;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author rmvanti
 */
@Entity
public class Login extends AbstractAutoNumberEntity {
    
    private String username;
    private String password;
    
    @OneToOne
    private SysUser sysuser;
    
    public Login(){}//end constructor
    
    public Login(String username, String password, SysUser sysuser){
        this.username = username;
        this.password = password;
        this.sysuser = sysuser;
    }//end constructor

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

    public SysUser getSysuser() {
        return sysuser;
    }

    public void setSysuser(SysUser sysuser) {
        this.sysuser = sysuser;
    }
                
}//end class
