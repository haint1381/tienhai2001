package ke_thua.bai_tap.circle_va_cylinder;

public class Circle {
    private double radius;
    private String color;

    public Circle(double radius,String color) {
        this.radius = radius;
        this.color = color;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public double acreage(){
        return radius * radius * Math.PI;
    }
    public double perimeter() {
        return 2 * radius * Math.PI;
    }
    @Override
    public String toString(){
        return "radius: "+this.radius+"\n"+
                "color: "+this.color+"\n"+
                "acreage: "+acreage()+"\n"+
                "perimeter: "+perimeter();
    }
}
