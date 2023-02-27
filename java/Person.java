
public class Person {
  // "Class Variables" are declared with the static keyword
  // They pertain to the class as a whole.
  static Person the_king;  // ie the class Person has a single the_king
  static int population = 0;  // the class Person has a single population

  // "Instance Variables" or "Member Variables" do not have the static keyword
  // They are accessed via "this" (eg this.firstName) within methods which are not static
  String firstName;
  String lastName;
  
  public static Person getKingOfTheWorld() {
    return the_king;
  }
  public static void setKingOfTheWorld(Person newKing) { 
    // this is a "CLASS METHOD" (method called on a class) so "static"
    the_king = newKing;
  }
  public void makeKing() {
    the_king = this; // this is the instance that makeKing was called on, eg:   somebody when somebody.makeKing() is called
  }
  public static int population() {
    return population;
  }
  public static void usage() {
    System.out.println("
        java Person 
            shows this usage information
        java Person firstName  
            makes a person with firstName
    ");
  }
  public void init(String firstName) {
    this.firstName = firstName;
    population++; // every time init() is called we should increment the population on the class itself
  }
  public static void main(String[] args) { // having a main method means Person can be CALLED as a program
    if (args.length == 0) {
      Person.usage();  // show the usage if no args were passed
    } else {
      Person somebody = new Person(args[0]);  // Java has zero-indexed arrays, like C, so args[0] is the first String
      somebody.makeKing();  // an instance method call to make the instance somebody the_king
      // Person.setKingOfTheWorld(somebody);  // a static method way to make somebody the_king
      System.out.println("the population is" + Person.population());
    }
  }
}