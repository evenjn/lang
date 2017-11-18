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
 * A {@code Silencer} provides methods to silence checked exceptions.
 * </p>
 * 
 * <p>
 * This class is part of package {@link org.github.evenjn.lang Lang}.
 * </p>
 * 
 * @since 1.0
 */
public interface Silencer {

	/**
	 * <p>
	 * Reports that an exception was caught, and the computation cannot continue.
	 * Wraps the argument exception into a {@link java.lang.RuntimeException
	 * RuntimeException} and returns it. The invoker must throw the returned
	 * {@link java.lang.RuntimeException RuntimeException}.
	 * </p>
	 * 
	 * @param throwable
	 *          A {@link java.lang.Throwable Throwable}.
	 * @return A {@link java.lang.RuntimeException RuntimeException} wrapping the
	 *         argument throwable.
	 * @since 1.0
	 */
	RuntimeException quit( Throwable throwable );

	/**
	 * <p>
	 * Reports that an exception was caught and the computation will continue.
	 * </p>
	 * 
	 * @param throwable
	 *          A {@link java.lang.Throwable Throwable}.
	 * @since 1.0
	 */
	void log( Throwable throwable );

}
