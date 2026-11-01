package datasource.mapper;

import datasource.model.UserEntity;
import domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toEntity(User domain) {
        return new UserEntity(domain.id(), domain.login(), domain.password());
    }

    public User toDomain(UserEntity entity) {
        return new User(entity.getId(), entity.getLogin(), entity.getPassword());
    }
}
