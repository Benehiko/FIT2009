package examples.Generics.Functor.CompressedFunctor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdentityTest {

    @Test
    void map() {
        Identity<String> idString = new Identity<>("abc");
        Identity<Integer> idInt = idString.map(String::length);

        /* OR */
        Identity<Number> idBytes = new Identity<>(123).map(Integer::doubleValue);


    }
}