package utils;

import bean.Jhunter;
import bean.OperaResult;

import java.util.List;

/**
 * @author sy
 * @date 2020/7/26 17:55
 */
public class Protocol {

    public Protocol() {
    }

    /**
     * 添加
     * @param operaResult
     * @return
     */
    public String AddMessage(OperaResult operaResult){
        return getResult(operaResult);
    }

    /**
     * 删除
     * @param operaResult
     * @return
     */
    public String deleteMessage(OperaResult operaResult){
        return getResult(operaResult);
    }

    /**
     * 更新
     * @param operaResult
     * @return
     */
    public String updateMessage(OperaResult operaResult){
        return getResult(operaResult);
    }

    /**
     * 获取操作结果
     * @param operaResult
     * @return
     */
    private String getResult(OperaResult operaResult) {
        String str;
        String isSuccess = operaResult.getIsSuccess();
        if (isSuccess.equals("Success")) {
            str = isSuccess + "/n";
        } else {
            str = isSuccess + "/n" + operaResult.getOnFail();
        }

        return str;
    }

    /**
     * 通过名字搜索
     * @param operaResult
     * @return
     */
    public String searchByNameMessage(OperaResult operaResult){
        String str;
        String isSuccess = operaResult.getIsSuccess();
        if (isSuccess.equals("Success")){
            List<Jhunter> list = (List<Jhunter>) operaResult.getOperaData();
            str = isSuccess + "/n";
            if (!list.isEmpty()){
                for (Jhunter j:list
                     ) {
                    String s = j.getName() + "," + j.getIdentity()+","+j.getTag();
                    str += s;
                }
            }
        }else {
            str = isSuccess + "/n" + operaResult.getOnFail();
        }
        return str;
    }

}
