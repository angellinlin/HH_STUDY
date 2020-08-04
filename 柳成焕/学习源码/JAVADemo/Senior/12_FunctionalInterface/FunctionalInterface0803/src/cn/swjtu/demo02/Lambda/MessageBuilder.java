package cn.swjtu.demo02.Lambda;

@FunctionalInterface
public interface MessageBuilder {
    //定义一个拼接消息的抽象方法
    public abstract String builderMessage();

}
