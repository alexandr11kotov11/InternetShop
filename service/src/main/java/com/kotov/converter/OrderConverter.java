package com.kotov.converter;


import com.kotov.model.OrderModel;
import com.kotov.model.OrderPositionModel;
import com.kotov.model.OrderStatusModel;
import com.kotov.modelDTO.OrderDTO;
import com.kotov.modelDTO.UserDTO;

import java.math.BigDecimal;

public class OrderConverter {

    public static OrderDTO toDTO(OrderModel orderModel, UserDTO userDTO) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(orderModel.getId());
        orderDTO.setStatus(orderModel.getStatus());
        if (userDTO == null) {
            orderDTO.setUser(UserConverter.toDTO(orderModel.getUserModel(), false));
        } else {
            orderDTO.setUser(userDTO);
        }

        if(orderModel.getStatus().equals(OrderStatusModel.NEW)){
            orderDTO.setPossibleToEdit(true);
        }else{
            orderDTO.setPossibleToEdit(false);
        }

        BigDecimal totalPrice = new BigDecimal(0);
        for (OrderPositionModel orderPositionModel : orderModel.getOrderPositionsModel()) {
            orderDTO.getProducts().put(ProductConverter.toDTO(position.getProduct()), position.getCount());
            totalPrice = totalPrice.add(position.getProduct().getPrice().multiply(new BigDecimal(position.getCount())));
        }
        orderDTO.setTotalPrice(totalPrice);

        return orderDTO;
    }

    public static Order fromDTO(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setStatus(orderDTO.getStatus());
        order.setUser(UserConverter.fromDTO(orderDTO.getUser(),false));

        for(Map.Entry<ProductDTO, Integer> product: orderDTO.getProducts().entrySet()){
            OrderPosition orderPosition = new OrderPosition();
            orderPosition.setProduct(ProductConverter.fromDTO(product.getKey()));
            orderPosition.setCount(product.getValue());
            order.getOrderPositions().add(orderPosition);
        }
        return order;
    }

    public static List<OrderDTO> toDTO(List<Order> orders){
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(Order order: orders){
            orderDTOS.add(toDTO(order, null));
        }
        return orderDTOS;
    }
}
