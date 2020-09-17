package bai_hoc.ke_thua.bai_tap.lop_point_va_moveable_point_assignment;

public class MoveablePoint extends Point {
    private float xSpeed;
    private float ySpeed;

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint() {

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

    public void setXSpeedYSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getXSpeedYSpeed() {
        float[] array1 = {getXSpeed(), getYSpeed()};
        return array1;
    }

    @Override
    public String toString() {
        return "MoveablePoint{" +
                "xSpeed=" + this.getXSpeed() +
                ", ySpeed=" + this.getYSpeed() +
                ", x=" + super.getX() +
                ", y=" + super.getY() +
                '}';
    }
    public MoveablePoint move() {
        super.setX(super.getX()+getXSpeed());
        super.setY(super.getY() + getYSpeed());
        return this;
    }
}
