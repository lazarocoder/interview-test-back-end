package com.projuris.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientDTO {

    private String name;
    private String address;
    private String phone;
    private String email;

    public ClientDTO() {

        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

}
