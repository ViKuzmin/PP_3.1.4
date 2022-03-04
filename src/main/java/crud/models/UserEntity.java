package crud.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   @Column
   private String name;
   @Column
   private String profession;
   @Column
   private byte age;
   @Column
   private String email;
}
