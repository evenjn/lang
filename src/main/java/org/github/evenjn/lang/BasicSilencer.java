package org.github.evenjn.lang;

/**
 * <p>
 * {@code BasicSilencer} is a simple implementation of a
 * {@linkplain org.github.evenjn.lang.Silencer Silencer}.
 * </p>
 * 
 * <p>
 * This class is part of package {@link org.github.evenjn.lang Lang}.
 * </p>
 * 
 * @since 1.0
 */
public class BasicSilencer implements
		Silencer {

	/**
	 * <p>
	 * {@code quit} wraps the argument throwable into a
	 * {@link java.lang.RuntimeException RuntimeException} and returns it. The
	 * invoker must throw the returned {@link java.lang.RuntimeException
	 * RuntimeException}.
	 * </p>
	 * 
	 * @param throwable
	 *          A {@link java.lang.Throwable Throwable}.
	 * @return A {@link java.lang.RuntimeException RuntimeException} wrapping the
	 *         argument throwable.
	 * @since 1.0
	 */
	@Override
	public RuntimeException quit( Throwable throwable ) {
		return new RuntimeException( throwable );
	}

	/**
	 * <p>
	 * {@code log} prints this throwable and its backtrace to the standard error
	 * stream.
	 * </p>
	 * 
	 * @param throwable
	 *          A {@link java.lang.Throwable Throwable}.
	 * @since 1.0
	 */
	@Override
	public void log( Throwable throwable ) {
		throwable.printStackTrace( );
	}

}
