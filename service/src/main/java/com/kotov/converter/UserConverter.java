package com.kotov.converter;


import com.kotov.model.OrderModel;
import com.kotov.model.UserModel;
import com.kotov.modelDTO.OrderDTO;
import com.kotov.modelDTO.UserDTO;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {

    public static UserDTO toDTO(UserModel userModel, Boolean loadOrders){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userModel.getId());
        userDTO.setRole(userModel.getRoleModel());
        userDTO.setAddress(userModel.getAddress());
        userDTO.setFullName(userModel.getFullName());
        userDTO.setAddInfo(userModel.getAddInfo());
        userDTO.setMail(userModel.getMail());
        userDTO.setActive(userModel.getActive());
        userDTO.setPassword(userModel.getPassword());
        userDTO.setPhone(userModel.getPhone());

        if(loadOrders){
            List<OrderModel> orders = userModel.();
            List<OrderDTO> orderDTOList = new ArrayList<>();
            for (OrderModel order: orders) {
                orderDTOList.add(OrderConverter.toDTO(order, userDTO));
            }
            userDTO.setOrders(orderDTOList);
        }
        return userDTO;
    }

    public static UserModel fromDTO(UserDTO userDTO, boolean setOrders){
        UserModel userModel = new User();
        userModel.setId(userDTO.getId());
        userModel.setRoleModel(userDTO.getRole());
        userModel.setAddress(userDTO.getAddress());
        userModel.setFullName(userDTO.getFullName());
        userModel.setAddInfo(userDTO.getAddInfo());
        userModel.setMail(userDTO.getMail());
        userModel.setActive(userDTO.getActive());
        userModel.setPassword(userDTO.getPassword());
        userModel.setPhone(userDTO.getPhone());

        if(userDTO.getOrders() != null && userDTO.getOrders().size() > 0 && setOrders){
            for(OrderDTO orderDTO: userDTO.getOrders()){
                userDTO.getOrders().add(OrderConverter.fromDTO(orderDTO));
            }
        }

        return userModel;
    }
}
