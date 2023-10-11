package builder_design_pattern;
// This is the main class where the program starts execution.
// This class represents a vehicle and contains attributes like engine, wheel, and airbags.
class Vehicle 
{
  private String engine;
  private int wheel;
  private int airbags;
  
  public String getEngine() 
  {
    return this.engine;
  }
  
  public int getWheel() 
  {
    return this.wheel;
  }
  
  public int getAirbags()
  {
    return this.airbags;
  }
  
  private Vehicle(VehicleBuilder builder)
  {
    this.engine = builder.engine;
    this.wheel = builder.wheel;
    this.airbags = builder.airbags;
  }
  // This is a static inner class responsible for building a Vehicle object.
  public static class VehicleBuilder
  {
    private String engine;
    private int wheel;
    private int airbags;
    
    public VehicleBuilder(String engine, int wheel)
    {
      this.engine = engine;
      this.wheel = wheel;
    }
    
    public VehicleBuilder setAirbags(int airbags) 
    {
      this.airbags = airbags;
      return this;
    }
    
    public Vehicle build() 
    {
      return new Vehicle(this);
    }
  }
}

public class BuilderPattern
{
  public static void main(String[] args) 
  {
    // Creating a car with a 1500cc engine, 4 wheels, and 4 airbags.
    Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();
    // Creating a bike with a 250cc engine, 2 wheels, and no specified airbags.
    Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();
    // Printing details of the car.
    System.out.println(car.getEngine());
    System.out.println(car.getWheel());
    System.out.println(car.getAirbags());
    // Printing details of the bike.
    System.out.println(bike.getEngine());
    System.out.println(bike.getWheel());
    System.out.println(bike.getAirbags());
  }
}