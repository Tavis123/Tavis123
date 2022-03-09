package 学生管理系统;

import java.util.ArrayList;
import java.util.Scanner;

public class Teacher {

    ArrayList<Student> array2 = new ArrayList<>();
    private String teacherid;
    //学号
    private String name;
    //姓名
    private String gender;
    //性别
    private String birthdate;
    //出生日期
    private String nation;
    //民族


    public Teacher() {
    }

    public Teacher(String teacherid, String name, String gender, String birthdate, String nation) {
        this.teacherid = teacherid;
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.nation = nation;
    }

    public String getTeacherid() {
        System.out.printf("%-11s", teacherid);
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }


    public void getName() {
        System.out.printf("%-8s", name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getGender() {
        System.out.printf("%-6s", gender);
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void getBirthdate() {
        System.out.printf("%-12s",birthdate);
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void getNation() {
        System.out.printf("%-8s",nation);
    }

    public void setNation(String nation) {
        this.nation=nation;
    }

    //定义一个方法，用于添加信息
    public static void addTeacher(ArrayList<Teacher> array2) {

        //用键盘录入选择添加教师,显示提示信息，提示要输入何种信息
        Scanner sc = new Scanner(System.in);

        //为了让teacherid在while循环外面能被访问到，我们就把它定义在了循环外
        String teacherid;

        //为了让程序能够回到这里，我们使用循环使用
        while (true) {
            System.out.println("请输入教师号(四位)：");
            teacherid = sc.nextLine();

            boolean flag = isUsed(array2, teacherid);
            if (flag) {
                System.out.println("你输入的教师号已经被使用，请重新输入");
            } else {
                break;
            }
        }

        System.out.println("请输入教师的姓名：");
        String name = sc.nextLine();

        System.out.println("请输入教师的性别（男/女）：");
        String gender = sc.nextLine();

        System.out.println("请输入教师的出生日期（xxxx-xx-xx）：");
        String birthdate = sc.nextLine();

        System.out.println("请输入教师的民族（x族）：");
        String nation = sc.nextLine();

        //创建教师对象，把键盘录入的数据赋值给教师对象的成员变量
        Teacher t = new Teacher();
        t.setTeacherid(teacherid);
        t.setName(name);
        t.setGender(gender);
        t.setBirthdate(birthdate);
        t.setNation(nation);
        //将教师对象添加到集合中（保存）
        array2.add(t);

        //给出添加成功提示
        System.out.println("添加教师成功");
    }

    //定义一个方法，判断教师号是否被占用
    public static boolean isUsed(ArrayList<Teacher> array2, String teacherid) {
        //如果与集合中的某一个教师号相同，返回true  如果都不相同，返回false

        boolean flag = false;

        for (int i = 0; i < array2.size(); i++) {
            Teacher t = array2.get(i);
            if (t.getTeacherid().equals(teacherid)) {
                flag = true;
                break;
            }
        }
        return flag;
    }


    //定义一个方法，用于查看教师信息
    public static void findAllTeacher(ArrayList<Teacher> array2) {
        //显示表头信息
        //'\t'是tab键的位置

        if (array2.size() == 0) {
            System.out.println("无信息，请先添加信息再查询");
            //为了不让程序继续往下执行
            return;
        }

        System.out.println("教师号\t\t姓名\t\t性别\t\t出生日期\t\t民族");

        //将集合中数据取出按照对应格式显示教师信息
        for (int i = 0; i < array2.size(); i++) {
            Teacher t = array2.get(i);
           t.getTeacherid();
           t.getName();
           t.getGender();
           t.getBirthdate();
           t.getNation();
        }
    }

    //定义一个方法，用于删除教师信息
    public static void deleteTeacher(ArrayList<Teacher> array2) {

        // 键盘录入要删除的教师号,显示提示信息

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的教师号");
        String teacherid = sc.nextLine();

        //在删除/修改教师操作前，对教师号是否存在进行判断
        //如果不存在，显示提示信息
        //如果存在，执行删除/修改操作
        int index = -1;

        // 遍历集合将对应教师对象从集合中删除
        for (int i = 0; i < array2.size(); i++) {
            Teacher t = array2.get(i);
            if (t.getTeacherid().equals(teacherid)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("该教师号不存在，请重新输入");
        } else {
            array2.remove(index);
            System.out.println("删除教师成功");
        }
    }

    //定义一个方法，用于修改教师信息
    public static void updateTeacher(ArrayList<Teacher> array2) {
        // 键盘录入要修改的教师号，显示提示信息

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的教师号（四位）");
        String teacherid = sc.nextLine();

        //在删除/修改教师操作前，对教师号是否存在进行判断
        //如果不存在，显示提示信息
        //如果存在，执行删除/修改操作
        int index = -1;

        // 遍历集合修改对应的教师信息
        for (int i = 0; i < array2.size(); i++) {
            Teacher t = array2.get(i);
            if (t.getTeacherid().equals(teacherid)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("该教师号不存在，请重新输入");
        } else {
            for (int j = 0; j < array2.size(); j++) {
                Teacher teacher = array2.get(j);
                if (teacher.getTeacherid().equals(teacherid)) {

                    // 键盘录入要修改的教师信息
                    System.out.println("请输入教师的新姓名");
                    String name = sc.nextLine();

                    System.out.println("请输入教师的新性别");
                    String gender = sc.nextLine();

                    System.out.println("请输入教师的新出生日期");
                    String birthdate = sc.nextLine();

                    System.out.println("请输入教师的新民族");
                    String nation = sc.nextLine();

                    // 创建学生对象
                    Teacher t = new Teacher();
                    t.setTeacherid(teacherid);
                    t.setName(name);
                    t.setGender(gender);
                    t.setBirthdate(birthdate);
                    t.setNation(nation);
                    array2.set(j, t);

                    // 给出修改成功提示
                    System.out.println("修改教师成功");
                    break;
                }
            }
        }
    }
}
