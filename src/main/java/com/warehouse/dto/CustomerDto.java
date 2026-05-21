package com.warehouse.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Setter
@Getter 
public class CustomerDto {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String address;
}
