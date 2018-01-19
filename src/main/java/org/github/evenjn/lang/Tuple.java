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

/**
 * <p>
 * A {@code Tuple} provides indexed access to a finite sequence of objects.
 * </p>
 * 
 * <h2>Service Contract</h2>
 * 
 * <p>
 * An object implementing the {@code Tuple} interface fulfils the following
 * contract.
 * </p>
 * 
 * <p>
 * The {@link #size()} method never returns a negative number.
 * </p>
 * 
 * <h2>Disclaimer</h2>
 * 
 * <p>
 * An object implementing the {@code Tuple} interface does not provide implicit
 * guarantees.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that element references are not {@code null}.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that any two element references refer to
 * distinct objects
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that, after an invocation of
 * {@link #get(int)}, the element references returned at previous invocations
 * are valid.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that objects returned by invocations of
 * {@link #get(int)} are not affected by subsequent invocations of
 * {@link #get(int)}.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee of thread safety. This means that a system
 * that receives a {@code Tuple} should not assume that it is safe to have
 * multiple threads invoke {@link #get(int)} on the same object.
 * </p>
 * 
 * <p>
 * However, classes implementing {@code Tuple} or interfaces extending
 * {@code Tuple} might provide explicit guarantees.
 * </p>
 * 
 * <p>
 * This class is part of package {@link org.github.evenjn.lang Lang}.
 * </p>
 * 
 * @param <T>
 *          The type of objects in the sequence.
 * @since 1.0
 */
public interface Tuple<T> {

	/**
	 * <p>
	 * {@code get} returns the object at position {@code index} in the sequence.
	 * </p>
	 * 
	 * @param index
	 *          The position of the object to retrieve.
	 * @return The object at position {@code index} in the sequence.
	 * @throws IllegalArgumentException
	 *           when {@code index} is negative, when {@code index} is not smaller
	 *           than the size of this sequence.
	 * @since 1.0
	 */
	T get( int index )
			throws IllegalArgumentException;

	/**
	 * <p>
	 * {@code size} returns the size of the sequence.
	 * </p>
	 * 
	 * @return The size of the sequence.
	 * @since 1.0
	 */
	int size( );

}
