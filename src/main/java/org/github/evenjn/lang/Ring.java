package org.github.evenjn.lang;

/**
 * <p>
 * A {@code Ring} returns an object after giving a
 * {@link org.github.evenjn.lang.Rook Rook} the responsibility to close all
 * resources associated with that object .
 * </p>
 * 
 * <h2>Disclaimer</h2>
 * 
 * <p>
 * An object implementing the {@code Ring} interface does not provide implicit
 * guarantees.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that {@link #get(Rook)} never returns
 * {@code null}.
 * </p>
 * 
 * <p>
 * There is no guarantee that {@link #get(Rook)} can be invoked more than once.
 * </p>
 * 
 * <p>
 * However, classes implementing Ring or interfaces extending Ring might provide
 * explicit guarantees.
 * </p>
 * 
 * <p>
 * This class is part of package {@link org.github.evenjn.lang Lang}.
 * </p>
 * 
 * @param <T>
 *          The type of the returned object.
 * @since 1.0
 */
@FunctionalInterface
public interface Ring<T> {

	/**
	 * <p>
	 * Returns an object after giving the argument
	 * {@link org.github.evenjn.lang.Rook Rook} the responsibility to close all
	 * associated resources.
	 * </p>
	 * 
	 * @param rook
	 *          A {@link org.github.evenjn.lang.Rook Rook}.
	 * @return An object.
	 * @since 1.0
	 */
	T get( Rook rook );
}
