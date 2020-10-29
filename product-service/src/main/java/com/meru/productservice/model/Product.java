package com.meru.productservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Model Class for Product")
@Document(collection = "Product")
public class Product {
    @ApiModelProperty(notes = "Auto Generated product unique id", required = false, position = 1)
    @Id
    private String productId;
    @ApiModelProperty(notes = "Product Name", example = "Oneplus 8T", required = true, position = 2)
    private String productName;
    @ApiModelProperty(notes = "Product price", example = "10", required = true, position = 3)
    private BigDecimal price;
    @ApiModelProperty(notes = "Product-Service Port", example = "8081", required = false, position = 3)
    private String productServicePort;
    @ApiModelProperty(notes = "Auto Generated promocode unique id", required = false, position = 1)
    private String promoCode;
    @ApiModelProperty(notes = "Offer Name", example = "Diwali Offer", required = true, position = 2)
    private String offerName;
    @ApiModelProperty(notes = "Offer Discount Percentage", example = "10", required = true, position = 3)
    private BigDecimal discount;
    @ApiModelProperty(notes = "Offer-Service Port", example = "8080", required = false, position = 3)
    private String offerServicePort;
}
