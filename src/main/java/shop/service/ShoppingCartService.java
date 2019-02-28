package shop.service;

import shop.dto.ProductDTO;
import shop.dto.ShoppingCartDTO;

import java.util.List;

public interface ShoppingCartService {

    List<ProductDTO> getUserCartProducts(Long userId, Long cartId);

    Integer addProductIntoCart(ProductDTO product, Long cartId);

    Integer createCart(ShoppingCartDTO shoppingCart);


}
