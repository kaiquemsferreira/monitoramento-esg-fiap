package com.projeto_fiap.monitoramento_esg.models.dto.facility;

import com.projeto_fiap.monitoramento_esg.models.entity.facility.Address;
import com.projeto_fiap.monitoramento_esg.models.entity.facility.Contact;
import com.projeto_fiap.monitoramento_esg.models.entity.facility.EsgGoals;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.util.List;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class FacilityDTO {
    private String id;
    private String name;
    private Address address;
    private GeoJsonPoint location;
    private EsgGoals esgGoals;
    private List<String> certifications;
    private List<Contact> contacts;
}
