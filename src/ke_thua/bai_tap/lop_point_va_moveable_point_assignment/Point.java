package ke_thua.bai_tap.lop_point_va_moveable_point_assignment;

public class Point {
    private float x=0.0f;
    private float y=0.0f;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Point(){

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x,float y){
        this.x = x;
        this.y = y;
    }
    public float[] getXY(){
        float[] array = {x,y};
        return array;
    }
    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
}
