package transmissionProtocol;

public class TranProtocol {


    // 数据接收回复协议
    ResponseType responseType=new ResponseType();
    // 构建不同操作的数据帧格式 head+message
    public String addMessage() {
        String addMsg;
        String success = responseType.successMsg;
        if (success.equals("success")) {
            addMsg = success + "/n"+"add";
        } else {
            addMsg = responseType.failMsg + "/n";

        }
        return addMsg;   // 返回值应该与实际数据相结合
    }

    public String deleteMessage() {
        String deMsg;
        String success = responseType.successMsg;
        if (success.equals("success")) {
            deMsg = success + "/n"+"delete";
        } else {
            deMsg = responseType.failMsg + "/n";

        }
        return deMsg;
    }

    public String changeMessage() {
        String changeMsg;
        String success = responseType.successMsg;
        if (success.equals("success")) {
            changeMsg = success + "/n"+"change";
        } else {
            changeMsg = responseType.failMsg + "/n";

        }
        return changeMsg;
    }

    public String searchMessage() {
        String searchMsg;
        String success = responseType.successMsg;
        if (success.equals("success")) {
            searchMsg = success + "/n";
        } else {
            searchMsg = responseType.failMsg + "/n";

        }
        return searchMsg;
    }
}
