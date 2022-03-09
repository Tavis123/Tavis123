package 学生管理系统;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private String studentid;
    //学号
    private String name;
    //姓名
    private String gender;
    //性别
    private String birthdate;
    //出生日期
    private String nation;
    //民族
    private int grade;
    //年级


    public Student() {
    }

    public Student(String studentid, String name, String gender, String birthdate, String nation, int grade) {
        this.studentid = studentid;
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.nation = nation;
        this.grade = grade;
    }

    public String getStudentid() {
        System.out.printf("%-8s", studentid);
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public void getName() {
        System.out.printf("%-7s", name);
    }
    public void setName(String name) {
        this.name = name;
    }


    public void getGender() {
        System.out.printf("%-7s", gender);
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
        this.nation = nation;
    }


    public void getGrade() {
        System.out.printf("%-8d",grade);
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


    //定义一个方法，用于添加学生信息
    public static void addStudent(ArrayList<Student> array) {

        //用键盘录入选择添加学生,显示提示信息，提示要输入何种信息
        Scanner sc = new Scanner(System.in);

        //为了让studentid在while循环外面能被访问到，就把它定义在了循环外
        String studentid;

        //为了让程序能够回到这里，使用循环使用
        while (true) {
            System.out.println("请输入学生学号（四位）：");
            studentid = sc.nextLine();

            boolean flag = isUsed(array, studentid);
            if (flag) {
                System.out.println("你输入的学号已经被使用，请重新输入");
            } else {
                break;
            }
        }

        System.out.println("请输入学生的姓名：");
        String name = sc.nextLine();

        System.out.println("请输入学生的性别（男/女）：");
        String gender = sc.nextLine();

        System.out.println("请输入学生的出生日期（xxxx-xx-xx）：");
        String birthdate = sc.nextLine();

        System.out.println("请输入学生的民族（x族）：");
        String nation = sc.nextLine();

        System.out.println("请输入学生的年级（一位数字）：");
        int grade = sc.nextInt();

        //创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
        Student s = new Student();
        s.setStudentid(studentid);
        s.setName(name);
        s.setGender(gender);
        s.setBirthdate(birthdate);
        s.setNation(nation);
        s.setGrade(grade);
        //将学生对象添加到集合中（保存）
        array.add(s);

        //给出添加成功提示
        System.out.println("添加学生成功");
    }

    //定义一个方法，判断学号是否被占用
    public static boolean isUsed(ArrayList<Student> array, String studentid) {
        //如果与集合中的某一个学生学号相同，返回true  如果都不相同，返回false

        boolean flag = false;

        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getStudentid().equals(studentid)) {
                flag = true;
                break;
            }
        }
        return flag;
    }


    //定义一个方法，用于查看学生信息
    public static void findAllStudent(ArrayList<Student> array) {
        //显示表头信息
        //'\t'是tab键的位置

        if (array.size() == 0) {
            System.out.println("无信息，请先添加信息再查询");
            //为了不让程序继续往下执行
            return;
        }
        System.out.println("学号\t\t姓名\t\t性别\t\t出生日期\t\t民族\t\t年级");

        //将集合中数据取出按照对应格式显示学生信息
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
           s.getStudentid();
           s.getName();
           s.getGender();
           s.getBirthdate();
           s.getNation();
           s.getGrade();
        }
    }

    //定义一个方法，用于删除学生信息
    public static void deleteStudent(ArrayList<Student> array) {

        // 键盘录入要删除的学生学号,显示提示信息

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生的学号");
        String studentid = sc.nextLine();

        //在删除/修改学生操作前，对学号是否存在进行判断
        //如果不存在，显示提示信息
        //如果存在，执行删除/修改操作
        int index = -1;

        // 遍历集合将对应学生对象从集合中删除
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getStudentid().equals(studentid)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("该学号不存在，请重新输入");
        } else {
            array.remove(index);
            System.out.println("删除学生成功");
        }
    }

    //定义一个方法，用于修改学生信息
    public static void updateStudent(ArrayList<Student> array) {
        // 键盘录入要修改的学生学号，显示提示信息

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生的学号");
        String studentid = sc.nextLine();

        //在删除/修改学生操作前，对学号是否存在进行判断
        //如果不存在，显示提示信息
        //如果存在，执行删除/修改操作
        int index = -1;


        // 遍历集合修改对应的学生信息
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getStudentid().equals(studentid)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("该学号不存在，请重新输入");
        } else {
            for (int j = 0; j < array.size(); j++) {
                Student student = array.get(j);
                if (student.getStudentid().equals(studentid)) {

                    // 键盘录入要修改的学生信息
                    System.out.println("请输入学生的新姓名");
                    String name = sc.nextLine();

                    System.out.println("请输入学生的新性别");
                    String gender = sc.nextLine();

                    System.out.println("请输入学生的新出生日期");
                    String birthdate = sc.nextLine();

                    System.out.println("请输入学生的新民族");
                    String nation = sc.nextLine();

                    System.out.println("请输入学生的新年级");
                    int grade = sc.nextInt();

                    // 创建学生对象
                    Student s = new Student();
                    s.setStudentid(studentid);
                    s.setName(name);
                    s.setGender(gender);
                    s.setBirthdate(birthdate);
                    s.setNation(nation);
                    s.setGrade(grade);
                    array.set(j, s);

                    // 给出修改成功提示
                    System.out.println("修改学生成功");
                    break;
                }
            }
        }
    }
}
