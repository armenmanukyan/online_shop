package shop.repository;

import org.springframework.stereotype.Repository;
import shop.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
}
