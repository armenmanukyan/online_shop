package shop.controller;

import io.swagger.annotations.*;
import shop.dto.ProductDTO;
import shop.entity.ProductEntity;
import shop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Api(tags = "products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Creates new product")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 422, message = "Invalid product data supplied")})
    public ResponseEntity createProduct(@ApiParam("Shop product") @RequestBody ProductDTO product) {

        return ResponseEntity.ok(productService.createProduct(modelMapper.map(product, ProductEntity.class)));
    }


    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Updates product with given data")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 422, message = "Invalid product data supplied")})
    public ResponseEntity updateProduct(@ApiParam("Store product") @RequestBody ProductDTO product) {
        return ResponseEntity.ok(productService.updateProduct(modelMapper.map(product, ProductEntity.class)));
    }

    @PutMapping("/list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Retrieves all existing products")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 422, message = "Invalid product data supplied")})
    public ResponseEntity retrieveProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }


    @DeleteMapping("/delete/{productId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Deletes product with given id")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 422, message = "Invalid product data supplied")})
    public ResponseEntity deleteProduct(@ApiParam("Store product") @PathVariable Long productId) {
        return ResponseEntity.ok(productService.deleteProduct(productId));
    }
}
