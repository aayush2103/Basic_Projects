package structural.proxy;

// Proxy - A class that functions as an interface to a particular resource. That resource
//    may be remote, expensive to construct, or may require logging or some other added functionality.
/*  1. a proxy has the same interface as the underlying object
    2. to create a proxy, simply replicate the existing interface of an object
    3. add relevant functionality to the redefined member functions
    4. different proxies (communication, logging, caching, etc.) have completely different behaviours
 * */

/* Proxy VS. Decorator
*   - proxy provides an identical interface, decorator provides and enhanced interface
*   - decorator typically aggregates (or has reference to) what it is decorating, proxy does'nt have to
*   - proxy might not even be working with a materialized object
* */
interface Drivable {
  void drive();
}

class Car implements Drivable {
  protected Driver driver;

  public Car(Driver driver)
  {
    this.driver = driver;
  }

  @Override
  public void drive()
  {
    System.out.println("Car being driven");
  }
}

// a proxy class to apply additionally features in this case protection features to drive() method
class CarProxy extends Car {

  public CarProxy(Driver driver)
  {
    super(driver);
  }

  @Override
  public void drive() {
    if (driver.age >= 17)
      super.drive();
    else
      System.out.println("Driver too young");
  }
}

class Driver {
  public int age;

  public Driver(int age)
  {
    this.age = age;
  }
}

class ProtectionProxyDemo {
  public static void main(String[] args) {
    Car car = new CarProxy(new Driver(12)); // 22
    car.drive();
  }
}
