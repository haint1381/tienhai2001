package bai_hoc.ke_thua.bai_tap.thiet_ke_va_trien_khai_lop_triangle;

public class Triangle extends Shape{
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1,double side2,double side3,String color,boolean filled){
        super(color, filled);
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
    }
    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
    public double getPerimeter(){
        return side1+side2+side3;
    }
    public double gethalfPerimeter(){
        return (side1+side2+side3)/2;
    }
    public double getHeight(){
        double result=gethalfPerimeter()*(gethalfPerimeter()-side1)*(gethalfPerimeter()-side2)*(gethalfPerimeter()-side3);
        return 2*Math.pow(result,0.5)/side1;
    }
    public double getArea(){
        return 0.5*side1*getHeight();
    }
    public String toString(){
        return "The triangle consists of edges:\n"+
                "Side1 = "+getSide1()+"\n"+
                "Side2 = "+getSide2()+"\n"+
                "Side3 = "+getSide3()+"\n"+
                "color = "+super.getColor()+"\n"+
                "fill = "+super.isFilled()+"\n"+
                "Area = "+getArea()+"\n"+
                "Perimeter = "+getPerimeter();

    }
}
