package facade_design_pattern;

import java.sql.Driver;
// This class provides methods related to the Firefox web browser
class Firefox
{
  public static Driver getFirefoxDriver() 
  {
      return null;
  }
  
  public static void generateHTMLReport(String test, Driver driver) 
  {
      System.out.println("Generating HTML Report for Firefox Driver");
  }
  
  public static void generateJUnitReport(String test, Driver driver) 
  {
      System.out.println("Generating JUNIT Report for Firefox Driver");
  }
}

// This class provides methods related to the Chrome web browser.
class Chrome 
{
  public static Driver getChromeDriver() 
  {
    return null;
  }
  
  public static void generateHTMLReport(String test, Driver driver) 
  {
      System.out.println("Generating HTML Report for Chrome Driver");
  }
  
  public static void generateJUnitReport(String test, Driver driver)
  {
      System.out.println("Generating JUNIT Report for Chrome Driver");
  }
}
// This class acts as a facade and simplifies the process of generating reports.
class WebExplorerHelperFacade 
{
  public static void generateReports(String explorer, String report, String test)
  {
      Driver driver = null;
      switch(explorer)
      {
          case "firefox":
          driver = Firefox.getFirefoxDriver();
          switch(report) 
          {
              case "html":
              Firefox.generateHTMLReport(test, driver);
              break;
              case "junit":
              Firefox.generateJUnitReport(test, driver);
              break;
          }
          break;
          case "chrome":
          driver = Chrome.getChromeDriver();
          switch(report) 
          {
              case "html":
              Chrome.generateHTMLReport(test, driver);
              break;
              case "junit":
              Chrome.generateJUnitReport(test, driver);
              break;
          }
      }
  }
}
// This is the main class where the program starts execution.
public class FacadePattern
{
  public static void main(String[] args)
  {
    String test = "CheckElementPresent";
    
    WebExplorerHelperFacade.generateReports("firefox", "html", test);
    WebExplorerHelperFacade.generateReports("firefox", "junit", test);
    WebExplorerHelperFacade.generateReports("chrome", "html", test);
    WebExplorerHelperFacade.generateReports("chrome", "junit", test);
  }

}