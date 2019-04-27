package com.kotov.model;


public enum OrderStatusModel {

    NEW{
        @Override
        public String toString(){
            return "New product";
        }
    },
    PRODUCT_ASSEMBLY{
        @Override
        public String toString(){
            return "Product assembly";
        }
    },
    IN_MOVED{
        @Override
        public String toString(){
            return "The product is on the way";
        }
    },
    DELIVERED{
        @Override
        public String toString(){
            return "Delivered";
        }
    }





}
