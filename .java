// does it run? yes
import java.util.Scanner;

class Main {

  private static Scanner scan = new Scanner(System.in);
  
  public static void main(String[] args) {
    //Welcome traveler to our Guild Hall
    System.out.println(
      "=======================================\n" +
      "============ Now Entering =============\n" +
      "============== Owl Guild ==============\n" +
      "=======================================\n"
    );

    System.out.println("\n " + "\n"+ "hoot hoot");
    
   System.out.println("Greetings! " + "Take a seat where ever you like!");
    //Create menu for food
    OwlGuild owlGuild = new OwlGuild();
    owlGuild.init();

    //Create a loop till they leave
     boolean run = true;
    while (run){
    // give options
      System.out.println();
   

      int choice = chooseCafe(owlGuild);

      Cafe chosenCafe;
      try{
        chosenCafe = owlGuild.getCafe().get(choice - 1);
      } catch (IndexOutOfBoundsException ex){
        break;
      }
      
      choice = chooseFood(chosenCafe);

      
      switch(choice){
        case 1:
          System.out.println("First food choice");
          System.out.println(chosenCafe.getCafefood().get(choice - 1));
          break;
        case 2:
          System.out.println("Second food choice");
          System.out.println(chosenCafe.getCafefood().get(choice - 1));
          break;
        case 3:
          System.out.println("Third food choice");
          System.out.println(chosenCafe.getCafefood().get(choice - 1));
          break;
        default:
          System.out.println("What did you say??");
          break;
      }

    }
    //good bye
      System.out.println("You're off then?");
    scan.close();
  }

  public static int chooseCafe(OwlGuild owlGuild){
    System.out.println("\nSelect and Food:");
    for (int i = 0; i < owlGuild.getCafe().size(); i++) {
      System.out.println((i + 1)+ ") " + owlGuild.getCafe().get(i).getName());
    }
    System.out.println("4) Leave OwlGuild");
    return scan.nextInt(); 
  }
    public static int chooseFood(Cafe chosenCafe){
      System.out.println("\nWhat would you like?");
      for (int i = 0; i < chosenCafe.getCafefood().size(); i++) {
        System.out.println((i + 1) + ") " + chosenCafe.getCafefood().get(i).getName());
      } 
          System.out.println("4) Manu");

      return scan.nextInt();
    }
}
