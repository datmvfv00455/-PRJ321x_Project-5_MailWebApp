package vn.funix.prj321x.project5.bll.service;

import vn.funix.prj321x.project5.core.dto.UserDto;

public interface UserService extends GenericService<UserDto> {

    public boolean authenticate(UserDto userDto);

}
