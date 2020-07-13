package dsa_tack_queue.bai_tap.to_chuc_du_lieu_hop_ly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Employee {
    static class Employee1{
        private String name;
        private String gender;
        private int age;
        public Employee1() {
        }
        public Employee1(String name, String gender,int age) {
            this.name = name;
            this.gender = gender;
            this.age=age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }
    public static void main(String[] args) {
        Queue nu=new LinkedList();
       Employee1 nu1=new Employee1("mai","nữ",26);
       Employee1 nu2=new Employee1("mai","nữ",25);
       Employee1 nu4=new Employee1("mai","nữ",24);
       Employee1 nu5=new Employee1("mai","nữ",21);
    }
}
