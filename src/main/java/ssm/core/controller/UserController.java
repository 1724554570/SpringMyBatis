package ssm.core.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ssm.core.entity.Users;
import ssm.core.service.UsersService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UsersService service;

    @RequestMapping("/getById")
    public String getSimpleUser(HttpServletRequest req, Model model) {
        int userId = Integer.parseInt(req.getParameter("id"));
        Users users = service.getUserById(userId);
        model.addAttribute("user", users);
        return "showUser";
    }
}
