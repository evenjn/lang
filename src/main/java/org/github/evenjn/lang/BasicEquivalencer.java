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
 * {@code BasicEquivalencer} is an implementation of an
 * {@linkplain org.github.evenjn.lang.Equivalencer Equivalencer}, with an
 * implementation of {@link #equivalent} that relies on
 * {@link java.lang.Object#equals(Object) equals} and supports {@code null}
 * arguments.
 * </p>
 * 
 * <p>
 * This class is part of package {@link org.github.evenjn.lang Lang}.
 * </p>
 * 
 * @since 1.0
 */
public class BasicEquivalencer<X, Y> implements
		Equivalencer<X, Y> {

	/**
	 * <p>
	 * {@code equivalent} relies on {@link java.lang.Object#equals(Object) equals}
	 * to tell whether two objects are equivalent or not. When both arguments are
	 * {@code null}, it returns {@code true}. When one is {@code null} and the
	 * other is not {@code null}, it returns {@code false}. Otherwise, it invokes
	 * {@link java.lang.Object#equals(Object) equals} on the
	 * <strong>first</strong> object, passing the second object as argument.
	 * </p>
	 * 
	 * @param x
	 *          The first object of the comparison.
	 * @param y
	 *          The second object of the comparison.
	 * @return {@code true} when the arguments are equivalent. {@code false}
	 *         otherwise.
	 * @since 1.0
	 */
	@Override
	public boolean equivalent( X x, Y y ) {
		if ( x == null && y == null )
			return true;
		if ( x == null || y == null )
			return false;
		return x.equals( y );
	}
}
