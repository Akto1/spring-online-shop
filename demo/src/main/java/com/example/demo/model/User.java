//package com.example.demo.model;
//
//import jakarta.persistence.*;
//import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//@Table(name = "users")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class User implements UserDetails  {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//@Column(nullable = false)
//    private String username;
//
//
//
//    @Column(nullable = false, unique = true)
//    private String email;
//
//    @Column(nullable = false)
//    private String password;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles = new HashSet<>();
//
//    @OneToMany(mappedBy = "user")
//    private List<Order> orders;
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() { return true; }
//    @Override
//    public boolean isAccountNonLocked() { return true; }
//    @Override
//    public boolean isCredentialsNonExpired() { return true; }
//    @Override
//    public boolean isEnabled() { return true; }
//}