package examples.Generics.Functor.CompressedFunctor;

import java.util.function.Function;

/**
 * https://dzone.com/articles/functor-and-monad-examples-in-plain-java
 * @param <T>
 * @param <I>
 */
public interface FunctionBuilder<T, I extends FunctionBuilder<?,?>> {

    <R> FunctionBuilder map(Function<T, R> f);
}
