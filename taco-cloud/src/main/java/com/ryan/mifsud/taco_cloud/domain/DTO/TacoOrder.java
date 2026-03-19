package com.ryan.mifsud.taco_cloud.domain.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Table("TACO_ORDER")
public class TacoOrder  implements Serializable{

    @Id
    private long id;

    @NotBlank(message="Delivery name is required")
    private String deliveryName;

    @NotBlank(message="Street is required")
    private String deliveryStreet;

    @NotBlank(message="City is required")
    private String deliveryCity;   

    @NotBlank(message="State is required")
    private String deliveryState;

    @NotBlank(message="Zip code is required")
    private String deliveryZip;

    @CreditCardNumber(message="Not a valid credit card number")
    @NotBlank(message="Credit card number is required")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message="Must be formatted MM/YY")
    @NotBlank(message="Expiration date is required")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    @NotBlank(message="CVV is required")
    private String ccCVV;

    @NotEmpty(message="You must order at least 1 taco")
    private List<Taco> tacos;

    private Date placedAt = new Date();


    public void addTaco(Taco taco) {
        if(tacos == null) {
            tacos = new java.util.ArrayList<>();
        }
        this.tacos.add(taco);
    }
}
