package b13.team9.ms.implementation.meru.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "Promotion")
public class Promotion {
    @Id
    private String promoCode;
    private String productId;
    private String promotionServicePort;
}
