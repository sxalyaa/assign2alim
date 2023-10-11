package factory_design_pattern;
// Abstract class representing a generic vehicle.
abstract class Vehicle 
{
	 public abstract int getWheel();
	 public String toString() 
	 {
	    return "Wheel: " + this.getWheel();
	 }
}
// Concrete class representing a car.
class Car extends Vehicle 
{
     int wheel;
	 Car(int wheel)
	 {
	    this.wheel = wheel;
	 }

	 @Override
	 public int getWheel() 
	 {
	    return this.wheel;
	 }
}
// Concrete class representing a bike.
class Bike extends Vehicle 
{
	 int wheel;
	 Bike(int wheel) 
	 {
	    this.wheel = wheel;
	 }
	  
	 @Override
	 public int getWheel()
	 {
	    return this.wheel;
	 }
}

// Factory class responsible for creating instances of vehicles.
class VehicleFactory
{
	 public static Vehicle getInstance(String type, int wheel)
	 {
	    if(type == "car") 
	    {
	       return new Car(wheel);
	    } 
	    else if(type == "bike") 
	    {
	       return new Bike(wheel);
	    }
	    return null;
	 }
}
// Main class where the program starts execution.
public class FactoryPattern
{
     public static void main(String[] args) 
	 {
	    Vehicle car = VehicleFactory.getInstance("car", 4);
	    System.out.println(car);
	    
	    Vehicle bike = VehicleFactory.getInstance("bike", 2);
	    System.out.println(bike);
	 }
}