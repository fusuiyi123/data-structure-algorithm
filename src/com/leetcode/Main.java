package com.leetcode;

class Car {
    int no;
    Car(int no) { this.no = no; }
    void print() {
        System.out.println("no = " + no);
    }
}

class CarWrapper {
    Car c;
    CarWrapper(Car c) { this.c = c; }
}

public class Main {


    public static void swap(CarWrapper cw1, CarWrapper cw2) {
        Car tmp = cw1.c;
        cw1.c = cw2.c;
        cw2.c = tmp;
    }

    public static void main(String[] args) {

        Car car1 = new Car(1);
        Car car2 = new Car(2);
        car1.print();
        car2.print();

        CarWrapper cw1 = new CarWrapper(car1);
        CarWrapper cw2 = new CarWrapper(car2);
        swap(cw1, cw2);
        cw1.c.print();
        cw2.c.print();

        Car tmp = car1;
        car1 = car2;
        car2 = tmp;
        car1.print();
        car2.print();
//        Array array = new Array();



    }
}
