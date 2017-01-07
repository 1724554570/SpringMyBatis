package ssm.core.idao;

import ssm.core.entity.OUsers;

public interface OUsersMapper {

	// int deleteByPrimaryKey(Integer id);
	//
	// int insert(OUsers record);
	//
	// int insertSelective(OUsers record);
	//
	// OUsers selectByPrimaryKey(Integer id);
	//
	// int updateByPrimaryKeySelective(OUsers record);
	//
	// int updateByPrimaryKey(OUsers record);

	public OUsers selectLogin(OUsers oUsers);
}
