package br.com.rmvanti.aquisis.core;

import java.sql.Connection;
import java.util.Map;

/**
 * @author rmvanti
 */
public interface IDao<K,E> {

    /* conection methods */
    public Connection getConnection();
    
    /* CRUD methods*/
    public void insert(E entity);
    public E update(E entity);
    public void delete(E entity);
    public E find(K key);
    
    /* query methods */
    public Object executeNamedQuery(String queryName, Map params);
    public Object executeNamedQuery(String queryName, Class resultClass, Map params);
    
    public Object executeNamedNativeQuery(String nativeQueryName, Map params);
    public Object executeNativeQuery(String query, Map params);
    
}/*end interface*/
