package dsa_danh_sach.bai_tap.trien_khai_cac_phuong_thuc_linkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        class Student{
            private int id;
            private String name;
            public Student(){}

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "Name: "+getName();
            }
        }
        MyLinkedList<Student> myLinkedList=new MyLinkedList<>();
        Student student1 =new Student(1,"hai");
        Student student2 =new Student(2,"khanh");
        Student student3 =new Student(3,"toan");
        Student student4 =new Student(4,"tung");
        Student student5 =new Student(5,"nam");

        myLinkedList.addFirst(student1);
        myLinkedList.addFirst(student2);
        myLinkedList.addLast(student3);
        myLinkedList.add(0,student4);

//        MyLinkedList<Student> clone = myLinkedList.clone();
//        for (int i=0;i<clone.size();i++){
//            System.out.println(((Student) clone.get(i)).getName());
//        }
//        System.out.println(myLinkedList.indexOf(student2));
//        System.out.println(myLinkedList.getFirst());
//        System.out.println(myLinkedList.getLast());



//        myLinkedList.clear();
        for (int i=0;i<myLinkedList.size();i++){
           System.out.println(((Student) myLinkedList.get(i)).getName());
      }
//        System.out.println(myLinkedList.constrains(student3));
//        myLinkedList.remove(2);
//
//        myLinkedList.remove(student1);
//
//
//        for (int i=0;i<myLinkedList.size();i++){
//            System.out.println(((Student) myLinkedList.get(i)).getName());
//        }
    }
}
