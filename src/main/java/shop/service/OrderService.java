package shop.service;

import shop.dto.OrderDTO;
import shop.dto.OrderStatus;

import java.util.List;


public interface OrderService {

    /**
     * Retrievs specific user orders
     *
     * @param userId
     * @return
     */
    List<OrderDTO> getUserOrders(Long userId);

    /**
     * Changes order status wit given id
     *
     * @param orderId
     * @param orderStatus
     * @return
     */
    OrderDTO changeOrderStatus(Long orderId, OrderStatus orderStatus);
}
