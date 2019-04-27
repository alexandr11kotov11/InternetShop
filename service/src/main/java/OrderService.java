import com.kotov.modelDTO.OrderDTO;
import com.kotov.modelDTO.UserDTO;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.List;

public interface OrderService  {

    OrderDTO generateOrder (UserDTO user);

    @Transactional
    Long addNewOrder(OrderDTO orderDTO);

    @Transactional
    OrderDTO getById(Long id);

    BigDecimal getTotalPrice(OrderDTO order);

   // @Transactional
    //void updateOrderStatus(Long id, OrderStatus status);

    @Transactional(readOnly = true)
    List<OrderDTO> getCurrentUserOrders();

    @Transactional(readOnly = true)
    List<OrderDTO> getAll();

    @Transactional(readOnly = true)
    List<OrderDTO> getAll(SortOrder sortOrder);

    @Transactional(readOnly = true)
    boolean isCurrentUserOrderOwner(Long orderId);

    @Transactional
    void deleteOrder(Long orderId);

}
