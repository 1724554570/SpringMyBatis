package ssm.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssm.core.entity.OUsers;
import ssm.core.idao.OUsersMapper;

@Service("oUser")
public class OUserServiceImpl {
	@Resource
	private OUsersMapper oUsersMapper;

	public OUsers logins(OUsers oUsers) {
		OUsers us = oUsersMapper.selectLogin(oUsers);
		return us;
	}
}
