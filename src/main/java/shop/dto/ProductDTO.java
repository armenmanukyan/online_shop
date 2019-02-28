package shop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ProductDTO {
    private String name;
    private String type;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long countInStock;

    private Double price;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date addedDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date updatedDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCountInStock() {
        return countInStock;
    }

    public void setCountInStock(Long countInStock) {
        this.countInStock = countInStock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
