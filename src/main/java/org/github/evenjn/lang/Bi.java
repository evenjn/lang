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
 * A {@code Bi} object holds two references to objects, referred to as the
 * <em>front</em> and the <em>back</em>. There are no restrictions on the
 * references. One or both references may be {@code null}, and both references
 * may point to the same object. The referred objects need not be immutable or
 * satisfy any particular constraint.
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
public interface Bi<F, B> {

	/**
	 * @return The object in the <em>front</em> slot.
	 * @since 1.0
	 */
	F front( );

	/**
	 * @return The object in the <em>back</em> slot.
	 * @since 1.0
	 */
	B back( );
}
