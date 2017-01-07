package ssm.core.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ssm.core.entity.Users;
import ssm.core.idao.UsersMapper;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UsersMapper usersMapper;

	@RequestMapping("/getById")
	public String getSimpleUser(HttpServletRequest req, Model model) {
		int userId = Integer.parseInt(req.getParameter("id"));
		Users users = usersMapper.selectByPrimaryKey(userId);
		model.addAttribute("user", users);
		return "showUser";
	}
}
