package crud.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Data
@Entity
@Table(name = "t_user")
public class User implements UserDetails {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column
   @Size(min = 2, message = "Не меньше 5 знаков")
   private String username;
   @Column
   @Size(min = 2, message = "Не меньше 5 знаков")
   private String password;
   @Column
   private boolean active;
   @Transient
   private String passwordConfirm;
   @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   private Set<Role> roles;

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return null;
   }

   @Override
   public boolean isAccountNonExpired() {
      return false;
   }

   @Override
   public boolean isAccountNonLocked() {
      return false;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return false;
   }

   @Override
   public boolean isEnabled() {
      return false;
   }
}
