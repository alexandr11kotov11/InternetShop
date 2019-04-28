package com.kotov.dao;

import com.kotov.model.OrderModel;

public interface OrderDao extends GenericDao<OrderModel,Long>{
    OrderModel getByStatus (Integer num);
}
