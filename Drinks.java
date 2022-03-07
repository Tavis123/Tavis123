package 西二炸鸡店;

public abstract class Drinks {
    protected String name;
    protected double cost;
    protected int date;//保质期
    protected int f=1;//1是没过期，0是过期了
    protected int localdate;//生产日期

    public Drinks(){
    }//无参构造（默认存在）

    public abstract String toString();

}
