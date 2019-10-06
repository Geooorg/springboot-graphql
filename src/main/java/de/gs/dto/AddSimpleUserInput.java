package de.gs.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSimpleUserInput {

    private String name;
    private String address;
}
