package ssm.core.service.impl;

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
        UserSearchParms parms2 = oUsersMapper.selectUserCount(parms);
        parms.setoUsers(list);
        parms.setTotalSize(parms2.getTotalSize());
        return parms;
    }

}
