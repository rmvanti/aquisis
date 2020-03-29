package br.com.rmvanti.aquisis.core;

/**
 * @author rmvanti
 */
public interface ITenantable<E> {
    
    public void setTenant(E tenant);
    public E getTenant();
    
}/*end interface*/
