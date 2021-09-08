public class Genric<t,v> {
    public t name;
    public v age;
    public Genric(t name,v age){
        this.name=name;
        this.age=age;
    }

    public void printName(){
        System.out.println("Name: "+name);
    }
    public void printAge(){
        System.out.println("Age: "+age);
    }
}
