package crud.models;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    //Добавление ролей и назначение роли админа
    /*

    INSERT INTO user.role(id, name)
    VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

    INSERT INTO user.t_user_roles(user_id, roles_id)
    VALUES (1, 2);
    */
    @Id
    private Long id;
    @Column
    private String name;
    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public Role(Long id) {
        this.id = id;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }

    @Override
    public String toString() {
        return name.replace("ROLE_", "");
    }
}
