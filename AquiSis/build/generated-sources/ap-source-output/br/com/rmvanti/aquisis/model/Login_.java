package br.com.rmvanti.aquisis.model;

import br.com.rmvanti.aquisis.core.AbstractAutoNumberEntity_;
import br.com.rmvanti.aquisis.model.SysUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-28T21:56:34")
@StaticMetamodel(Login.class)
public class Login_ extends AbstractAutoNumberEntity_ {

    public static volatile SingularAttribute<Login, String> password;
    public static volatile SingularAttribute<Login, SysUser> sysuser;
    public static volatile SingularAttribute<Login, String> username;

}