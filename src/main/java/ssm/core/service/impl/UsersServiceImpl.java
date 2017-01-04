package ssm.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssm.core.entity.Users;
import ssm.core.mapper.UsersMapper;
import ssm.core.service.UsersService;

@Service("userService")
public class UsersServiceImpl implements UsersService {
	@Resource
	private UsersMapper usersMapper;

	public UsersMapper getUsersMapper() {
		return usersMapper;
	}

	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}

	public Users getUserById(int userid) {
		System.out.println(userid);
		return usersMapper.selectByPrimaryKey(userid);
	}
}
