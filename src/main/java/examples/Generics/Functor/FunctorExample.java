package examples.Generics.Functor;

/**
 * https://stackoverflow.com/questions/7369460/help-with-understanding-a-function-object-or-functor-in-java
 * @param <T>
 */
public class FunctorExample<T> implements Functor<T>{
    @Override
    public void run() {
        System.out.println("Hello");
    }
}
