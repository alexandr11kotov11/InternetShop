package com.kotov.dao.daoImpl;


import com.kotov.dao.NewsDao;
import com.kotov.model.NewsModel;
import org.springframework.stereotype.Repository;


@Repository("newsDAO")
public class NewsDaoImpl extends GenericDaoImpl<NewsModel, Long> implements NewsDao {
    public NewsDaoImpl(Class<NewsModel> clazz) {
        super(clazz);
    }

    @Override
    public NewsModel getByNewsTiltle(String name) {
        return null;
    }
}
