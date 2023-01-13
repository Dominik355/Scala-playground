**Scala is a pure object-oriented language** in the sense that everything is an object, including numbers or functions. \
It differs from Java in that respect, since Java distinguishes primitive types (such as boolean and int) from reference types.

    object HelloWorld {
        def main(args: Array[String]): Unit = {
            println("Hello, World!")
        }
    }

**main** - method name\
**args: Array[String]** - array of String\
**Unit** - return type (equivalent to **Void**)\
**object** - singleton object - class with a single instance

The declaration above thus declares both a class called HelloWorld and an instance of that class, \
also called HelloWorld. This instance is created on demand, the first time it is used.

Another difference from Java is that the main method is not declared as static here. \
This is because static members (methods or fields) do not exist in Scala. Rather than defining static members, \
the Scala programmer declares these members in singleton objects.

**IMPORT**\
Scala’s import statement looks very similar to Java’s equivalent, however, it is more powerful. Multiple\
classes can be imported from the same package by enclosing them in curly braces as on the first line. \
Another difference is that when importing all the names of a package or class, in Scala 2 we use the\
underscore character (_) instead of the asterisk ( * ). ( * is used in Scala3)

multiple class import - _**import java.time.format.{DateTimeFormatter, FormatStyle}**_

**NUMBERS**\
Since numbers are objects, they also have methods. And in fact, an arithmetic expression like the following:\
**1 + 2 * 3 / x**\
consists exclusively of method calls, because it is equivalent to the following expression:\
**1.+(2.*(3)./(x))**\
This also means that +, *, etc. are valid identifiers for fields/methods/etc in Scala.

**Functions are objects**\
True to everything being an object, in Scala even functions are objects, going beyond Java’s support for lambda expressions.

In the following program, the timer function is called oncePerSecond, and it gets a call-back function as\
argument. The type of this function is written () => Unit and is the type of all functions which take no\
arguments and return no useful value (as before, the type Unit is similar to void in Java).\
The entry-point of this program calls oncePerSecond by directly passing the timeFlies method.\
In the end this program will infitely print the sentence time flies like an arrow every second.

    object Timer {
        def oncePerSecond(callback: () => Unit): Unit = {
            while (true) { callback(); Thread.sleep(1000) }
        }
        def timeFlies(): Unit = {
            println("time flies like an arrow...")
        }
        def main(args: Array[String]): Unit = {
            oncePerSecond(timeFlies)
        }
    }

**Anonymous functions**\
In Scala, lambda expressions are known as anonymous functions. They are useful when a function so short it \
is perhaps unneccesary to give them a name.\
Here is a revised version of the timer program, passing an anonymous function to oncePerSecond instead of timeFlies:

    object TimerAnonymous {
        def oncePerSecond(callback: () => Unit): Unit = {
            while (true) { callback(); Thread.sleep(1000) }
        }
        def main(args: Array[String]): Unit = {
            oncePerSecond(() =>
                println("time flies like an arrow..."))
        }
    }

**Classes**\
Classes in Scala are declared using a syntax which is close to Java’s syntax. One important difference is that \
classes in Scala can have parameters. This is illustrated in the following definition of complex numbers.

    class Complex(real: Double, imaginary: Double) {
        def re() = real
        def im() = imaginary
    }

The class contains two methods, called re and im, which give access to these two parts.\
This Complex class takes two arguments, which are the real and imaginary part of the complex number. \
These arguments must be passed when creating an instance of class Complex, as follow

    new Complex(1.5, 2.3)

It should be noted that the return type of these two methods is not given explicitly. It will be inferred \
automatically by the compiler, which looks at the right-hand side of these methods and deduces that both \
return a value of type Double.

**Important**: The inferred result type of a method can change in subtle ways if the implementation changes, \
which could have a knock-on effect. Hence it is a best practise to put explicit result types for public \
members of classes.

It would be nicer to be able to access the real and imaginary parts like if they were fields, without putting \
the empty pair of parenthesis. This is perfectly doable in Scala, simply by defining them as methods without \
arguments. Such methods differ from methods with zero arguments in that they don’t have parenthesis after their \
name, neither in their definition nor in their use. Our Complex class can be rewritten as follows:

    class Complex(real: Double, imaginary: Double) {
        def re = real
        def im = imaginary
    }

**TRAIT**\
Apart from inheriting code from a super-class, a Scala class can also import code from one or several traits.\
Maybe the easiest way for a Java programmer to understand what traits are is to view them as interfaces which can also contain code.\
In Scala, when a class inherits from a trait, it implements that trait’s interface, and inherits all the code contained in the trait.\

o see the usefulness of traits, let’s look at a classical example: ordered objects. It is often useful to be able to compare objects\
of a given class among themselves, for example to sort them. In Java, objects which are comparable implement the Comparable interface.\
In Scala, we can do a bit better than in Java by defining our equivalent of Comparable as a trait, which we will call Ord.

When comparing objects, six different predicates can be useful: smaller, smaller or equal, equal, not equal, greater or equal, and greater.\
However, defining all of them is fastidious, especially since four out of these six can be expressed using the remaining two.

    trait Ord {
        def < (that: Any): Boolean
        def <=(that: Any): Boolean =  (this < that) || (this == that)
        def > (that: Any): Boolean = !(this <= that)
        def >=(that: Any): Boolean = !(this < that)
    }

This definition both creates a new type called Ord, which plays the same role as Java’s Comparable interface,\
and default implementations of three predicates in terms of a fourth, abstract one.\
The predicates for equality and inequality do not appear here since they are by default present in all objects.