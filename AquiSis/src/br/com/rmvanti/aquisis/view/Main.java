package br.com.rmvanti.aquisis.view;

import br.com.rmvanti.aquisis.controller.Context;
import java.io.File;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author rmvanti
 */
public class Main {
 
    public static void main(String[] args) {
        Context ctx = Context.getInstance();                
        EntityManager em = Persistence.createEntityManagerFactory("AquiSisPU").createEntityManager();
        
        String logoPath = ".."+File.separator+"resource"+File.separator+"icon_fish_128.png";
        ctx.add(em, "EntityManager");
        ctx.add(logoPath, "logopath");
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        LoginFrame.getInstance();
    }//end main
    
}//end class
