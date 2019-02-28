package shop.service;

import shop.dto.ProductDTO;
import shop.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    /**
     * Creates specific product with given id
     *
     * @param product
     * @return
     */
    ProductDTO createProduct(ProductEntity product);

    /**
     * Updates specific product with given id
     *
     * @param product
     * @return
     */
    ProductDTO updateProduct(ProductEntity product);

    /**
     * Deletes specific product with given id
     *
     * @param productId
     * @return
     */
    Long deleteProduct(Long productId);

    /**
     * Gets all products from store
     *
     * @return
     */
    List<ProductDTO> getAllProducts();
}
