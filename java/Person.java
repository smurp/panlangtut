/*
 This simple class demonstrates many basic concepts of Java programming in one file.

 compile this with:
   javac Person.java
 run the compiled version with:
   java Person
 Compile and run this in one line in these various ways:
   javac Person.java && java Person
   javac Person.java && java Person Sydney
   javac Person.java && java Person Sydney McGillicuddy
*/
public class Person {
  // "Class Variables" are declared with the static keyword
  // They pertain to the class as a whole.
  static Person the_king;  // ie the class Person has a single the_king
  static int population = 0;  // the class Person has a single population

  // "Instance Variables" or, as they are referred to in Java, "Member Variables" do not have the static keyword
  // They are accessed via "this" (eg this.firstName) within methods which are not static
  String firstName;
  String lastName; // not currently used, we should really remove this or use it!

  // in Java it is typical to put the Constructor up at the top of the class
  public Person(String fn) { // this is the "Constructor" method, which gets called like this: new Person("Sydney");
    this.firstName = fn;
    population++; // every time init() is called we should increment the population on the class itself
  }

  // These are the "Class Methods", distinguished by having the "static" keyword
  public static Person getKingOfTheWorld() {
    return the_king;
  }
  public static void setKingOfTheWorld(Person newKing) {
    // this is a "CLASS METHOD" (method called on a class) so "static"
    the_king = newKing;
  }
  public static int population() {
    return population;
  }
  public static void usage() {
    // Java 15 provides """multi-line string""" syntax but we build one using nl so it works on older Java
    String nl = System.getProperty("line.separator"); // the OS-specific character sequence for doing new line
    // See https://en.wikipedia.org/wiki/Newline for the gritty details
    System.out.println(
                       "java Person" + nl +
                       "    shows this usage information" + nl +
                       "java Person firstName" + nl +
                       "    makes a person with firstName");
  }
  // Next are the "Instance Methods", which are distinguished by not being have the "static" keyword
  public void makeKing() {
    // "this" is the instance that makeKing was called on, eg: somebody when somebody.makeKing() is called
    the_king = this;
  }
  /*
    Having a main() method means this Person class can be CALLED as a command line program.
    There is a long tradition (established by C) of putting main() at the bottom of a file.
  */
  public static void main(String[] args) { // args contains the command line arguments
    if (args.length == 0) {
      Person.usage();  // show the usage if no args were passed
    } else {
      Person somebody = new Person(args[0]);  // Java has zero-indexed arrays, like C, so args[0] is the first String
      somebody.makeKing();  // an instance method call to make the instance somebody the_king
      // Person.setKingOfTheWorld(somebody);  // a static method way to make somebody the_king
      System.out.println("the population is " + Person.population() +
                         " and " + the_king.firstName + " is king");
    }
  }
}
/*
  I still use terminals, so strive to keep lines shorter than 80 characters,
  but that was relaxed above.  That was because I was commenting some very
  basic things which would normally not be commented on in a real program.
  This should be fixed, to demonstrate the style and to cover my shame. :-)
  https://en.wikipedia.org/wiki/Characters_per_line
*/
