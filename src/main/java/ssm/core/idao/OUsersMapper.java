package ssm.core.idao;

import java.util.List;

import ssm.core.entity.OUsers;
import ssm.core.search.UserSearchParms;

public interface OUsersMapper {

	// int deleteByPrimaryKey(Integer id);
	//
	// int insert(OUsers record);
	/**
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(OUsers record);

	//
	// OUsers selectByPrimaryKey(Integer id);
	//
	// int updateByPrimaryKeySelective(OUsers record);
	//
	// int updateByPrimaryKey(OUsers record);
	/**
	 * 查询单一用户
	 *
	 * @param oUsers
	 * @return
	 */
	public OUsers selectLogin(OUsers oUsers);

	/**
	 * 查询用户集合
	 *
	 * @param parms
	 * @return
	 */
	public List<OUsers> selectUserList(UserSearchParms parms);

	/**
	 * 查询用户总数
	 *
	 * @param parms
	 * @return
	 */
	public UserSearchParms selectUserCount(UserSearchParms parms);
}
