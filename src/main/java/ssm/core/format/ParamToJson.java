package ssm.core.format;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

public class ParamToJson {

	public static JSONObject loadElementTojson(HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		Enumeration<String> paramNames = req.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String[] paramValues = req.getParameterValues(paramName);
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (paramValue.length() != 0) {
					System.out.println(paramName + "=" + paramValue);
					jsonObject.put(paramName, paramValue);
				}
			}
		}
		return jsonObject;
	}

}
