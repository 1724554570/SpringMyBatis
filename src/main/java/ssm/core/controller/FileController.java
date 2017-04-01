package ssm.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.core.format.ResultCode;
import ssm.core.format.ResultMessage;

@Controller
@RequestMapping("/fileAction")
public class FileController {

	@RequestMapping("/fileupload")
	@ResponseBody
	public ResultMessage getList() {
		ResultMessage rm = new ResultMessage();
		rm.setCode(ResultCode.SUCCESS);
		rm.setMessage("查询成功。");
		rm.setData("上传成功");
		return rm;
	}
}
