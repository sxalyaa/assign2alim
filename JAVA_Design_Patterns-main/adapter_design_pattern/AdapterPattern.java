package adapter_design_pattern;
// Import statements or package declaration could be added here, if necessary.

// Define an interface called WebDriver with two methods: getElement and selectElement.
interface WebDriver 
{
	public void getElement();
	public void selectElement();
}
// Implement the WebDriver interface in the ChromeDriver class.
class ChromeDriver implements WebDriver 
{
	@Override
	public void getElement() 
	{
	    System.out.println("Get element from ChromeDriver");
	}

	@Override
	public void selectElement() 
	{
	    System.out.println("Select element from ChromeDriver");
	    
	}
	  
}
// Define a separate class called IEDriver with methods findElement and clickElement.
class IEDriver
{
	public void findElement() 
	{
	    System.out.println("Find element from IEDriver");
	}

	public void clickElement()
	{
	    System.out.println("Click element from IEDriver");
	}
	  
}
// Create a class called WebDriverAdapter that implements the WebDriver interface.
class WebDriverAdapter implements WebDriver 
{
	IEDriver ieDriver;
	// Constructor that takes an instance of IEDriver and assigns it to the ieDriver member variable.
	public WebDriverAdapter(IEDriver ieDriver) 
	{
	    this.ieDriver = ieDriver;
	}
	  
	@Override
	// Implement the getElement method by calling the findElement method of IEDriver.
	public void getElement() 
	{
	    ieDriver.findElement();
	    
	}

	@Override
	// Implement the selectElement method by calling the clickElement method of IEDriver.
	public void selectElement() 
	{
	    ieDriver.clickElement();
	}
	  
}

public class AdapterPattern
{
    public static void main(String[] args) 
	{
		// Create an instance of ChromeDriver and perform actions.
	    ChromeDriver a = new ChromeDriver();
	    a.getElement();
	    a.selectElement();
		// Create an instance of IEDriver and perform actions.
	    IEDriver e = new IEDriver();
	    e.findElement();
	    e.clickElement();
		// Create an instance of WebDriverAdapter, adapting IEDriver, and perform actions.
	    WebDriver wID = new WebDriverAdapter(e);
	    wID.getElement();
	    wID.selectElement();
	    
	}
}