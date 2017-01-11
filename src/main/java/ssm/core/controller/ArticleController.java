package ssm.core.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.core.format.ResultCode;
import ssm.core.entity.Article;
import ssm.core.format.ResultMessage;
import ssm.core.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Resource
	private ArticleService articleService;

	@RequestMapping("/getArticleList")
	@ResponseBody
	public ResultMessage getList() {
		ResultMessage rm = new ResultMessage();
		List<Article> articles = articleService.getArticleList();
		if (articles != null) {
			rm.setCode(ResultCode.SUCCESS);
			rm.setMessage("查询成功。");
			rm.setData(articles);
		} else {
			rm.setCode(ResultCode.EXCP);
			rm.setMessage("查询失败。");
			rm.setData(articles);
		}
		return rm;
	}

}
