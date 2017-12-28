/**
 *
 * Copyright 2017 Marco Trevisan
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

/**
 * <p>
 * A {@code Rook} is a system that takes the responsability to close any
 * {@link java.lang.AutoCloseable auto-closeable} objects it receives.
 * </p>
 * 
 * <p>
 * Methods that take as argument a {@code Rook} typically return objects that
 * can no longer be used after the autocloseable objects
 * {@linkplain #hook(AutoCloseable) hooked} to that {@code Rook} are closed.
 * </p>
 * 
 * <p>
 * This class is part of package {@link org.github.evenjn.lang Lang}.
 * </p>
 * 
 * @since 1.0
 */
public interface Rook {

	/**
	 * <p>
	 * Gives this {@code Rook} the responsibility to close the argument object.
	 * </p>
	 * 
	 * @param <T>
	 *          the type of the object that needs to be closed.
	 * @param auto_closeable
	 *          the object that needs to be closed
	 * @return the argument {@code auto_closeable}.
	 * @since 1.0
	 */
	<T extends java.lang.AutoCloseable> T hook( T auto_closeable );
}
