package br.com.rmvanti.aquisis.core;

import java.util.Date;

/**
 * @author rmvanti
 * @since 11/11/2018
 */
public interface ISynchronizable {
    
    public boolean setIsSynchronized(boolean sync);
    public boolean getIsSynchronized();
    public Date getLastSync();
    public void setLastSync(Date sync);
    
}/* end interface */
