public class Test {
    static int count = 0;

    public Test() {

    }

    public void visit() {
        count++;
        this.print();
    }

    public void print() {
        System.out.println("count = " + count);
    }

    public static void main(String[] args) {
        Test c1 = new Test();
        c1.visit();
        Test c2 = new Test();
        c2.visit();
        Test c3 = new Test();
        c3.visit();
    }
}