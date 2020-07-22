package model;

public class ReturnResult {
	//用来包装解析客户端协议的结果的两个属性
	private String head;
	private Object resultData;

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public Object getResultData() {
		return resultData;
	}

	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}
}
