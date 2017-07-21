package ssm.core.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssm.core.entity.OUsers;
import ssm.core.idao.OUsersMapper;
import ssm.core.search.UserSearchParms;
import ssm.core.service.OUserService;

@Service("oUser")
public class OUserServiceImpl implements OUserService {

	@Resource
	private OUsersMapper oUsersMapper;

	/**
	 * 获取登录
	 */
	public OUsers getLogin(OUsers oUsers) {
		// TODO Auto-generated method stub
		OUsers us = oUsersMapper.selectLogin(oUsers);
		return us;
	}

	/**
	 * 获取用户集合
	 */
	public UserSearchParms getUserList(UserSearchParms parms) {
		// TODO Auto-generated method stub
		List<OUsers> list = oUsersMapper.selectUserList(parms);
		/*
		 * for (int i = 0; i < list.size(); i++) {
		 * System.out.println(list.get(i)); } Iterator<OUsers> it =
		 * list.iterator(); while (it.hasNext()) {
		 * System.out.println(it.next()); }
		 */
		UserSearchParms parms2 = oUsersMapper.selectUserCount(parms);
		parms.setoUsers(list);
		parms.setTotalSize(parms2.getTotalSize());
		return parms;
	}

	/**
	 * 写入注册信息
	 */
	public int insertRegister(OUsers oUsers) {
		int number = oUsersMapper.insertSelective(oUsers);
		System.out.println(number);
		return number;
	}
}
