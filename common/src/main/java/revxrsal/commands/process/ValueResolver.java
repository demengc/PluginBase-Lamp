/*
 * This file is part of lamp, licensed under the MIT License.
 *
 *  Copysecond (c) Revxrsal <reflxction.github@gmail.com>
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the seconds
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copysecond notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */
package revxrsal.commands.process;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;
import revxrsal.commands.annotation.Single;
import revxrsal.commands.command.ArgumentStack;
import revxrsal.commands.command.CommandParameter;
import revxrsal.commands.exception.CommandExceptionHandler;
import revxrsal.commands.exception.InvalidNumberException;
import revxrsal.commands.process.ParameterResolver.ParameterResolverContext;

/**
 * A resolver for resolving values that, by default, require data from the arguments to resolve
 * their value. An example context resolver is finding a player from their name.
 *
 * @param <T> The resolved type
 */
public interface ValueResolver<T> {

  /**
   * Resolves the value of this resolver
   *
   * @param context The command resolving context.
   * @return The resolved value. May or may not be null.
   * @throws Throwable Any exceptions that should be handled by {@link CommandExceptionHandler}
   */
  T resolve(@NotNull ValueResolverContext context) throws Throwable;

  /**
   * Represents the resolving context of {@link ValueResolver}. This contains all the relevant
   * information about the resolving context.
   */
  interface ValueResolverContext extends ParameterResolverContext {

    /**
     * Returns the command arguments passed to the command.
     * <p>
     * This stack may have been modified by previous resolvers, and there is no guarantee that its
     * content matches the actor input.
     * <p>
     * To access the original, unmodified input of the actor, see {@link #input()}.
     *
     * @return The argument stack
     */
    ArgumentStack arguments();

    /**
     * Returns (and removes) the string in which might get concatenated with the rest of the
     * arguments if the {@link #parameter()} consumes all strings that follow it.
     * <p>
     * This is equivilent to calling {@code arguments().popForParameter(parameter())}
     *
     * @return The string for this parameter. Will return the first argument if the parameter cannot
     * consume all strings.
     * @see CommandParameter#consumesAllString()
     * @see Single
     * @see ArgumentStack#popForParameter(CommandParameter).
     */
    String popForParameter();

    /**
     * Returns (and removes) the first value in the {@link #arguments() argument stack}.
     *
     * @return The first value.
     * @throws NoSuchElementException if the stack is empty
     */
    String pop();

    /**
     * Returns (and removes) the first value in the {@link #arguments() argument stack} and parses
     * it into an integer.
     *
     * @return The first value, as an int.
     * @throws NoSuchElementException if the stack is empty
     * @throws InvalidNumberException if an invalid number is inputted
     */
    int popInt();

    /**
     * Returns (and removes) the first value in the {@link #arguments() argument stack} and parses
     * it into a double.
     *
     * @return The first value, as a double.
     * @throws NoSuchElementException if the stack is empty
     * @throws InvalidNumberException if an invalid number is inputted
     */
    double popDouble();

    /**
     * Returns (and removes) the first value in the {@link #arguments() argument stack} and parses
     * it into a byte.
     *
     * @return The first value, as a byte.
     * @throws NoSuchElementException if the stack is empty
     * @throws InvalidNumberException if an invalid number is inputted
     */
    byte popByte();

    /**
     * Returns (and removes) the first value in the {@link #arguments() argument stack} and parses
     * it into a short.
     *
     * @return The first value, as a short.
     * @throws NoSuchElementException if the stack is empty
     * @throws InvalidNumberException if an invalid number is inputted
     */
    short popShort();

    /**
     * Returns (and removes) the first value in the {@link #arguments() argument stack} and parses
     * it into a float.
     *
     * @return The first value, as a float.
     * @throws NoSuchElementException if the stack is empty
     * @throws InvalidNumberException if an invalid number is inputted
     */
    float popFloat();

    /**
     * Returns (and removes) the first value in the {@link #arguments() argument stack} and parses
     * it into a long.
     *
     * @return The first value, as a long.
     * @throws NoSuchElementException if the stack is empty
     * @throws InvalidNumberException if an invalid number is inputted
     */
    long popLong();

  }

}
