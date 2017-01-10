package ssm.core.controller;

import java.security.DigestException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
@RequestMapping("ouser")
public class OUserController {

    @Resource
    private OUserService oUserService;

    // private OUsers oUsers;
    /**
     * 用户查询
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public ResultMessage userLogin(HttpServletRequest req) {
        ResultMessage rm = new ResultMessage();
        String name = req.getParameter("username");
        String pass = req.getParameter("userpass");
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("name", name);
        maps.put("pass", pass);
        try {
            pass = Sha1.SHA1(maps);
        } catch (DigestException e) {
            e.printStackTrace();
        }
        OUsers oUsers = new OUsers();
        oUsers.setUsername(name);
        oUsers.setUserpass(pass);
        oUsers = oUserService.getLogin(oUsers);
        if (oUsers != null) {
            rm.setData(oUsers);
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
     *
     * @param req
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
        rm.setCode(ResultCode.SUCCESS);
        rm.setData(usp);
        rm.setMessage("操作成功。");
        return rm;
    }

}
