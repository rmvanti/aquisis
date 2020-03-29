package br.com.rmvanti.aquisis.model;

import br.com.rmvanti.aquisis.core.AbstractAutoNumberEntity_;
import br.com.rmvanti.aquisis.model.SysUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-28T21:56:34")
@StaticMetamodel(LoginSession.class)
public class LoginSession_ extends AbstractAutoNumberEntity_ {

    public static volatile SingularAttribute<LoginSession, String> password;
    public static volatile SingularAttribute<LoginSession, Boolean> sucessfull;
    public static volatile SingularAttribute<LoginSession, Date> endSession;
    public static volatile SingularAttribute<LoginSession, SysUser> sysuser;
    public static volatile SingularAttribute<LoginSession, Date> loginData;
    public static volatile SingularAttribute<LoginSession, String> username;

}