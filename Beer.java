package 西二炸鸡店;

public class Beer extends Drinks{

    private float content;//酒精度数
    private int f=1;//一开始假设啤酒未过期


    @Override
    public String toString() {
        if(f==1)
            return "啤酒没过期";
        else
            return "啤酒过期了";
    }
}
