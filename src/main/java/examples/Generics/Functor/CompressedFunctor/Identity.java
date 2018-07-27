package examples.Generics.Functor.CompressedFunctor;

import java.util.function.Function;

/**
 * https://dzone.com/articles/functor-and-monad-examples-in-plain-java
 * @param <T>
 */
public class Identity<T> implements FunctionBuilder<T, Identity<?>> {

    private final T value;

    /**
     *
     * @param value generic
     */
    public Identity(T value){
        this.value = value;
    }

    @Override
    public <R> Identity<R> map(Function<T, R> f) {
        final R result = f.apply(value);
        return new Identity<>(result);
    }

}
