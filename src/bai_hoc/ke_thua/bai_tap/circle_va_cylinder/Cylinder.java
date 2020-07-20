package bai_hoc.ke_thua.bai_tap.circle_va_cylinder;

public class Cylinder extends Circle {
    private double height;
    public Cylinder(double radius,String color, double height){
        super(radius,color);
        this.height = height;
    }
    public double volume(){
        return super.getRadius() * super.getRadius() * Math.PI;
    }

    @Override
    public String toString(){
        return "radius: "+super.getRadius()+"\n"+
                "color: "+super.getRadius()+"\n"+
                "volume: "+volume();
    }
}
