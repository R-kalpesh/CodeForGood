package com.company;

public class Frection {

    private int numinater;
    private int denominater;

    Frection(int numinater,int denominater)throws Exception{
        this.numinater=numinater;
        this.denominater=denominater;
        simplify();
    }

    void simplify() throws Exception{
        if(denominater==0){
            Exception e = new Exception("Denominetor can't be zero.");
            throw e;

//            TODO: return error
        }else {
            int gcp=1;
            int min=Math.min(denominater,numinater);
            for (int i=2;i<=min;i++){
                if(numinater%i==0 && denominater%i==0){
                    gcp=i;
                }
            }
            numinater=numinater/gcp;
            denominater=denominater/gcp;
        }
    }

    public void print(){
        if(denominater==1){
            System.out.println(numinater);
        }else {
            System.out.println(numinater + "/" + denominater);
        }
    }

    public void setNumineter(int n)throws Exception{
        this.numinater=n;
        simplify();
    }

    public void setDenominater(int n)throws Exception{
        if (n==0){
            Exception e = new Exception("Denominetor can't be zero.");
            throw e;
//            TODO: retrun error
        }
        this.denominater=n;
        simplify();
    }

    public int getDenominater(){
        return denominater;
    }

    public int getNuminater(){
        return numinater;
    }
    public  static Frection add(Frection f1,Frection f2)throws Exception{
        int newNumineter=f1.numinater*f2.denominater+f2.numinater*f1.denominater;
        int newDenomineter=f2.denominater*f1.denominater;
        Frection f4= new Frection(newNumineter,newDenomineter);
        return f4;
    }

    public  void add(Frection f2)throws Exception{
        this.numinater=this.numinater*f2.denominater+this.denominater*f2.numinater;
        this.denominater=this.denominater*f2.denominater;
        simplify();
    }

    public  void multi(Frection f2)throws Exception{
        this.numinater=this.numinater*f2.numinater;
        this.denominater=this.denominater*f2.denominater;
        simplify();
    }


}
