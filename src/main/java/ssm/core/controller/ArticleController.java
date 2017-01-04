package ssm.core.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.core.format.ResultCode;
import ssm.core.entity.Article;
import ssm.core.format.ResultMessage;
import ssm.core.mapper.ArticleMapper;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Resource
	private ArticleMapper articleMapper;

	@RequestMapping("/getArticleList")
	@ResponseBody
	public ResultMessage getList() {
		ResultMessage rm = new ResultMessage();
		List<Article> articles = articleMapper.selAllList();
		rm.setCode(ResultCode.SUCCESS);
		rm.setMessage("查询成功。");
		rm.setData(articles);
		return rm;
	}

}
