/**
 *
 * Copyright 2018 Marco Trevisan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.github.evenjn.lang;

import java.util.LinkedList;

/**
 * <p>
 * {@code BasicRook} is an implementation of an
 * {@linkplain java.lang.AutoCloseable auto-closeable}
 * {@linkplain org.github.evenjn.lang.Rook Rook} that allows to close collected
 * resources at any time.
 * </p>
 * 
 * <p>
 * This class is part of package {@link org.github.evenjn.lang Lang}.
 * </p>
 * 
 * @since 1.0
 */
public final class BasicRook implements
		Rook,
		AutoCloseable {

	private final RuntimeException re;

	private boolean closed = false;

	private LinkedList<AutoCloseable> objects_to_close = null;

	/**
	 * <p>
	 * Constructor.
	 * </p>
	 * 
	 * @since 1.0
	 */
	public BasicRook() {
		try {
			throw new RuntimeException(
					"This exception might help find where this BasicRook was created." );
		}
		catch ( RuntimeException re ) {
			this.re = re;
		}
	}

	/**
	 * <p>
	 * {@code close} closes all resources still present in this {@code Rook},
	 * removes them from this {@code Rook} and closes this {@code BasicRook}.
	 * </p>
	 * 
	 * @throws RuntimeException
	 *           When one or more invocations of
	 *           {@link java.lang.AutoCloseable#close() close()} on the collected
	 *           resources throw exception.
	 * @since 1.0
	 */
	@Override
	public void close( ) {
		if ( closed ) {
			return;
		}
		try {
			clear( );
		}
		finally {
			objects_to_close = null;
			closed = true;
		}
	}

	/**
	 * <p>
	 * {@code clear} closes all resources still present in this {@code Rook} and
	 * removes them from this {@code Rook}.
	 * </p>
	 * 
	 * @throws IllegalStateException
	 *           When this {@code BasicRook} is closed.
	 * @throws RuntimeException
	 *           When one or more invocations of
	 *           {@link java.lang.AutoCloseable#close() close()} on the collected
	 *           resources throw exception.
	 * @since 1.0
	 */
	public void clear( ) {
		checkNotClosed( );
		if ( objects_to_close == null ) {
			return;
		}
		RuntimeException re = null;
		for ( AutoCloseable ac : objects_to_close ) {
			try {
				ac.close( );
			}
			catch ( Exception e ) {
				if ( re == null ) {
					re = new RuntimeException( e );
				}
				else {
					re.addSuppressed( e );
				}
			}
		}
		objects_to_close.clear( );
		if ( re != null ) {
			throw re;
		}
	}

	private void checkNotClosed( ) {
		if ( closed ) {
			throw new IllegalStateException( "This Rook is closed." );
		}
	}

	/**
	 * <p>
	 * {@code hook} gives this {@code BasicRook} the responsibility to close the
	 * argument object.
	 * </p>
	 * 
	 * @param <T>
	 *          the type of the object that needs to be closed.
	 * @param auto_closeable
	 *          the object that needs to be closed
	 * @return the argument {@code auto_closeable}.
	 * 
	 * @throws IllegalStateException
	 *           When this {@code BasicRook} is closed.
	 * @since 1.0
	 */
	@Override
	public <T extends AutoCloseable> T hook( T auto_closeable ) {
		checkNotClosed( );
		if ( objects_to_close == null ) {
			objects_to_close = new LinkedList<AutoCloseable>( );
		}
		objects_to_close.addFirst( auto_closeable );
		return auto_closeable;
	}

	@Override
	public void finalize( ) {
		if ( !closed ) {
			RuntimeException t = new RuntimeException(
					"This BasicRook is undergoing garbage collection but it has never been closed."
							+ " This may result in a resource leak." );
			t.addSuppressed( re );
			t.printStackTrace( );
			System.err.flush( );
		}
	}
}
