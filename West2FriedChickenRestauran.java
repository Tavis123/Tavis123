package 西二炸鸡店;

import java.util.Scanner;

public class West2FriedChickenRestauran implements FriedChickenRestaurant {


    public static void main(String[] args) {
        int juiceleft = 5;
        int beerleft = 5;
        System.out.println("请输入你要查询的东西（购买套餐输入1，检查饮料是否过期输入2）：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        //判断是否过期
        if (choice == 2) {
            System.out.println("请输入你要查询的饮料（1是啤酒，2是果汁）以及当日距生产日期的天数：");
            int drinkchoice = scanner.nextInt();
            int localdate = scanner.nextInt();
            LocalDate LD = new LocalDate();
            System.out.println(LD.Judge(localdate, drinkchoice));
        }
        //出售套餐
        if (choice == 1) {
            System.out.println("请输入你要购买套餐的份数：");
            int number = scanner.nextInt();
            int i;
            for (i = 1; i <= number; i++) {
                System.out.println("请输入你要购买的套餐（果汁套餐输入1，啤酒套餐输入2）：");
                int mealchoice = scanner.nextInt();
                if (mealchoice == 1) {
                    if (juiceleft > 0)
                        juiceleft--;
                    else
                    {
                        System.out.println("需进货！");
                        juiceleft = 5;
                    }

                } else {
                    if (beerleft > 0)
                        beerleft--;
                    else
                    {
                        System.out.println("需进货！");
                        beerleft = 5;
                    }

                }
            }
        }
}

    @Override
    public void sell() {
        System.out.println("已购买套餐!");
    }

    @Override
    public void purchase() {
        System.out.println("已进货!");
    }

}
