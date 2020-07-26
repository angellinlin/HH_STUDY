package bean;

/**
 * @author sy
 * @date 2020/7/26 17:11
 * 封装数据库操作结果
 */
public class OperaResult {

    public String isSuccess;
    public  String onFail;
    public Object operaData;

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getOnFail() {
        return onFail;
    }

    public void setOnFail(String onFail) {
        this.onFail = onFail;
    }

    public Object getOperaData() {
        return operaData;
    }

    public void setOperaData(Object operaData) {
        this.operaData = operaData;
    }
}
