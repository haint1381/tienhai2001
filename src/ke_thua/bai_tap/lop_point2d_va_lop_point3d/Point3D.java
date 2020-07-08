package ke_thua.bai_tap.lop_point2d_va_lop_point3d;

public class Point3D extends Point2D {
    private float z=0.0f;

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z){
        super(x, y);
        this.z=z;
    }
    public void setXYZ(float x,float y,float z){
       super.setX(x);
       super.setY(y);
        this.z = z;
    }
    public float[] getXYZ() {
        float[] array={super.getX(),super.getY(),z};
        return array;
    }
    @Override
    public String toString() {
        return "Point3D( { x=" + getXYZ()[0] + ", y=" + getXYZ()[1] +",z= "+getXYZ()[2]+" }";
    }
}
