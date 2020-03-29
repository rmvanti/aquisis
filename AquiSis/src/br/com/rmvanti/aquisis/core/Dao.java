package br.com.rmvanti.aquisis.core;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author rmvanti
 * @param <K> Primary Key Entity Class
 * @param <E> Entity Class
 */
public class Dao<K,E> implements IDao<K,E> {

    private final Class entityClass;
    private final EntityManager entityManager;
    private final List<Class> interfaces;
    
    private final boolean isSoftDelete;
    private final boolean isTimestantable;
    
    /* Default constructor */

    /**
     * @author Rogério Mello Vanti
     * @since 11/11/2018
     * @param entityClass
     * @param entityManager
     */
    public Dao(Class entityClass, EntityManager entityManager){
        this.entityClass = entityClass;
        this.entityManager = entityManager;
        this.interfaces = new ArrayList();
        this.interfaces.addAll(Arrays.asList(this.entityClass.getInterfaces()));
        Class parentClass = this.entityClass.getSuperclass();        
        while(parentClass == null || !parentClass.getSimpleName().equals("Object")){
            this.interfaces.addAll(Arrays.asList(parentClass.getInterfaces()));
            parentClass = parentClass.getSuperclass();
        }/*end while*/
        this.entityClass.getSuperclass();
        this.isSoftDelete = this.interfaces.contains(ISoftDelete.class);
        this.isTimestantable = this.interfaces.contains(ITimestantable.class);                        
    }/*end constructor*/
    
    /* ************************ Connection Methods ************************** */
    /**
     * @author Rogério Mello Vanti
     * @since 11/11/2018
     * @return 
     */
    @Override
    public Connection getConnection() {
        return this.entityManager.unwrap(Connection.class);
    }
    
    /* ************************** CRUD Methods ***************************** */
    /**
     * @author Rogério Mello Vanti
     * @since 11/11/2018
     * @param entity Object of entity of Type E
     */
    @Override
    public void insert(E entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();
    }

    /**
     * @author Rogério Mello Vanti
     * @since 11/11/2018
     * @param entity Object of entity of Type E
     * @return Return a object of type E updated
     */
    @Override
    public E update(E entity) {
        E ret;
        this.entityManager.getTransaction().begin();
        if(this.isTimestantable){
            ITimestantable t = (ITimestantable)entity;
            t.setLastUpdate(new Date());
        }/*end if*/        
        ret = this.entityManager.merge(entity);
        this.entityManager.getTransaction().commit();
        return ret;
    }

    /**
     * @since 11/11/2018
     * @param entity Object of entity of Type E  
     */
    @Override
    public void delete(E entity) {
        this.entityManager.getTransaction().begin();
        if(this.isSoftDelete){
            ISoftDelete isd = (ISoftDelete)entity;
            isd.setIsDeleted(true);
            update(entity);
        }else{
            this.entityManager.remove(entity);        
        }/*end else*/
        this.entityManager.getTransaction().commit();
    }

    /**
     * 
     * @since 11/11/2018
     * @param key Value of id with a respective K type, where K is class of 
     * primary key of entity  
     * @return Return a object whith id informed of respective E type
     */
    @Override
    public E find(K key) {
        return (E)entityManager.find(entityClass, key);
    }

    /* ************************** Query Methods ***************************** */
    /**
     * This method returns a Object how result of query. 
     * 
     * @since 11/11/2018
     * @param queryName Name of NamedQuery of entity.
     * @param params Map with a set of key/value of parameters of query.
     * @return   
     */
    @Override
    public Object executeNamedQuery(String queryName, Map params) {
        Query query = this.entityManager.createNamedQuery(queryName);
        if(params != null){
            Set keys = params.keySet();        
            Iterator it = keys.iterator();
            String key = null;
            Object value = null;        
            while(it.hasNext()){
                key = (String)it.next();
                value = params.get(key);
                query.setParameter(key, query);
            }/*end while*/        
        }/*end if*/
        return query.getResultList();
    }
    
    /**
     * This method returns a Object how result (resultClass type) of query. 
     * Warning: This method use "getSingleResult" method for return a result, 
     * also is mandatory have a result how result else this call thows a exeption.
     * 
     * @since 11/11/2018
     * @param queryName Name of NamedQuery of entity.
     * @param resultClass Name of Class with result of query.
     * @param params Map with a set of key/value of parameters of query.
     * @return   
     */
    @Override
    public Object executeNamedQuery(String queryName, Class resultClass, Map params) {
        Query query = this.entityManager.createNamedQuery(queryName, resultClass);
        if(params != null){
            Set keys = params.keySet();        
            Iterator it = keys.iterator();
            String key = null;
            Object value = null;        
            while(it.hasNext()){
                key = (String)it.next();
                value = params.get(key);
                query.setParameter(key, query);
            }/*end while*/        
        }/*end if*/
        return query.getSingleResult();
    }

    /**
     * @author Rogério Mello Vanti
     * @since 11/11/2018
     * @param nativeQueryName
     * @param params
     * @return
     */
    @Override
    public Object executeNamedNativeQuery(String nativeQueryName, Map params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @author Rogério Mello Vanti
     * @since 11/11/2018
     * @param query
     * @param params
     * @return
     */
    @Override
    public Object executeNativeQuery(String query, Map params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}/*end class*/
