package com.cybersoft.demosrpingboot.entity;

import com.cybersoft.demosrpingboot.common.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.collection.spi.PersistentSet;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;


@Entity(name="users")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Users extends BaseEntity implements UserDetails {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String username;
    @Column(name = "full_name")
    private String fullName;
    @JsonIgnore
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Roles> roles = new PersistentSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<RatingFood> ratingFoods;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<RatingRestaurant> ratingRestaurants;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Orders> orders;

    public void setRoleToUser(Roles roles){
        this.roles.add(roles);
        roles.getUsers().add(this);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(roles1 -> new SimpleGrantedAuthority(roles1.getRoleName())).collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
