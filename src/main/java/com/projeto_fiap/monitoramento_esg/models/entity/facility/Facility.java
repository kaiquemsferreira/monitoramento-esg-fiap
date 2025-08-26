package com.projeto_fiap.monitoramento_esg.models.entity.facility;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Document(collection = "facilities")
public class Facility {
    @Id
    private String id;
    private String name;
    private Address address;
    private GeoJsonPoint location;
    private EsgGoals esgGoals;
    private List<String> certifications;
    private List<Contact> contacts;
}
