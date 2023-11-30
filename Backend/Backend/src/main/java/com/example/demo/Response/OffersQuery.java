package com.example.demo.Response;

import com.example.demo.Entities.Placement;
import com.example.demo.Entities.Placement_Filter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class OffersQuery {
    private String organization;
    private String profile;
    private String description;
    private int intake;
    private int placement_id;
    public OffersQuery(String organization, String profile, String description, int intake, int placement_id){
        this.organization = organization;
        this.profile = profile;
        this.description = description;
        this.intake = intake;
        this.placement_id = placement_id;
    }
}
