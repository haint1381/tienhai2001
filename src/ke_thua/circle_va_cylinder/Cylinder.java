package ke_thua.circle_va_cylinder;

import ke_thua.circle_va_cylinder.Circle;

public class Cylinder extends Circle {
    private double height;
    public Cylinder(double radius,String color, double height){
        super(radius, color);
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
