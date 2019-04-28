package com.kotov.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DaoList {

    @Autowired
    private FeedbackDao feedbackDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private OrderDao orderDao;


    public FeedbackDao getFeedbackDao() {
        return feedbackDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public NewsDao getNewsDao() {
        return newsDao;
    }

}




