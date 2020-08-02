package transmissionProtocol;

public class ResponseMsg {


    private String head;

    private String responseMsg;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public ResponseMsg(String head, String responseMsg) {
        this.head = head;
        this.responseMsg = responseMsg;
    }

}
