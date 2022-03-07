package 西二炸鸡店;

import java.util.Scanner;

public class LocalDate {
    private int localdate;
    private int beerdate=30;
    private int juicedate=2;

    public void setLocaldate(int localdate) {
        this.localdate = localdate;
    }

    public String Judge(int localdate,int drinkchoice)
    {
        if(drinkchoice==1)
        {
            if(localdate>beerdate)
                return "啤酒已过期";
            else
                return "啤酒未过期";
        }
        if(drinkchoice==2)
        {
            if(localdate>juicedate)
                return "果汁已过期";
            else
                return "果汁未过期";
        }
        return "请重新输入drinkchoice!";
    }

}
