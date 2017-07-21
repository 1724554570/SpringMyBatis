package ssm.core.service;

import ssm.core.entity.OUsers;
import ssm.core.search.UserSearchParms;

public interface OUserService {

    /**
     * 登录查询
     *
     * @param oUsers
     * @return
     */
    public OUsers getLogin(OUsers oUsers);
    
    /**
     *  注册信息
     * @param oUsers
     * @return
     */
    public int insertRegister(OUsers oUsers);

    /**
     * 用户集合
     *
     * @param parms
     * @return
     */
    public UserSearchParms getUserList(UserSearchParms parms);

}
