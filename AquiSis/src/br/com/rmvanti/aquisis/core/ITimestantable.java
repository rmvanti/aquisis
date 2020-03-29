package br.com.rmvanti.aquisis.core;

import java.util.Date;

/**
 * @author rmvanti
 */
public interface ITimestantable {
    
    public Date getCreatedIn();
    public Date getLastUpdate();
    public void setLastUpdate(Date update);
    
}/*end interface*/
