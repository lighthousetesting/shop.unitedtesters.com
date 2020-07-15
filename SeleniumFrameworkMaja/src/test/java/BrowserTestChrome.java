import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTestChrome {

	public static void main(String[] args) {
		
			//putanja
		    String projectPath =System.getProperty("user.dir");
		    System.out.println("projectPath : "+ projectPath);
	    
		 System.setProperty("webdriver.chrome.driver",projectPath+"\\drajveri\\chromedriver\\chromedriver.exe");
	     WebDriver driver = new ChromeDriver();
         
	     driver.get("https://shop.unitedtesters.com/");
	     
		     try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		     driver.close();

	}

}
