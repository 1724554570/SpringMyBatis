package ssm.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssm.core.entity.Users;
import ssm.core.idao.UsersMapper;
import ssm.core.service.UsersService;

@Service("userService")
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    public Users getUserById(int userid) {
        return usersMapper.selectByPrimaryKey(userid);
    }
}
