package com.kotov.dao.daoImpl;

import com.kotov.dao.UserDao;
import com.kotov.model.UserModel;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDAO")
public class UserDaoImpl extends GenericDaoImpl<UserModel, Long> implements UserDao {

    public UserDaoImpl() {
        super(UserModel.class);
    }


    public UserModel getByEmail(String value) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM UserModel WHERE mail = :mail");
        query.setParameter("mmail", value);
        return (UserModel) query.uniqueResult();
    }

    public List<UserModel> getActive() {
        return sessionFactory.getCurrentSession().createQuery("FROM " + entityClass.getName() + "WHERE isActive = true").list();
    }

    @Override
    public UserModel getByMail(String login) {
        return null;
    }
}
