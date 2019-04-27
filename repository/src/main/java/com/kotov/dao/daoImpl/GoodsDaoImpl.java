package com.kotov.dao.daoImpl;


import com.kotov.dao.GoodsDao;
import com.kotov.dao.SortOrders;
import com.kotov.model.GoodsModel;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository("goodsDAO")
public class GoodsDaoImpl extends GenericDaoImpl<GoodsModel, Long> implements GoodsDao {

    public GoodsDaoImpl() {
        super(GoodsModel.class);
    }

    @Override
    public List<GoodsModel> getPage(int count, int page, SortOrders sortOrders) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM " + entityClass.getName() + " WHERE isActive = true ORDER BY " + OrderToInstruction(sortOrders));
        query.setMaxResults(count);
        query.setFirstResult((page - 1) * count);
        return query.list();
    }

    @Override
    public GoodsModel getById(Long id) {
        return (GoodsModel) sessionFactory.getCurrentSession().createQuery("FROM  " + entityClass.getName() + " WHERE isActive = true AND id = '" + id + "'").uniqueResult();
    }

    @Override
    public List<GoodsModel> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM " + entityClass.getName() +" WHERE isActive = true").list();
    }

    @Override
    public Integer getRowCount(){
        String countStr = sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) as count FROM " + entityClass.getName()+" WHERE isActive = true").uniqueResult().toString();
        Integer count = null;
        try {
            count = Integer.parseInt(countStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public boolean delete(GoodsModel bean) {
        if (bean == null) {
            return false;
        }
        if (sessionFactory.getCurrentSession().contains(bean)) {
            bean.setActive(false);
        } else {
            GoodsModel associatedBean = getById(bean.getId());
            if (associatedBean == null) {
                return false;
            }
            associatedBean.setActive(false);
        }
        return true;
    }

    public boolean hardDelete(GoodsModel bean){
        return super.delete(bean);
    }
}
