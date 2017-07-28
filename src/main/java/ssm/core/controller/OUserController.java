package ssm.core.controller;

import java.security.DigestException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.core.entity.OUsers;
import ssm.core.format.ResultCode;
import ssm.core.format.ResultMessage;
import ssm.core.format.Sha1;
import ssm.core.search.UserSearchParms;
import ssm.core.service.OUserService;

@Controller
@RequestMapping("/ouserAction")
public class OUserController {

    @Resource
    private OUserService oUserService;
    Logger logger = Logger.getLogger(OUserService.class);

    // private OUsers oUsers;
    /**
     * 用户查询
     * @param oUsers
     * @param req
     * @return 
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public ResultMessage userLogin(@RequestBody OUsers oUsers,
            HttpServletRequest req) {
        ResultMessage rm = new ResultMessage();
        String name = oUsers.getUsername();
        String pass = oUsers.getUserpass();
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("name", name);
        maps.put("pass", pass);
        try {
            pass = Sha1.SHA1(maps);
        } catch (DigestException e) {
            e.printStackTrace();
        }
        oUsers.setUserpass(pass);
        OUsers ousers = oUserService.getLogin(oUsers);
        logger.debug(ousers);
        if (ousers != null) {
            rm.setData(ousers);
            rm.setCode(ResultCode.SUCCESS);
            rm.setMessage("操作成功。");
        } else {
            rm.setCode(ResultCode.EXCP);
            rm.setMessage("操作失败。");
        }
        return rm;
    }

    /**
     * 所有用户列表
     * @param parms
     * @return 
     */
    @RequestMapping(value = "/userlist")
    @ResponseBody
    public ResultMessage userList(@RequestBody UserSearchParms parms) {
    	System.out.println(parms);
    	System.out.println(parms.getStartIndex());
    	System.out.println(parms.getPageSize());
        ResultMessage rm = new ResultMessage();
        UserSearchParms usp = oUserService.getUserList(parms);
        if (usp != null) {
            rm.setData(usp);
            rm.setCode(ResultCode.SUCCESS);
            rm.setMessage("操作成功。");
        } else {
            rm.setCode(ResultCode.EXCP);
            rm.setMessage("操作失败。");
        }
        return rm;
    }

}
