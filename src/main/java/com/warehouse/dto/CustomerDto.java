package com.warehouse.dto;

import lombok.*;
//import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Setter
@Getter
public class CustomerDto{ //extends RepresentationModel<CustomerDto> {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String address;
}