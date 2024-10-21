package com.nerlin.usermanagementservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    // Definisci una relazione ManyToMany con la tabella Role
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles", // Nome della tabella di join
        joinColumns = @JoinColumn(name = "user_id"), // Colonna user_id per la tabella User
        inverseJoinColumns = @JoinColumn(name = "role_id") // Colonna role_id per la tabella Role
    )
    private List<Role> roles; // Usa l'entità Role invece di String

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; // Dovresti implementare questo metodo per ritornare le authorities
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
