package com.cybersoft.demosrpingboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_details")
public class UserDetails {
    @Id
    @Column(name = "user_id")
    private int id;
    private String gender;
    private String address;

    @Column(name = "id_card")
    private String idCard;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private Users user;
}
