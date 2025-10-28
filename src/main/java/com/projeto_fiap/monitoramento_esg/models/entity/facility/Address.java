package com.projeto_fiap.monitoramento_esg.models.entity.facility;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class Address {
    private String city;
    private String state;
    private String street;
    private String zip;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static Address fromString(String raw) {
        Address a = new Address();
        if (raw != null) {
            String[] p = raw.split(",");
            if (p.length > 0) a.setStreet(p[0].trim());
            if (p.length > 1) a.setCity(p[1].trim());
            if (p.length > 2) a.setState(p[2].trim());
            if (p.length > 3) a.setZip(p[3].trim());
        }
        return a;
    }
}
