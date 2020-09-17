package bai_hoc.abstract_class_interface.thu_hanh.trien_khai_interface_comparator;
import bai_hoc.ke_thua.bai_tap.circle_va_cylinder.Circle;

import java.util.Comparator;
public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) return 2;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }
}
