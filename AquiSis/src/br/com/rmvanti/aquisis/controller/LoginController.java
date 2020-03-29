package br.com.rmvanti.aquisis.controller;

import br.com.rmvanti.aquisis.core.IDao;
import br.com.rmvanti.aquisis.model.Login;
import br.com.rmvanti.aquisis.model.LoginSession;

/**
 *
 * @author rmvanti
 */
public class LoginController {
    
    private static LoginController ctrlLogin;
    
    private IDao<Integer, LoginSession> loginSessionDao;
    private IDao<Integer, Login> loginDao;
    
    private LoginController(){}//end constructor
    
    public static final LoginController getInstance(){
        if(ctrlLogin == null){
            ctrlLogin = new LoginController();
        }
        return ctrlLogin;
    }
    
    public boolean login(String username, String password){        
        return true;
    }
    
}//end class
