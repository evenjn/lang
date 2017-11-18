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

	@Override
	public RuntimeException quit( Throwable throwable ) {
		return new RuntimeException( throwable );
	}

	@Override
	public void log( Throwable throwable ) {
		throwable.printStackTrace( );
	}

}
