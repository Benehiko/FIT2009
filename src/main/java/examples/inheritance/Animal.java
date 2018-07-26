package examples.inheritance;

public abstract class Animal {

    protected int legs;
    protected int size;

    protected Animal(){
        this.legs = 0;
        this.size = 1;
    }

    protected Animal(int legs, int size){
        this.legs = legs;
        this.size = size;
    }

    protected int getLegs() {
        return legs;
    }

    protected int getSize() {
        return size;
    }
}
