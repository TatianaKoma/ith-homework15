package ua.hillel;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    public void addOneFruit(T fruit) {
        fruits.add(fruit);
    }

    public void addManyFruits(List<? extends T> fruits) {
        this.fruits.addAll(fruits);
    }

    public float getBoxWeight() {
        if (fruits.size() == 0) {
            return 0;
        }
        return fruits.size() * fruits.get(0).getWeight();
    }

    public boolean compare(Box<? extends Fruit> other) {
        return getBoxWeight() == other.getBoxWeight();
    }

    public void merge(Box<T> other) {
        fruits.addAll(other.fruits);
        other.fruits.clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "Fruits=" + fruits +
                '}';
    }

    public static void main(String[] args) {
        Box<Apple> apples = new Box<>();
        Box<Orange> oranges = new Box<>();
        Box<Orange> oranges1 = new Box<>();
        Apple ap1 = new Apple("apple1", 1.0f);
        Apple ap2 = new Apple("apple2", 1.0f);
        Apple ap3 = new Apple("apple3", 1.0f);
        Apple ap4 = new Apple("apple4", 1.0f);
        Orange or1 = new Orange("orange1", 1.5f);
        Orange or2 = new Orange("orange2", 1.5f);
        Orange or3 = new Orange("orange3", 1.5f);
        apples.addOneFruit(ap1);
        apples.addOneFruit(ap2);
        System.out.println(apples);
        oranges.addOneFruit(or1);
        oranges.addOneFruit(or2);
        oranges.addOneFruit(or3);
        List<Apple> apples1 = new ArrayList<>();
        apples1.add(ap3);
        apples1.add(ap4);
        apples.addManyFruits(apples1);
        System.out.println(apples);
        System.out.println(oranges.getBoxWeight());
        System.out.println(apples.getBoxWeight());
        System.out.println(apples.compare(oranges));
        oranges1.addOneFruit(or1);
        oranges1.addOneFruit(or3);
        oranges.merge(oranges1);
        System.out.println(oranges);
        System.out.println(oranges1);
    }
}
