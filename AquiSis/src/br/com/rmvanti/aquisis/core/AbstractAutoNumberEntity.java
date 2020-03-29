package br.com.rmvanti.aquisis.core;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author rmvanti
 */
@MappedSuperclass
public abstract class AbstractAutoNumberEntity implements IIdentifiable<Integer>, ITimestantable, Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    
    @Temporal(TemporalType.TIMESTAMP)
    protected final Date createdIn;
    
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastUpdate;
    
    public AbstractAutoNumberEntity(){
        this.createdIn = new Date();
        this.lastUpdate = createdIn;
    }/*end constructor*/
    
    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Date getCreatedIn() {
        return this.createdIn;
    }

    @Override
    public Date getLastUpdate() {
        return this.lastUpdate;
    }

    @Override
    public void setLastUpdate(Date update) {
        this.lastUpdate = update;
    }
   
}/*end class*/
