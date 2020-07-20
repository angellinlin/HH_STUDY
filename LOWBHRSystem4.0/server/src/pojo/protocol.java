package pojo;

public class protocol {

    public static String Message(returnResult rr){
        String res;
        String state = rr.state;

        if(state.equals("Success")){
            res = state + ":" + rr.record;
        }
        else{
            res = state + ":" + rr.failReason;
        }

        return res;
    }
}
