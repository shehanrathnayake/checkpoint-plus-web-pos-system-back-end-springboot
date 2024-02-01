package com.shehanrathnayake.service.util;

import com.shehanrathnayake.converter.IdConverter;
import com.shehanrathnayake.converter.UserPropertiesConverter;
import com.shehanrathnayake.entity.User;
import com.shehanrathnayake.to.UserTO;
import com.shehanrathnayake.util.UserRole;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserTransformer {
    private final ModelMapper mapper;
    private final IdConverter idConverter;

    public UserTransformer(ModelMapper mapper, IdConverter idConverter, IdConverter idConverter1, UserPropertiesConverter userPropertiesConverter) {
        this.mapper = mapper;
        this.idConverter = idConverter1;

        mapper.typeMap(String.class, Integer.class)
                .setConverter(ctx -> (ctx.getSource() != null) ? idConverter.convertUserIdToInt(ctx.getSource()) : null);

        mapper.typeMap(Integer.class, String.class)
                .setConverter(ctx -> idConverter.convertIntToUserId(ctx.getSource()));

        mapper.typeMap(UserRole.class, String.class)
                .setConverter(ctx -> ctx.getSource().getRole());
        mapper.typeMap(String.class, UserRole.class)
                .setConverter(ctx -> userPropertiesConverter.convert(ctx.getSource()));
    }

    public User fromUserTO(UserTO userTO) {
        return mapper.map(userTO, User.class);
    }
    public UserTO toUserTO(User user) {
        return mapper.map(user, UserTO.class);
    }
    public List<UserTO> toUserTOList(List<User> userList) {
        return userList.stream().map(this::toUserTO).collect(Collectors.toList());
    }

    public org.springframework.security.core.userdetails.User FromUserToUserDetails(User user) {
        Collection<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRoles()));
        return new org.springframework.security.core.userdetails.User(idConverter.convertIntToUserId(user.getId()), user.getPassword(), authorities);
    }
}