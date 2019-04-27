package com.kotov.dao;


import com.kotov.model.NewsModel;



public interface NewsDao extends GenericDao<NewsModel, Long> {
    NewsModel getByNewsTiltle(String name);
}
