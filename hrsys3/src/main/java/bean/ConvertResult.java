package bean;

/**
 * @author sy
 * @date 2020/7/26 17:08
 * 封装客户端协结果
 */
public class ConvertResult {
    private String head;
    private Object convertData;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Object getConvertData() {
        return convertData;
    }

    public void setConvertData(Object convertData) {
        this.convertData = convertData;
    }
}
