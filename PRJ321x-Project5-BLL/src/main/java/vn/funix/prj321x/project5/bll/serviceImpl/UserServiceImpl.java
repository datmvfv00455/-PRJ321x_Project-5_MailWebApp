package vn.funix.prj321x.project5.bll.serviceImpl;

import java.util.List;

import vn.funix.prj321x.project5.bll.service.UserService;
import vn.funix.prj321x.project5.core.dto.UserDto;
import vn.funix.prj321x.project5.core.utils.ValidationUtil;
import vn.funix.prj321x.project5.dal.dao.UserDao;
import vn.funix.prj321x.project5.dal.utils.DaoUtil;

public class UserServiceImpl implements UserService {

    public boolean authenticate(UserDto userDto) {
        boolean authenticate = false;
        if (validateUser(userDto)) {
            UserDao userDao = DaoUtil.getUserDaoInstance();
            authenticate = userDao.authenticate(userDto);
        }
        return authenticate;
    }

    public boolean validateUser(UserDto userDto) {
        String username = userDto.getUserName();
        String password = userDto.getUserPassword();

        return ValidationUtil.validateUsername(username)
                && ValidationUtil.validatePassword(password);
    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }

    @Override
    public void update(UserDto dto) {

    }

    @Override
    public void save(UserDto dto) {

    }

    @Override
    public UserDto findById(Integer id) {
        return null;
    }

}
