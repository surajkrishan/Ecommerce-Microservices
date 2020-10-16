package com.meru.offerservice.model;

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
@Document(collection = "Offer")
public class Offer {
	@Id
	private String promoCode;
	@Indexed(unique = true)
	private String offerName;
	private int discount;
	private String offerServicePort;
}
