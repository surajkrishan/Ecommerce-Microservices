package com.meru.offerservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@ApiModel(description = "Model Class for Offer")
@Document(collection = "Offer")
public class Offer {
    @ApiModelProperty(notes = "Auto Generated promocode unique id", required = false, position = 1)
    @Id
    private String promoCode;
    @ApiModelProperty(notes = "Offer Name", example = "Diwali Offer", required = true, position = 2)
    private String offerName;
    @ApiModelProperty(notes = "Offer Discount Percentage", example = "10", required = true, position = 3)
    private BigDecimal discount;
    @ApiModelProperty(notes = "Offer-Service Port", example = "8080", required = false, position = 3)
    private String offerServicePort;
}
