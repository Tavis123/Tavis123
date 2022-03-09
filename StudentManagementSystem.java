package 学生管理系统;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    /*
      1. 用输出语句完成主界面的编写
      2. 用Scanner实现键盘录入数据
      3. 用switch语句完成操作的选择
      4. 用循环完成再次回到主界面
    */

    public static void main(String[] args) {
        //创建集合对象，用于存储学生数据
        ArrayList<Student> array1 = new ArrayList<>();
        //创建集合对象，用于存储教师数据
        ArrayList<Teacher> array2 = new ArrayList<>();
        //创建集合对象，用于存储课程数据
        ArrayList<Lesson> array3 = new ArrayList<>();
        Lesson les = new Lesson();


        //用循环完成再次回到主界面
        // 用输出语句完成主界面的编写
        System.out.println("---------欢迎来到学生管理系统------------");
        System.out.println("登陆（请输入账号：1）：");
        Scanner scanner = new Scanner(System.in);
        int account = scanner.nextInt();
        while (account != 1) {
            System.out.println("请重新输入!");
            account = scanner.nextInt();
        }

        System.out.println("登陆成功！");

        System.out.println("请输入你要操作的模块：");
        System.out.println("1 学生模块");
        System.out.println("2 教师模块");
        System.out.println("3 课程模块");

        int choice = scanner.nextInt();
        int line = 0;
        while (line != 5) {
            switch (choice) {
                case 1:
                    System.out.println("1 添加学生");
                    System.out.println("2 删除学生");
                    System.out.println("3 修改学生");
                    System.out.println("4 查看所有学生");
                    System.out.println("5 退出");
                    System.out.println("-------------------------------------");

                    // 用Scanner实现键盘录入数据
                    line = scanner.nextInt();

                    // 用switch语句完成操作的选择
                    switch (line) {
                        case 1:
                            //添加学生
                            Student.addStudent(array1);
                            break;
                        case 2:
                            //删除学生
                            Student.deleteStudent(array1);
                            break;
                        case 3:
                            //修改学生
                            Student.updateStudent(array1);
                            break;
                        case 4:
                            //查看所有学生
                            Student.findAllStudent(array1);
                            break;
                        case 5:
                            //结束
                            System.out.println("谢谢使用");
                            System.exit(0);
                            break;
                        case 6:
                            //登记成绩

                    }
                    System.out.printf("\n");
                    System.out.println("请继续输入你进行的操作：");
                    break;
                case 2:
                    System.out.println("1 添加教师");
                    System.out.println("2 删除教师");
                    System.out.println("3 修改教师");
                    System.out.println("4 查看所有教师");
                    System.out.println("5 退出");
                    System.out.println("-------------------------------------");

                    // 用Scanner实现键盘录入数据
                    line = scanner.nextInt();
                    // 用switch语句完成操作的选择
                    switch (line) {
                        case 1:
                            //添加教师
                            Teacher.addTeacher(array2);
                            break;
                        case 2:
                            //删除教师
                            Teacher.deleteTeacher(array2);
                            break;
                        case 3:
                            //修改教师
                            Teacher.updateTeacher(array2);
                            break;
                        case 4:
                            //查看所有教师
                            Teacher.findAllTeacher(array2);
                            break;
                        case 5:
                            System.out.println("谢谢使用");
                            System.exit(0);
                            break;
                    }
                    System.out.printf("\n");
                    System.out.println("请继续输入你进行的操作：");
                    break;
                case 3:
                    System.out.println("1 添加课程");
                    System.out.println("2 删除课程");
                    System.out.println("3 修改课程");
                    System.out.println("4 查看所有课程");
                    System.out.println("5 退出");
                    System.out.println("-------------------------------------");

                    // 用Scanner实现键盘录入数据
                    line = scanner.nextInt();
                    // 用switch语句完成操作的选择
                    switch (line) {
                        case 1:
                            //添加课程
                            Lesson.addLesson(array3);
                            break;
                        case 2:
                            //删除课程
                            Lesson.deleteStudent(array3);
                            break;
                        case 3:
                            //修改课程
                            Lesson.updateLesson(array3);
                            break;
                        case 4:
                            //查看所有课程
                            Lesson.findAllLesson(array3);
                            break;
                        case 5:
                            System.out.println("谢谢使用");
                            System.exit(0);
                            break;
                    }
                    System.out.printf("\n");
                    System.out.println("请继续输入你进行的操作：");
                    break;
            }
        }
    }
}



