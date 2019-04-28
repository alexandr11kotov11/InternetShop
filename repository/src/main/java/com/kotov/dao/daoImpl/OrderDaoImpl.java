package com.kotov.dao.daoImpl;


import com.kotov.dao.OrderDao;
import com.kotov.model.OrderModel;
import org.springframework.stereotype.Repository;

    @Repository("orderDAO")
    public class OrderDaoImpl extends GenericDaoImpl<OrderModel, Long> implements OrderDao {
        public OrderDaoImpl() {
            super(OrderModel.class);
        }

        @Override
        public OrderModel getByStatus(Integer num) {
            return null;
        }
    }

