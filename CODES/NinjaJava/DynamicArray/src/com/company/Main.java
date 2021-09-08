package com.company;

public class Main {

    public static void main(String[] args) {

        DyanamicArrayClass obj1 = new DyanamicArrayClass();
        for (int i=0;i<100;i++){
            obj1.add(i+10);
        }

        System.out.println("Size : "+obj1.size());

        obj1.set(98,100);
        int pos1=obj1.get(98);
        System.out.println(pos1);
        while (!obj1.isEmpty()){

            System.out.print(" Position : "+ (obj1.size() - 1));
            System.out.println(" Element : "+obj1.removeLast());
        }
    }
}
