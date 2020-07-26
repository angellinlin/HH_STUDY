package utils;

import bean.ConvertResult;
import bean.Jhunter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sy
 * @date 2020/7/26 17:06
 * 数据转换
 */
public class DataConvert {

    static String[] messages;
    static String head;
    static ConvertResult convertResult;
    static String message;

    public DataConvert() {
    }


    /**
     * 转换  以/n 分开操作指令和数据
     * @param str
     * @return
     */
    public ConvertResult convert(String str) {

        messages = str.split("/n");
        head = messages[0];
        message = messages[1];
        convertResult = new ConvertResult();
        convertResult.setHead(head);
        switch (head){
            case "add":
                List<Jhunter> addList =  convertAdd(message);
                convertResult.setConvertData(addList);
                break;
            case "delete":
                List<Jhunter> delList =  convertDel(message);
                convertResult.setConvertData(delList);
                break;
            case "update":
                List<Jhunter> updateList =  convertUpdate(message);
                convertResult.setConvertData(updateList);
                break;
            case "searchByName":
                List<Jhunter> seaList =  convertSearchByName(message);
                convertResult.setConvertData(seaList);
                break;
            default:
                break;
        }
        return convertResult;
    }

    private List<Jhunter> convertSearchByName(String message) {
        return null;
    }

    private List<Jhunter> convertUpdate(String message) {
        return null;
    }

    private List<Jhunter> convertDel(String message) {
        return null;
    }

    private List<Jhunter> convertAdd(String message) {
        List<Jhunter> list = new ArrayList<>();
        String[] str = message.split(",");
        String name = str[0];
        String identity = str[1];
        int tag = Integer.parseInt(str[2]);
        Jhunter jhunter = new Jhunter();
        jhunter.setName(name);
        jhunter.setIdentity(identity);
        jhunter.setTag(tag);
        list.add(jhunter);
        return list;
    }
}
