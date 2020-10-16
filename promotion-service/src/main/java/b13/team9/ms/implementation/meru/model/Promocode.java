package b13.team9.ms.implementation.meru.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "Promocode")
public class Promocode {

    @Id
    private String promoCode;
    @Indexed(unique = true)
    private String offerName;
    private int discountRate;
}
