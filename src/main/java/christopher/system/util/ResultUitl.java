package christopher.system.util;

import lombok.Data;

@Data
public class ResultUitl {

    private String code;

    private String msg;

    private Object data;

    public static ResultUitl success(Object data) {
        return resultData(ResponseCode.SUCCESS.val(), ResponseCode.SUCCESS.msg(), data);
    }

    public static ResultUitl success(Object data, String msg) {
        return resultData(ResponseCode.SUCCESS.val(), msg, data);
    }

    public static ResultUitl fail(String code, String msg) {
        return resultData(code, msg, null);
    }

    public static ResultUitl fail(String code, String msg, Object data) {
        return resultData(code, msg, data);
    }

    private static ResultUitl resultData(String code, String msg, Object data) {
        ResultUitl resultUitl = new ResultUitl();
        resultUitl.setCode(code);
        resultUitl.setMsg(msg);
        resultUitl.setData(data);
        return resultUitl;
    }
}