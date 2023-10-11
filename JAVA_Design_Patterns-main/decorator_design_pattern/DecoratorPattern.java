package decorator_design_pattern;
// Define an interface for different types of dresses.
interface Dress
{
	 public void assemble();
}
// Concrete class implementing the Dress interface with basic features.
class BasicDress implements Dress 
{
	 @Override
	 public void assemble()
	 {
	    System.out.println("Basic Dress Features");
	 }
}
// Abstract decorator class implementing the Dress interface.
class DressDecorator implements Dress
{
	 protected Dress dress;
	// Constructor to accept a Dress object to decorate.
	 public DressDecorator(Dress c)
	 {
	    this.dress = c;
	 }
	 @Override
	 // Delegates the assemble() call to the wrapped dress.
	 public void assemble() 
	 {
	    this.dress.assemble();
	  }
}
// Concrete decorator class adding casual features.
class CasualDress extends DressDecorator 
{
	 public CasualDress(Dress c) 
	 {
	    super(c);
	 }
	  
	 @Override
	 public void assemble() 
	 {
	    super.assemble();
	    System.out.println("Adding Casual Dress Features");
	 }
}
// Concrete decorator class adding sporty features.
class SportyDress extends DressDecorator 
{
	 public SportyDress(Dress c) 
	 {
	    super(c);
	 }
	  
	 @Override
	 public void assemble() 
	 {
	    super.assemble();
	    System.out.println("Adding Sporty Dress Features");
	 }
}
// Concrete decorator class adding fancy features.
class FancyDress extends DressDecorator
{
	 public FancyDress(Dress c) 
	 {
	    super(c);
	 }
	  
	 @Override
	 public void assemble()
	 {
	    super.assemble();
	    System.out.println("Adding Fancy Dress Features");
	 }
}

// Main class demonstrating the Decorator pattern.
public class DecoratorPattern
{
	  public static void main(String[] args) 
	  {
		  // Creating various dress combinations and assembling them.

		  // 1. Sporty Dress on top of Basic Dress
	      Dress sportyDress = new SportyDress(new BasicDress());
	      sportyDress.assemble();
	      System.out.println();
		  // 2. Fancy Dress on top of Basic Dress
	      Dress fancyDress = new FancyDress(new BasicDress());
	      fancyDress.assemble();
	      System.out.println();
		  // 3. Casual Dress on top of Basic Dress
	      Dress casualDress = new CasualDress(new BasicDress());
	      casualDress.assemble();
	      System.out.println();
		  // 4. Sporty Dress on top of Fancy Dress on top of Basic Dress
	      Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
	      sportyFancyDress.assemble();
	      System.out.println();
		  // 5. Casual Dress on top of Fancy Dress on top of Basic Dress
	      Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
	      casualFancyDress.assemble();
	  }
}