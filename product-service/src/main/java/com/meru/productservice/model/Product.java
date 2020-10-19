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
    @Indexed(unique = true)
    private String productName;
    @ApiModelProperty(notes = "Product price", example = "10", required = true, position = 3)
    private Integer price;
    @ApiModelProperty(notes = "Product-Service Port", example = "8081", required = false, position = 3)
    private String productServicePort;
}
