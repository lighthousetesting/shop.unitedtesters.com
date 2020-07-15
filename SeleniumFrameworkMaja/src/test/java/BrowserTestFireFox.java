import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTestFireFox {

	public static void main(String[] args) {
		
		//putanja
	    String projectPath =System.getProperty("user.dir");
	    System.out.println("projectPath : "+ projectPath);
		
		
		System.setProperty("webdriver.gecko.driver",projectPath+ "\\Drajveri\\geackodriver\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://shop.unitedtesters.com/");
		
		   try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		     driver.close();
	}

}


