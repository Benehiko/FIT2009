package examples.Generics;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Restrictions on Generics
 * - Primitive Types cannot be used for a type parameter
 * - Static methods and fields cannot refer to the class's type variable
 * - It is illegal to create an instance of a generic type
 * - It is illegal to create an array of a generic type
 * <p>
 * In this case T is a Generic specifying any type.
 *
 * @param <T>
 */
class GenericsExample<T> {

    // Array Of any type
    private T[] items;

    GenericsExample() {
        items = (T[]) new Object[2];
    }

    /**
     * Add to the array. This is quite tricky as it is illegal to just add an item of any type
     *
     * @param item of type T
     */
    void add(T item) {

        //Increase the array size
        T[] old = this.items;

        items = (T[]) new Object[items.length * 2 + 1];

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

        this.items[this.items.length - 1] = item;

    }

    /**
     * Example of method with any type generic
     *
     * @param items array of type T
     * @param item  item of type T
     * @param <T>   Uses type T
     * @return boolean
     */
    <T> boolean contains(T[] items, final T item) {

        for (T value : items) {
            if (item.equals(value)) {
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

    /**
     * https://docs.oracle.com/javase/tutorial/java/generics/upperBounded.html
     * Upper Bounded Wildcard
     * Accepts any number type which subclasses Number
     *
     * @param arrNumb extends Number type and all subtypes
     * @return double
     */
    double upper_sumOfList(List<? extends Number> arrNumb) {

        double sum = 0;
        for (Number n : arrNumb) {
            sum += n.doubleValue();
        }
        return sum;

    }

    /**
     * https://docs.oracle.com/javase/tutorial/java/generics/lowerBounded.html
     * Lower Bounded Wildcard
     *
     * @param arrNumb super types of Integer
     **/
    void lower_addToList(List<? super Integer> arrNumb) {
        for (int i = 0; i <= 10; i++) {
            arrNumb.add(i);
        }
    }

    /**
     * Type Bounds
     * Param <T extends Comparable<? super T>> is needed since compareTo requires to force Array of Type T to have Comparable
     *
     * @param a   generic type T array
     * @param <T> specify type T extends Comparable
     * @return T
     */
    <T extends Comparable<? super T>> T findMax(T[] a) {

        int maxIndex = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i].compareTo(a[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return a[maxIndex];
    }

    /**
     * findMax but just compressed using java 8 lambda
     *
     * @param <T> forcing type generic to inherit Comparable properties
     * @param a   array of generic type
     * @return generic type T (value or null)
     */
    <T extends Comparable<? super T>> T improved_findMax(T[] a) {
        Optional<T> max = Arrays.stream(a).max((t, t1) -> t.compareTo(t1));
        return max.isPresent() ? max.get() : null;
    }


}
