import domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public class UserMapper {

        UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

        //@Mapping()
        User UserCommandToUser(User user);




}
