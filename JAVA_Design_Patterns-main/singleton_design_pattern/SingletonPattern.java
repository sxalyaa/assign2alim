package singleton_design_pattern;
// Singleton class using eager initialization.
class SingletonEagar 
{
  private static SingletonEagar instance = new SingletonEagar(); 
  private SingletonEagar()
  {
	  
  }
  public static SingletonEagar getInstance()
  {
    return instance;
  }
}
// Singleton class using lazy initialization (not thread-safe).
class Singleton 
{
  private static Singleton instance; 
  private Singleton()
  {
	  
  }
  public static Singleton getInstance() 
  {
    if(instance == null) 
    {
      instance = new Singleton();
    }
    return instance;
  }
}
// Singleton class using synchronized method for lazy initialization (thread-safe, but not efficient).
class SingletonSynchronizedMethod
{
  private static SingletonSynchronizedMethod instance; 
  private SingletonSynchronizedMethod()
  {
	  
  }
  public static synchronized SingletonSynchronizedMethod getInstance() 
  {
    if(instance == null) 
    {
      instance = new SingletonSynchronizedMethod();
    }
    return instance;
  }
}
// Singleton class using double-checked locking for lazy initialization (thread-safe and efficient).
class SingletonSynchronized 
{
  private static SingletonSynchronized instance; 
  private SingletonSynchronized()
  {
	  
  }
  public static SingletonSynchronized getInstance() 
  {
    if(instance == null) 
    {
      synchronized (SingletonSynchronized.class) 
      {
        if(instance == null) 
        {
          instance = new SingletonSynchronized();
        }
      }
    }
    return instance;
  }
}
// Main class where the program starts execution.
public class SingletonPattern 
{
  public static void main(String[] args) 
  {
    SingletonSynchronized instance = SingletonSynchronized.getInstance();
    System.out.println(instance);
    SingletonSynchronized instance1 = SingletonSynchronized.getInstance(); 
    System.out.println(instance1);
  }
}