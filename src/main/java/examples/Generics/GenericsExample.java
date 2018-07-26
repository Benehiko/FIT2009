package examples.Generics;


import java.util.Arrays;

// In this case T is specifying any type.
public class GenericsExample<T> {

    // Array Of any type
    private T[] items;

    /**
     * Add to the array. This is quite tricky as it is illegal to just add an item of any type
     * @param item
     */
    public void add(T item){

        //Increase the array size
        T[] old = this.items;

        this.items = (T[])new Object[items.length*2 + 1];

        /* This is illegal
        this.items = new T[items.length*2 + 1];
        */

        /*
        for (int i = 0; i < items.length; i++){
            this.items[i] = old[i];
        }
        */

        /* For less code you could also call the copyArray method */
        System.arraycopy(old, 0, items, 0, old.length);

        this.items[this.items.length-1] = item;

    }

    /**
     * Example of static method with any type generic
     * @param items
     * @param item
     * @param <T>
     * @return
     */
    public static <T> boolean contains(T[] items, final T item){

        for (T value : items){
            if (item.equals(value)){
                return true;
            }
        }

        /* Compress the contains into a lambda expression
        return Arrays.asList(items).stream().anyMatch(i -> item.equals(i));
        */

        /* Compress the contains with method reference
        return Arrays.stream(items).anyMatch(item::equals);
         */

        /* Or Simply use Contains
        return Arrays.asList(items).contains(item);
         */


        return false;
    }
}
