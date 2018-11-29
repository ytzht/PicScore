package vip.mae.baseutil;

public class BaseEvent {

    public static final int PAGE_MAX_COUNT = 20;

    public static BaseEvent event(int code){
        return new BaseEvent(code);
    }

    public static BaseEvent event(int code,Object assign){
        return new BaseEvent(code,assign);
    }

    private int code = 0;
    private Object assign;

    public BaseEvent(int code){
        this(code, null);
    }

    public BaseEvent(int code, Object assign) {
        this.code = code;
        this.assign = assign;
    }

    public int getCode() {
        return code;
    }

    public Object getAssign() {
        return assign;
    }
}
