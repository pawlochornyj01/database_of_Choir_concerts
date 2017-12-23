package ua.com.dudaryk.service;

import ua.com.dudaryk.service.interfaces.AbstractService;

public abstract class AbstractServiceImpl<T> implements AbstractService<T> {
    private Class<T> clazz;

    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }
}
