package crud.models;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RoleConverter implements Converter<String, Role> {

    @Override
    public Role convert(String id) {

        int parsedId = Integer.parseInt(id);
        List<Role> list = Arrays.asList(
          new Role(1L, "ROLE_USER"),
          new Role(2L, "ROLE_Admin")
        );
        int index = parsedId - 1;
        return list.get(index);
    }
}
