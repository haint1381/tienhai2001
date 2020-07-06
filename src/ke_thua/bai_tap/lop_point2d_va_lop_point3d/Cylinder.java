package ke_thua.bai_tap.lop_point2d_va_lop_point3d;

import ke_thua.bai_tap.lop_point2d_va_lop_point3d.Circle;

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
