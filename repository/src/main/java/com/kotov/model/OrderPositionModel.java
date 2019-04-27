package com.kotov.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ordersPosition")
public class OrderPositionModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "op_id")
    private Long id;

    @Column(name = "op_count")
    private Integer count;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "op_product_id")
    private GoodsModel productModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public GoodsModel getGoodsModel() {
        return productModel;
    }

    public void setProductModel(GoodsModel goodsModel) {
        this.productModel = productModel;
    }
}
