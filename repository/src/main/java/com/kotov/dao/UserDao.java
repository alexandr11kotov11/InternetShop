package com.kotov.dao;


import com.kotov.model.UserModel;

public interface UserDao extends GenericDao<UserModel, Long> {

    UserModel getByMail(String login);

}
