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
 * A {@code BiOptional} object is a {@link Bi} object that may have empty slots.
 * The content of an empty slot is {@code null}.
 * </p>
 * 
 * <p>
 * This class is part of package {@link org.github.evenjn.lang Lang}.
 * </p>
 *
 * @param <F>
 *          The type of the object in the <em>front</em> slot.
 * @param <B>
 *          The type of the object in the <em>back</em> slot.
 * @since 1.0
 */
public interface BiOptional<F, B> extends
		Bi<F, B> {

	/**
	 * @return The object in the <em>front</em> slot.
	 * @since 1.0
	 */
	@Override
	F front( );

	/**
	 * @return The object in the <em>back</em> slot.
	 * @since 1.0
	 */
	@Override
	B back( );

	/**
	 * @return {@code true} when the <em>back</em> slot is not empty.
	 *         {@code false} otherwise.
	 * @since 1.0
	 */
	boolean hasFront( );

	/**
	 * @return {@code true} when the <em>front</em> slot is not empty.
	 *         {@code false} otherwise.
	 * @since 1.0
	 */
	boolean hasBack( );

	/**
	 * @return {@code true} when both the <em>front</em> slot and the
	 *         <em>back</em> slot are not empty. {@code false} otherwise.
	 * @since 1.0
	 */
	boolean hasBoth( );
}
