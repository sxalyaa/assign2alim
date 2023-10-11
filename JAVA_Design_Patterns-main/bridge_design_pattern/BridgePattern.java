package bridge_design_pattern; // Package declaration for organizing classes

abstract class TV
{
    Remote remote; // Declare a reference to a Remote object

    // Constructor that accepts a Remote object and assigns it to the 'remote' variable
    TV(Remote r)
    {
        this.remote = r;
    }

    // Abstract methods that will be implemented by subclasses
    abstract void on(); // Method to turn the TV on
    abstract void off(); // Method to turn the TV off
}

class Sony extends TV
{
    Remote remoteType; // Declare a reference to a Remote object specific to Sony

    // Constructor that calls the superclass constructor and assigns the Remote object
    Sony(Remote r)
    {
        super(r);
        this.remoteType = r;
    }

    // Implementation of the 'on' method for Sony TV
    public void on()
    {
        System.out.print("Sony TV ON: ");
        remoteType.on();
    }

    // Implementation of the 'off' method for Sony TV
    public void off()
    {
        System.out.print("Sony TV OFF: ");
        remoteType.off();
    }
}

class Philips extends TV
{
    Remote remoteType; // Declare a reference to a Remote object specific to Philips

    // Constructor that calls the superclass constructor and assigns the Remote object
    Philips(Remote r)
    {
        super(r);
        this.remoteType = r;
    }

    // Implementation of the 'on' method for Philips TV
    public void on()
    {
        System.out.print("Philips TV ON: ");
        remoteType.on();
    }

    // Implementation of the 'off' method for Philips TV
    public void off()
    {
        System.out.print("Philips TV OFF: ");
        remoteType.off();
    }
}

interface Remote
{
    public void on(); // Abstract method for turning on the device
    public void off(); // Abstract method for turning off the device
}

class OldRemote implements Remote
{
    @Override
    public void on()
    {
        System.out.println("ON with Old Remote"); // Implementation of 'on' for the old remote
    }

    @Override
    public void off()
    {
        System.out.println("OFF with old Remote"); // Implementation of 'off' for the old remote
    }
}

class NewRemote implements Remote
{
    @Override
    public void on()
    {
        System.out.println("ON with New Remote"); // Implementation of 'on' for the new remote
    }

    @Override
    public void off()
    {
        System.out.println("OFF with New Remote"); // Implementation of 'off' for the new remote
    }
}

public class BridgePattern
{
    public static void main(String[] args)
    {
        // Creating instances and testing the Bridge pattern
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
    }
}
