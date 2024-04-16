package com.itlin.auth.application.convent;

import com.itlin.auth.application.dto.AuthUserDto;
import com.itlin.auth.domain.bo.AuthUserBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConventToBo {

    UserConventToBo QUERY = Mappers.getMapper(UserConventToBo.class);

    AuthUserBo convertToBo(AuthUserDto authUserDto);


}
