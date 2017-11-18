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
 * An {@code Equivalencer} object compares two objects and computes whether they
 * are equivalent or not.
 * </p>
 * 
 * <p>
 * This class is part of package {@link org.github.evenjn.lang Lang}.
 * </p>
 *
 * @param <X>
 *          The type of the first object of the comparison.
 * @param <Y>
 *          The type of the second object of the comparison.
 * @since 1.0
 */
@FunctionalInterface
public interface Equivalencer<X, Y> {

	/**
	 * Compares two objects and tells whether they are equivalent or not.
	 * 
	 * @param x
	 *          The first object of the comparison.
	 * @param y
	 *          The second object of the comparison.
	 * @return {@code true} when the arguments are equivalent. {@code false}
	 *         otherwise.
	 * @since 1.0
	 */
	boolean equivalent( X x, Y y );

	/**
	 * 
	 * @return An {@code Equivalencer} that carries out the same computation as
	 *         {@code this}, but takes its arguments in swapped order.
	 */
	default Equivalencer<Y, X> swap( ) {
		Equivalencer<X, Y> e = this;
		return new Equivalencer<Y, X>( ) {

			@Override
			public boolean equivalent( Y y, X x ) {
				return e.equivalent( x, y );
			}

		};
	}
}
