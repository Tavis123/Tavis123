package 西二炸鸡店;

public class Juice extends Drinks {
    private  int number=10;//剩余的瓶数
    private int f=1;
    @Override
    public String toString() {
        if(f==0)
            return "果汁没过期";
        else
            return "果汁过期了";
    }
}
