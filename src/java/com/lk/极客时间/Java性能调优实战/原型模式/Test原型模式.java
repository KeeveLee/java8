package com.lk.极客时间.Java性能调优实战.原型模式;

import lombok.Data;

/**
 * Description:
 * 使用原型模式创建对象，就无需new实例化对象了， 因为：Object类的clone方法是本地方法，它可以直接操作内存中的二进制流，所以性能会比new更佳
 *
 * 注意不同于：Object a=new Object();  Object b=a;
 *
 * @author likai
 * @date 2019-12-31 10:49
 */
public class Test原型模式 {


    @Data
    static class Student implements Cloneable{
        private String studentName;
        private Teacher teacher;

        /**
         * 浅copy
         * @return
         */
//        @Override
//        public Student clone(){
//            Student student = null;
//            try {
//                student = (Student) super.clone();
//            }catch (CloneNotSupportedException e){
//                System.out.println(e);
//            }
//            return student;
//        }

        /**
         * 深copy
         * @return
         */
        @Override
        public Student clone(){
            Student student = null;
            try {
                student = (Student) super.clone();
                // clone teacher 对象
                Teacher t = this.teacher.clone();
                student.setTeacher(t);
            }catch (CloneNotSupportedException e){
                System.out.println(e);
            }
            return student;
        }

    }

    @Data
    static class Teacher implements Cloneable{
        private String teacherName;

        @Override
        public Teacher clone() {

            Teacher teacher = null;
            try {
                teacher = (Teacher)super.clone();
            }catch (CloneNotSupportedException e){
                System.out.println(e);
            }
            return teacher;
        }
    }



    public static void main(String[] args){
        Teacher teacher1 = new Teacher();
        teacher1.setTeacherName("t1111");
        Student student1 = new Student();
        student1.setStudentName("aaa");
        student1.setTeacher(teacher1);

        Student student2 = student1.clone();
        student2.setStudentName("bbb");
        student2.getTeacher().setTeacherName("t2222");

        System.out.println("s1:" + student1.getStudentName() + " t1:" + student1.getTeacher().getTeacherName());
        System.out.println("s2:" + student2.getStudentName() + " t2:" + student2.getTeacher().getTeacherName());
    }
}
