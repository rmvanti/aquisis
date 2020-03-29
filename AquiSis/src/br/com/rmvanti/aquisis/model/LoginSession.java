package br.com.rmvanti.aquisis.model;

import br.com.rmvanti.aquisis.core.AbstractAutoNumberEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author rmvanti
 */
@Entity
public class LoginSession extends AbstractAutoNumberEntity {
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginData;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date endSession;
        
    @OneToOne
    private SysUser sysuser;
    
    private String username;
    private String password;    
    private boolean sucessfull;    
    
    public LoginSession(){}//end constructor    

    public LoginSession(Date loginData, SysUser sysuser, String username, String password, boolean sucessfull) {
        this.loginData = loginData;
        this.sysuser = sysuser;
        this.username = username;
        this.password = password;
        this.sucessfull = sucessfull;
    }//end cosntructor

    public Date getLoginData() {
        return loginData;
    }

    public void setLoginData(Date loginData) {
        this.loginData = loginData;
    }

    public Date getEndSession() {
        return endSession;
    }

    public void setEndSession(Date endSession) {
        this.endSession = endSession;
    }

    public SysUser getSysuser() {
        return sysuser;
    }

    public void setSysuser(SysUser sysuser) {
        this.sysuser = sysuser;
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

    public boolean isSucessfull() {
        return sucessfull;
    }

    public void setSucessfull(boolean sucessfull) {
        this.sucessfull = sucessfull;
    }
            
}//end class
