package examples.Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GenericsExampleTest {

    @org.junit.jupiter.api.Test
    void add() {
        GenericsExample<Integer> genericsExample = new GenericsExample<>();
        Integer[] arrTest = {1, 25, 20, 99};
        genericsExample.add(20);
    }

    @org.junit.jupiter.api.Test
    void contains() {
        GenericsExample<Integer> genericsExample = new GenericsExample<>();
        Integer[] arrTest = {1, 25, 20, 99};
        System.out.println("Contains: "+genericsExample.contains(arrTest, 25));
    }

    @org.junit.jupiter.api.Test
    void upper_sumOfList() {
        GenericsExample<Integer> genericsExample = new GenericsExample<>();
        Integer[] arrTest = {1, 25, 20, 99};
        System.out.println("Sum Of List: "+genericsExample.upper_sumOfList(Arrays.asList(arrTest)));
    }

    @org.junit.jupiter.api.Test
    void findMax() {
        GenericsExample<Integer> genericsExample = new GenericsExample<>();
        Integer[] arrTest = {1, 25, 20, 99};
        System.out.println("FindMax: "+genericsExample.findMax(arrTest));
    }

    @org.junit.jupiter.api.Test
    void improved_findMax() {
        GenericsExample<Integer> genericsExample = new GenericsExample<>();
        Integer[] arrTest = {1, 25, 20, 99};
        System.out.println("Improved FindMax: "+genericsExample.improved_findMax(arrTest));
    }

    @org.junit.jupiter.api.Test
    void lower_addToList(){
        GenericsExample<Integer> genericsExample = new GenericsExample<>();
        List<Number> arrTest = new ArrayList<>();
        genericsExample.lower_addToList(arrTest);
    }
}