package 学生管理系统;

import java.util.ArrayList;
import java.util.Scanner;

public class Lesson {

    private String lessonid;
    //课程号
    private String name;
    //课程名
    private static int credit;
    //学分

    public Lesson() {
    }

    public Lesson(String lessonid, String name, int credit) {
        this.lessonid = lessonid;
        this.name = name;
        this.credit = credit;
    }

    public String getLessonid() {
        System.out.printf("%-8s", lessonid);
        return lessonid;
    }

    public void setLessonid(String lessonid) {
        this.lessonid = lessonid;
    }

    public void getName() {
        System.out.printf("%-6s", name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getCredit() {
        System.out.printf("%-8s", credit);
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    //定义一个方法，用于添加课程信息
    public static void addLesson(ArrayList<Lesson> array) {

        //用键盘录入选择添加课程,显示提示信息，提示要输入何种信息
        Scanner sc = new Scanner(System.in);

        //为了让lessonid在while循环外面能被访问到，就把它定义在了循环外
        String lessonid;

        //为了让程序能够回到这里，使用循环使用
        while (true) {
            System.out.println("请输入课程号（四位）：");
            lessonid = sc.nextLine();

            boolean flag = isUsed(array, lessonid);
            if (flag) {
                System.out.println("你输入的课程号已经被使用，请重新输入");
            } else {
                break;
            }
        }

        System.out.println("请输入课程名：");
        String name = sc.nextLine();

        System.out.println("请输入学分");
        int credit = sc.nextInt();

        //创建课程对象，把键盘录入的数据赋值给课程对象的成员变量
        Lesson l = new Lesson();
        l.setLessonid(lessonid);
        l.setName(name);
        l.setCredit(credit);
        //将课程对象添加到集合中（保存）
        array.add(l);

        //给出添加成功提示
        System.out.println("添加课程成功");
    }

    //定义一个方法，判断课程号是否被占用
    public static boolean isUsed(ArrayList<Lesson> array, String lessonid) {
        //如果与集合中的某一个课程号相同，返回true  如果都不相同，返回false

        boolean flag = false;

        for (int i = 0; i < array.size(); i++) {
            Lesson l = array.get(i);
            if (l.getLessonid().equals(lessonid)) {
                flag = true;
                break;
            }
        }
        return flag;
    }


    //定义一个方法，用于查看课程信息
    public static void findAllLesson(ArrayList<Lesson> array) {
        //显示表头信息
        //'\t'是tab键的位置

        if (array.size() == 0) {
            System.out.println("无信息，请先添加信息再查询");
            //为了不让程序继续往下执行
            return;
        }

        System.out.println("课程号\t课程名\t学分");

        //将集合中数据取出按照对应格式显示课程信息
        for (int i = 0; i < array.size(); i++) {
            Lesson l = array.get(i);
            l.getLessonid();
            l.getName();
            l.getCredit();
        }
    }

    //定义一个方法，用于删除课程信息
    public static void deleteStudent(ArrayList<Lesson> array) {

        // 键盘录入要删除的课程号,显示提示信息

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的课程号");
        String lessonid = sc.nextLine();

        //在删除/修改课程操作前，对课程号是否存在进行判断
        //如果不存在，显示提示信息
        //如果存在，执行删除/修改操作
        int index = -1;

        // 遍历集合将对应课程对象从集合中删除
        for (int i = 0; i < array.size(); i++) {
            Lesson l = array.get(i);
            if (l.getLessonid().equals(lessonid)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("该课程号不存在，请重新输入");
        } else {
            array.remove(index);
            System.out.println("删除课程成功");
        }
    }

    //定义一个方法，用于修改课程信息
    public static void updateLesson(ArrayList<Lesson> array) {
        // 键盘录入要修改的课程号，显示提示信息

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的课程号");
        String lessonid = sc.nextLine();

        //在删除/修改课程操作前，对课程号是否存在进行判断
        //如果不存在，显示提示信息
        //如果存在，执行删除/修改操作
        int index = -1;

        // 遍历集合修改对应的课程信息
        for (int i = 0; i < array.size(); i++) {
            Lesson l = array.get(i);
            if (l.getLessonid().equals(lessonid)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("该课程号不存在，请重新输入");
        } else {
            for (int j = 0; j < array.size(); j++) {
                Lesson lesson = array.get(j);
                if (lesson.getLessonid().equals(lessonid)) {

                    // 键盘录入要修改的课程信息
                    System.out.println("请输入新课程名");
                    String name = sc.nextLine();

                    System.out.println("请输入学生的新学号");
                    String gender = sc.nextLine();

                    // 创建课程对象
                    Lesson l = new Lesson();
                    l.setLessonid(lessonid);
                    l.setName(name);
                    l.setCredit(credit);
                    array.set(j, l);

                    // 给出修改成功提示
                    System.out.println("修改课程成功");
                    break;
                }
            }
        }
    }
}
