package bai_hoc.abstract_class_interface.thu_hanh.lop_animal_va_interface_edible;

public class Chicken extends Animal  implements Edible  {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }
    @Override
    public String howToEat() {
        return "could be fried";
    }
}
