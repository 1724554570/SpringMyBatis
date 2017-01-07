package ssm.core.controller;

import java.security.DigestException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.core.format.ResultMessage;
import ssm.core.format.Sha1;
import ssm.core.idao.OUsersMapper;

@Controller
@RequestMapping("ouser")
public class OUserController {
	@Resource
	private OUsersMapper mapper;

	@RequestMapping("/login")
	@ResponseBody
	public ResultMessage userLogin(HttpServletRequest req) {
		ResultMessage rm = new ResultMessage();
		String name = req.getParameter("username");
		String pass = req.getParameter("userpass");
		System.out.println(name);
		System.out.println(pass);
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("name", name);
		maps.put("pass", pass);
		try {
			pass =  Sha1.SHA1(maps);
		} catch (DigestException e) {
			e.printStackTrace();
		}
		System.out.println(pass+"::===");
		return rm;
	}

}
