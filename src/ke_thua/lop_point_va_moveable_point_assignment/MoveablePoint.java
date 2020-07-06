package ke_thua.lop_point_va_moveable_point_assignment;

public class MoveablePoint extends Point {
   private float xSpeed;
   private float ySpeed;
   public MoveablePoint(float x,float y,float xSpeed,float ySpeed){
       super(x,y);
       this.xSpeed=xSpeed;
       this.ySpeed=ySpeed;
   }
   public MoveablePoint(){

   }
    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setXSpeedYSpeed(float xSpeed,float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float[] getXSpeedYSpeed() {
        float[] array1 = {xSpeed,ySpeed};
        return array1;
    }

    @Override
    public String toString() {
        return "MoveablePoint{" +
                "xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }
    public String movablePointMove(float[] array) {
        array[0] +=xSpeed;
        array[1] +=ySpeed;
        return "SpeedX: "+array[0]+"\n"+
                "SpeedY: "+array[1];
    }
}
