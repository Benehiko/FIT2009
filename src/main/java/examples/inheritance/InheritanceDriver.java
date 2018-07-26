package examples.inheritance;

public class InheritanceDriver {

    public static void main(String[] args){

        Animal aCat = new Cat(4, 2);

        System.out.println("Legs: "+aCat.getLegs()+"\nSize: "+ aCat.getSize());



    }
}
