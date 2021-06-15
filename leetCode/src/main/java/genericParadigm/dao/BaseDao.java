package genericParadigm.dao;

import genericParadigm.dao.impl.IBaseDao;

import java.lang.reflect.ParameterizedType;

public abstract class BaseDao<T> implements IBaseDao {

    private Class baseClass;

    private BaseDao() {
        Class baseClass = this.getClass();
        ParameterizedType parameterizedType = (ParameterizedType)baseClass.getGenericSuperclass();
        baseClass = (Class)parameterizedType.getActualTypeArguments()[0];
        System.out.println(baseClass);
    }



}
