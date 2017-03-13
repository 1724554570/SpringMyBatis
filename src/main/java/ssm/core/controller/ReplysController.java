package ssm.core.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.core.entity.ArticleReply;
import ssm.core.format.ResultCode;
import ssm.core.format.ResultMessage;
import ssm.core.service.ReplyService;

@Controller
@RequestMapping("/replysAction")
public class ReplysController {

	@Resource
	private ReplyService replyService;

	@RequestMapping("/saveOneReply")
	@ResponseBody
	public ResultMessage insertOneReply(@RequestBody ArticleReply articleReply,
			HttpServletRequest req) {
		ResultMessage rm = new ResultMessage();
		long times = (long) Math.floor(System.currentTimeMillis() / 1000);
		String addTimes = Long.toString(times);
		articleReply.setAddTime(addTimes);
		articleReply.setState(true);
		int insertId = replyService.insertReplys(articleReply);
		if (insertId > 0) {
			rm.setCode(ResultCode.SUCCESS);
			rm.setData(insertId);
			rm.setMessage("操作成功。");
		} else {
			rm.setCode(ResultCode.EXCP);
			rm.setMessage("操作失败。");
		}
		return rm;
	}

}
