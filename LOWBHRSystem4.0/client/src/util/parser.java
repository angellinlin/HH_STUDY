package util;

public class parser {

    public static void parser(String str){
        String res, state, context;
        String [] messages;

        messages = str.split("\\:");
        state = messages[0];
        context = messages[1];

        if(state.equals("Success")){
            res = "操作成功! \n" + context;
        }
        else{
            res = "操作失败! \n" + context;
        }
        System.out.println(res);
    }
}
