/**
 *
 * Copyright 2016 Marco Trevisan
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

import java.util.Iterator;
import java.util.LinkedList;

import org.github.evenjn.lang.Rook;

/**
 * <p>
 * {@code BasicRook} is a simple implementation of an
 * {@linkplain java.lang.AutoCloseable autocloseable}
 * {@linkplain org.github.evenjn.lang.Rook Rook}.
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

	private LinkedList<AutoCloseable> objects_to_close;

	private boolean closed = false;

	@Override
	public void close( ) {
		if ( closed ) {
			throw new IllegalStateException(
					"BasicRook cannot be closed more than once." );
		}
		if ( objects_to_close != null ) {
			Iterator<AutoCloseable> it = objects_to_close.descendingIterator( );
			while ( it.hasNext( ) ) {
				try {
					it.next( ).close( );
				}
				catch ( Exception e ) {
					throw new RuntimeException( e );
				}
			}
			objects_to_close = null;
		}
		closed = true;
	}

	@Override
	public <T extends AutoCloseable> T hook( T auto_closeable ) {
		if ( objects_to_close == null ) {
			objects_to_close = new LinkedList<AutoCloseable>( );
		}
		objects_to_close.add( auto_closeable );
		return auto_closeable;
	}
}
