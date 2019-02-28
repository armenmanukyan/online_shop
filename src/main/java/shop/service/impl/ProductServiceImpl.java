package shop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import shop.dto.ProductDTO;
import shop.entity.ProductEntity;
import shop.repository.ProductRepository;
import shop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO createProduct(ProductEntity product) {

        ProductEntity productEntity = productRepository.saveAndFlush(product);
        return modelMapper.map(productEntity, ProductDTO.class);
    }

    @Override
    public ProductDTO updateProduct(ProductEntity product) {
        ProductEntity productEntity = productRepository.saveAndFlush(product);
        return modelMapper.map(productEntity, ProductDTO.class);
    }

    @Override
    public Long deleteProduct(Long productId) {
        productRepository.deleteById(productId);
        return productId;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(e -> modelMapper.map(e, ProductDTO.class))
                .collect(Collectors.toList());
    }

}
