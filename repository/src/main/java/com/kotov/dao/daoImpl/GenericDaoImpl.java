package com.kotov.dao.daoImpl;

import com.kotov.dao.GenericDao;
import com.kotov.dao.SortOrders;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public abstract class GenericDaoImpl<T extends Serializable, ID extends Number> implements GenericDao<T, ID> {

    protected final Class<T> entityClass;

    @Autowired
    protected SessionFactory sessionFactory;

    public GenericDaoImpl(Class<T> clazz) {
        entityClass = clazz;
    }

    @Override
    public T add(T bean) {
        sessionFactory.getCurrentSession().persist(bean);
        return bean;
    }

    @Override
    public T getById(ID id) {
        return sessionFactory.getCurrentSession().get(entityClass, id);
    }

    @Override
    public List<T> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM " + entityClass.getName()).list();
    }

    @Override
    public boolean delete(T bean) {
        if (bean != null) {
            sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().merge(bean));
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(ID id) {
        return delete(getById(id));
    }

    @Override
    public T update(T bean) {
        return (T) sessionFactory.getCurrentSession().merge(bean);
    }

    @Override
    public List<T> getPage(int count, int page, SortOrders sortOrders) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM " + entityClass.getName() + " ORDER BY " + OrderToInstruction(sortOrders));
        query.setMaxResults(count);
        query.setFirstResult((page - 1) * count);
        return query.list();
    }

    @Override
    public Integer getRowCount() {
        String countStr = sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) as count FROM " + entityClass.getName()).uniqueResult().toString();
        Integer count = null;
        try {
            count = Integer.parseInt(countStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    protected String OrderToInstruction(SortOrders order) {
        switch (order) {
            case ASC:
                return " id ASC";
            case DESC:
                return " id DESC";
            case RAPID:
                return " RAPID()";
            default:
                return " id ASC";
        }
    }
}

