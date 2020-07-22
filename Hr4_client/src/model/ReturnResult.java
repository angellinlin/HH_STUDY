package model;

import java.util.ArrayList;

public class ReturnResult {
	//装返回的结果三个属性
	private boolean isSuccess;
	private String failReason;
	private Object resultData;

	public boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	public Object getResultData() {
		return resultData;
	}

	public void setResultData(ArrayList<Resume> resultData) {
		this.resultData = resultData;
	}

}
