package ssm.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import ssm.core.format.ParamToJson;
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

	@RequestMapping("/getReactFramework")
	@ResponseBody
	public String getReactFrameWork7(HttpServletRequest req, String callback) {
		ResultMessage rm = new ResultMessage();
		JSONObject jsonObject = ParamToJson.loadElementTojson(req);
		rm.setCode(ResultCode.SUCCESS);
		rm.setMessage("查询成功。");
		rm.setData(jsonObject);
		String json = JSONObject.toJSONString(rm);
		String res = null;
		if (callback != null) {
			res = callback + "(" + json + ")";
		} else {
			res = json;
		}
		System.out.println(res);
		return res;
	}
}
