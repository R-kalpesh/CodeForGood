package com.company;

public class Main {

    public static void main(String[] args) throws Exception{

        Frection obj1 = new Frection(20, 1);
        Frection obj2 = new Frection(10, 25);
        obj1.print();
//        obj1.setDenominater(0);
        obj2.print();
        Frection f4 =Frection.add(obj1,obj2);
        f4.print();
    }
}
