package com.projeto_fiap.monitoramento_esg.models.dto.facility;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.projeto_fiap.monitoramento_esg.models.entity.facility.Address;
import com.projeto_fiap.monitoramento_esg.models.entity.facility.Contact;
import com.projeto_fiap.monitoramento_esg.models.entity.facility.EsgGoals;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FacilityDTO {
    private String id;
    private String name;
    private Address address;
    private GeoJsonPoint location;
    private EsgGoals esgGoals;
    private List<String> certifications;
    private List<Contact> contacts;

    @JsonSetter("address")
    public void setAddressFlexible(Object value) {
        switch (value) {
            case null -> this.address = null;
            case String s -> this.address = Address.fromString(s);
            case Map<?, ?> m -> {
                Address a = new Address();
                a.setStreet(Objects.toString(m.get("street"), null));
                a.setCity(Objects.toString(m.get("city"), null));
                a.setState(Objects.toString(m.get("state"), null));
                a.setZip(Objects.toString(m.get("zip"), null));
                this.address = a;
            }
            default -> {
                //
            }
        }
    }
}
