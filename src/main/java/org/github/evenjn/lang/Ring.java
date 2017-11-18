package org.github.evenjn.lang;

/**
 * <p>
 * A {@code Ring} is a system that returns an object after passing the
 * responsibility to close associated resources to an argument
 * {@link org.github.evenjn.lang.Rook Rook}.
 * </p>
 * 
 * <p>
 * The {@link #get(Rook)} method can only be invoked once.
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
	 * Returns an object after passing the responsibility to close associated
	 * resources to the argument {@link org.github.evenjn.lang.Rook Rook}.
	 * </p>
	 * 
	 * @param rook
	 *          A {@link org.github.evenjn.lang.Rook Rook}.
	 * @return An output object.
	 * @since 1.0
	 */
	T get( Rook rook );
}
