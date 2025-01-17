package med.voll.api.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.dto.AddressDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
    private String street;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String state;
    private String complement;
    private String number;

    public Address(AddressDTO addressDTO) {
        this.street = addressDTO.street();;
        this.neighborhood = addressDTO.neighborhood();
        this.zipcode = addressDTO.zipcode();
        this.city = addressDTO.city();
        this.state = addressDTO.state();
        this.complement = addressDTO.complement();
        this.number = addressDTO.number();

    }
}
