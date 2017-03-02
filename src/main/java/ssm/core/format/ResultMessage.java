package ssm.core.format;

public class ResultMessage {

	private String code;
	private String message;
	private Object data;
	private Object dataMap;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getDataMap() {
		return dataMap;
	}

	public void setDataMap(Object dataMap) {
		this.dataMap = dataMap;
	}

}
