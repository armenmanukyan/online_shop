package shop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import shop.dto.OrderDTO;
import shop.dto.OrderStatus;
import shop.entity.OrderEntity;
import shop.repository.OrderRepository;
import shop.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDTO> getUserOrders(Long userId) {
        return null;
    }

    @Override
    public OrderDTO changeOrderStatus(Long orderId, OrderStatus orderStatus) {
        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow(()-> new EntityNotFoundException(""));
        orderEntity.setStatus(orderStatus);

        OrderEntity storedOrder = orderRepository.saveAndFlush(orderEntity);
        return modelMapper.map(storedOrder, OrderDTO.class);
    }
}
