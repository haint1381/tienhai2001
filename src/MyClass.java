public  class MyClass {
    static public int X = 2;

    static {
        X = 1;
    }

    static public void method() {
        X = 5;
    }
    public static int name(){
        return X=11;
    }

    public static void main(String[] args) {
        MyClass o = new MyClass();
        MyClass.method();

        System.out.println(MyClass.name());
        MyClass.X = 10;
        System.out.println(MyClass.X);
    }
}