package com.kotov.dao;

import com.kotov.model.GoodsModel;

import java.util.List;

public interface GoodsDao extends GenericDao<GoodsModel, Long> {

    List<GoodsModel> getPage(int page, int count, SortOrders sortOrders);


}
