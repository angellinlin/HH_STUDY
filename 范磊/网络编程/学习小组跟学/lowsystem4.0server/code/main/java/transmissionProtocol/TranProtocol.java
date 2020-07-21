package transmissionProtocol;

public class TranProtocol {

    // 构建不同操作的数据帧格式 head+message
    public String addMessage(ResponseType responseType) {
        String addMsg;
        String success = responseType.successMsg;
        if (success.equals("success")) {
            addMsg = success + "/n";
        } else {
            addMsg = responseType.failMsg + "/n" + responseType.failReason;

        }
        return addMsg;   // 返回值应该与实际数据相结合
    }

   /* public String deleteMessage(ResponseType responseType) {
        String deMsg;
        String success = responseType.successMsg;
        if (success.equals("success")) {
            deMsg = success + "/n";
        } else {
            deMsg = responseType.failMsg + "/n" + responseType.failReason;

        }
        return deMsg;
    }

    public String deleteMessage(ResponseType responseType) {
        String deMsg;
        String success = responseType.successMsg;
        if (success.equals("success")) {
            deMsg = success + "/n";
        } else {
            deMsg = responseType.failMsg + "/n" + responseType.failReason;

        }
        return deMsg;
    }*/
}
