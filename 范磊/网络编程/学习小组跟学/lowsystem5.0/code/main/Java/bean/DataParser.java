package bean;

import transmissionProtocol.ResponseMsg;
import transmissionProtocol.ResponseType;

public class DataParser {

    String[] clientResponse;

    ResponseType responseType;

    // 解析获取的数据类型，并返回值，用于判断
    public ResponseMsg parser(String clientStrs) {

        clientResponse = clientStrs.split("/n");
        String head = clientResponse[0];
        String Response = clientResponse[1];
        ResponseMsg responseMsg = null;
        if (head.equals("add")) {
            responseMsg = new ResponseMsg(head, Response);
            // 调用消息体解析方法，并且赋值给people，parseAdd()

        } else if (head.equals("delete")) {
            responseMsg = new ResponseMsg(head, Response);

        } else if (head.equals("change")) {
            responseMsg = new ResponseMsg(head, Response);

        } else if (head.equals("search")) {
            responseMsg = new ResponseMsg(head, Response);

        }

        return responseMsg;

    }

    // 进一步解析Response里面的数据，并返回给执行层
    public People parserAdd(String msg) {
        String[] strings = msg.split(",");
        String name = strings[0];
        int id = Integer.parseInt(strings[1]);
        String school = strings[2];
        People people = new People(name, id, school);
        return people;
    }


    public int parserDelete(int msg) {
        int id = msg;
        return id;
    }

    public People parserChange(String msg) {
        System.out.println(msg);
        String[] strings = msg.split(",");
        String name = strings[0];
        int id = Integer.parseInt(strings[1]);
        String school = strings[2];
        People people = new People(name, id, school);
        return people;
    }

    public String parserSearch(String msg) {
        return msg;
    }


}
