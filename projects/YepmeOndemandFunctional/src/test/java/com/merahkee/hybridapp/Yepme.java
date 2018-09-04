package com.merahkee.hybridapp;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



	public class Yepme {

		//static WebDriver driver;
		static AppiumDriver driver;
		//static  AndroidDriver driver;

		String Selenium;
		static AppiumDriverLocalService appiumService;
	    static String appiumServiceUrl;
	    static AppiumDriverLocalService service =null;
		//before execution create a folder to store reports
				
		@BeforeTest
		public static void setupAppium() throws MalformedURLException {

			/*appiumService = AppiumDriverLocalService.buildDefaultService();
			appiumService.start();
	        appiumServiceUrl = AppiumDriverLocalService.buildDefaultService().getUrl().toString();
	        System.out.println("Appium Service Address : - "+ appiumServiceUrl);*/

			 /*service = AppiumDriverLocalService
					.buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(new File("C:/Program Files (x86)/Appium/node.exe"))
					.withAppiumJS(new File("C:/Program Files (x86)/Appium/node_modules/appium/bin/appium.js")));
					//.withLogFile(new File("C:/appiumlogs/logs.txt")));
				service.start();
				System.out.println("Server started");*/

				//Creating the instance of DesiredCapabilities class
				DesiredCapabilities capabilities = new DesiredCapabilities();


		//Set android deviceName desired capability.
		capabilities.setCapability("deviceName", "Google Nexus 5 - 5.1.0 - API 22 - 1080x1920");

		//Set BROWSER_NAME desired capability to Android.
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

		//Set android VERSION from device desired capability.
		capabilities.setCapability(CapabilityType.VERSION, 5.1);

		//Set android platformName desired capability to Android.
		capabilities.setCapability("platformName", "Android");

		//Set the apppackage which canbe found using appium or by using adb command
		capabilities.setCapability("appPackage", "com.yepme");

		//Set the appActivity which canbe found using appium or by using adb command
		capabilities.setCapability("appActivity", "com.yepme.DashboardActivity");

		driver = new AndroidDriver(new    URL("http://0.0.0.0:4723/wd/hub"), capabilities);//http://127.0.0.1:4723/wd/hub
		//driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);


			}


			//login to yepme//,enabled=true
			@Test
			public void login() throws MalformedURLException{

				WebDriverWait wait = new WebDriverWait(driver,100);
			  //clicking on menu option to login
				WebElement menu;
				menu=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/menu_more")));
				//menu=driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.yepme:id/app_bar_layout']/android.widget.TextView[@resource-id='com.yepme:id/menu_more']"));
				//menu=driver.findElement(By.className("android.widget.TextView"));
				//menu=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.yepme:id/menu_more']"));
				//menu=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'menu_more') and @index='3']"));
				menu.click();

				//Clickin on myaccount
				WebElement myaccount;
				myaccount=driver.findElement(By.id("com.yepme:id/title"));
				if(myaccount.getText().equals("My Account")) {
				myaccount.click();
				}

				//loging in to yep me application
				WebElement email;
				email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/et_email")));
				email.clear();
				email.sendKeys("mahadevmaryagouda@gmail.com");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				//sending password
				WebElement pass;
				pass=driver.findElement(By.id("com.yepme:id/et_password"));
				pass.sendKeys("test@123");

				//click on login option

				WebElement login;
				//login=driver.findElement(By.id("com.yepme:id/btn_login"));
				login= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/btn_login")));
				if(login.isDisplayed()) {
					login.click();
				}
				String username="mahadevmaryagouda@gmail.com";
				WebElement name;
				name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/tv_email")));
				String actual=name.getText();
				Assert.assertEquals(actual, username);


				 driver.scrollTo("Logout");

				//logout
				WebElement logout;
				logout=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/layout_logout")));
				logout.click();

				//confirm before logout
				WebElement okey;
				okey=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
				okey.click();
			}
			@Test
			public void perchaseTShirt() throws MalformedURLException {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 WebDriverWait wait = new WebDriverWait(driver,100);
				 //click on tshirt option
				 WebElement tshirt;
				 tshirt= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/tv_name")));
				 if(tshirt.isDisplayed()) {
					 tshirt.click();
					}
				//tshirt=driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'com.yepme:id/tv_name') and @text='T-Shirts']"));
				// tshirt= driver.findElement(By.xpath("//android.view.View[@resource-id='com.yepme:id/two_way_view_categories']/android.widget.TextView[contains(@resource-id,'com.yepme:id/tv_name') and @text='T-Shirts']"));
				// tshirt.click();

				//select a shirt
				 WebElement selectshirt;
				// selectshirt=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.RelativeLayout")));//
				 selectshirt=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@resource-id='com.yepme:id/iv_item_image']")));
				 //selectshirt=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@resource-id='com.yepme:id/iv_item_image']")));
				 selectshirt.click();
				//click on buy  //
				 WebElement buynow1;
				 buynow1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/tv_buy_now_bottom")));
				 buynow1.click();


				 //select the shirt size
				 WebElement size;
				 size=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/tv_size")));
				 size.click();

				 if(size.isSelected()) {
				 //adding tshirt to cart
				 WebElement buynow;
				 buynow=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Buy Now']")));
				 buynow.click();
				 }


				 WebElement placeorder;
				 placeorder=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Place Order']")));
				 placeorder.click();


				//loging in to yep me application
					WebElement email;
					email=driver.findElement(By.id("com.yepme:id/et_email"));
					email.clear();
					email.sendKeys("mahadevmaryagouda@gmail.com");
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//sending password
					WebElement pass;
					pass=driver.findElement(By.id("com.yepme:id/et_password"));
					pass.sendKeys("test@123");

					//click on login option

					WebElement login;
					//login=driver.findElement(By.id("com.yepme:id/btn_login"));
					login= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/btn_login")));
					if(login.isDisplayed()) {
						login.click();
					}
					//place order
					WebElement placeorder1;
					placeorder1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Place Order']")));
					placeorder1.click();



				 //proceed to payment
				 WebElement procedtopayment;
				 procedtopayment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/btn_proceed_to_payment")));
				 procedtopayment.click();

				 //click on place ordr to select the payment option
				 WebElement order;
				 order=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/btn_place_order")));
				 order.click();

				 //select cash on delevery
				 WebElement cod;
				 cod=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/bs_list_title")));
				 cod.click();

				 String expected="Are you sure you want to place the order by COD?";
				 WebElement ele=driver.findElement(By.id("android:id/message"));
				 Assert.assertEquals(ele.getText(), expected);

				 WebElement cancel;
				 cancel=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button2")));
				 cancel.click();

				 driver.navigate().back();
				 driver.navigate().back();
				 driver.navigate().back();
				 WebElement cart;
				 cart=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/iv_cart")));
				 cart.click();

				 WebElement remove;
				 remove=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/tv_remove")));
				 remove.click();
				 driver.navigate().back();
				 driver.navigate().back();

				 //clicking on menu option
					WebElement menu;
					menu=driver.findElement(By.id("com.yepme:id/menu_more"));
					menu.click();

					//Clickin on myaccount
					WebElement myaccount;
					myaccount=driver.findElement(By.id("com.yepme:id/title"));
					if(myaccount.getText().equals("My Account")) {
					myaccount.click();
					}
					driver.scrollTo("Logout");
					//logout
					WebElement logout;
					logout=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/layout_logout")));
					logout.click();

					//confirm before logout
					WebElement okey;
					okey=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
					okey.click();
					driver.navigate().back();
			}


		@Test
		public void gift()  {
			//open gift option
			try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			WebDriverWait wait = new WebDriverWait(driver,60);
			WebElement gift;
			gift=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/iv_gift")));
			//gift=driver.findElement(By.id("com.yepme:id/iv_gift"));
			gift.click();

			//loging in to yep me application
			WebElement email;
			email=driver.findElement(By.id("com.yepme:id/et_email"));
			//email= driver.findElement(By.xpath("android.widget.EditText//[@text='com.yepme:id/et_email']"));
			email.clear();
			email.sendKeys("mahadevmaryagouda@gmail.com");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			//sending password
			WebElement pass;
			pass=driver.findElement(By.id("com.yepme:id/et_password"));
			pass.sendKeys("test@123");

			//click on login option

			WebElement login;
			//login=driver.findElement(By.id("com.yepme:id/btn_login"));
			login= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/btn_login")));
			if(login.isDisplayed()) {
				login.click();
			}
			//get the total no of rewards

			WebElement reward;
			reward=driver.findElement(By.id("com.yepme:id/tv_title"));
			String actual=reward.getText();
			System.out.println(actual);
			String expected ="Dear Deepak , you have total (0 Reward Points). Your reward points details are as below:";
			Assert.assertEquals(actual, expected);
			driver.navigate().back();

			//clicking on menu option
			WebElement menu;
			menu=driver.findElement(By.id("com.yepme:id/menu_more"));
			menu.click();

			//Clickin on myaccount
			WebElement myaccount;
			myaccount=driver.findElement(By.id("com.yepme:id/title"));
			if(myaccount.getText().equals("My Account")) {
			myaccount.click();
			}
			driver.scrollTo("Logout");
			//logout
			WebElement logout;
			logout=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/layout_logout")));
			logout.click();

			//confirm before logout
			WebElement okey;
			okey=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
			okey.click();

		}
		//perchasing bag
			@Test(priority=4,enabled=false)
		public void perchasedress() {
			WebDriverWait wait = new WebDriverWait(driver,100);
			//clicking on menu option
			WebElement womensoption;
			womensoption=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Women']")));
			//womensoption=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Women']")));
			womensoption.click();
			System.out.println("clickid on women option");
			//clicking on menu option
			WebElement Accessories;
			Accessories=driver.findElement(By.id("com.yepme:id/tv_name"));
			//Accessories=driver.findElement(By.xpath("//android.widget.TextView[@text='Accessories']"));
			//Accessories=driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Accessories') and resource-id='com.yepme:id/tv_name']"));
			Accessories.click();

			//select a shirt
			 WebElement dress;
			// selectshirt=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.RelativeLayout")));
			 //dress=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@resource-id='com.yepme:id/iv_item_image']")));
			 dress=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@resource-id='com.yepme:id/iv_item_image']")));
			 dress.click();
			//click on buy
			 WebElement buynow1;
			 buynow1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/tv_buy_now_bottom")));
			 buynow1.click();

			/*
			//select the shirt size
			 WebElement size;
			 size=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/tv_size")));
			 size.click();

			 if(size.isSelected()) {
			 //adding tshirt to cart
			 WebElement buynow;
			 buynow=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Buy Now']")));
			 buynow.click();
			 }*/
			 WebElement placeorder;
			 placeorder=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Place Order']")));
			 placeorder.click();


			//loging in to yep me application
				WebElement email;
				email=driver.findElement(By.id("com.yepme:id/et_email"));
				email.clear();
				email.sendKeys("mahadevmaryagouda@gmail.com");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				//sending password
				WebElement pass;
				pass=driver.findElement(By.id("com.yepme:id/et_password"));
				pass.sendKeys("test@123");

				//click on login option

				WebElement login;
				//login=driver.findElement(By.id("com.yepme:id/btn_login"));
				login= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/btn_login")));
				if(login.isDisplayed()) {
					login.click();
				}
				login.click();
				//place order
				WebElement placeorder1;
				placeorder1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Place Order']")));
				placeorder1.click();



			 //proceed to payment
			 WebElement procedtopayment;
			 procedtopayment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/btn_proceed_to_payment")));
			 procedtopayment.click();

			 //click on place ordr to select the payment option
			 WebElement order;
			 order=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/btn_place_order")));
			 order.click();

			 //select cash on delevery
			 WebElement cod;
			 cod=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/bs_list_title")));
			 cod.click();

			 String expected="Are you sure you want to place the order by COD?";
			 WebElement ele=driver.findElement(By.id("android:id/message"));
			 Assert.assertEquals(ele.getText(), expected);

			 WebElement cancel;
			 cancel=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button2")));
			 cancel.click();

			 driver.navigate().back();
			 driver.navigate().back();
			 driver.navigate().back();
			 driver.navigate().back();

			 //clicking on menu option
				WebElement menu;
				menu=driver.findElement(By.id("com.yepme:id/menu_more"));
				menu.click();

				//Clickin on myaccount
				WebElement myaccount;
				myaccount=driver.findElement(By.id("com.yepme:id/title"));
				if(myaccount.getText().equals("My Account")) {
				myaccount.click();
				}
				driver.scrollTo("Logout");
				//logout
				WebElement logout;
				logout=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/layout_logout")));
				logout.click();

				//confirm before logout
				WebElement okey;
				okey=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
				okey.click();
				driver.navigate().back();
		}
			public void addtovishlist() {
				WebDriverWait wait = new WebDriverWait(driver,60);
				  //clicking on menu option
					WebElement menu;
					menu=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.yepme:id/menu_more")));
					//menu=driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.yepme:id/app_bar_layout']/android.widget.TextView[@resource-id='com.yepme:id/menu_more']"));
					//menu=driver.findElement(By.className("android.widget.TextView"));
					//menu=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.yepme:id/menu_more']"));
					menu=driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'menu_more') and @index='3']"));
					menu.click();

					//Clickin on myaccount
					WebElement myaccount;
					myaccount=driver.findElement(By.id("com.yepme:id/title"));
					if(myaccount.getText().equals("My Account")) {
					myaccount.click();
					}

			}

		//adding prodcut to wish list

			public String createFolder(String path, String folderName) {

			    String folderPath=path;
			    String p= dateAndTime();
			 File file = new File(folderPath);
			    if (!file.exists()) {
			        if (file.mkdir()) {
			            System.out.println(folderPath+"Directory is created!");
			        } else {
			            System.out.println("Failed to create directory!");
			        }
			    }
			    String mkDrirectory=folderPath+folderName+p;
			    File files = new File(mkDrirectory);
			    if (!files.exists()) {
			        if (files.mkdirs()) {
			            System.out.println(mkDrirectory+"     "+"Successfully  created!");
			        } else {
			            System.out.println("Failed to create  directories!");
			        }
			    }
				return mkDrirectory;

			}
			public static String dateAndTime() {
			 DateFormat df = new SimpleDateFormat("dd-MM-YYYY");

			 return(df.format(new Date()));
			}

			//Method to redirect the testng reports
			public void redirectreportDirectroy(ITestContext ctx,String outputdirectory) {
			  TestRunner runner = (TestRunner) ctx;
			  runner.setOutputDirectory(outputdirectory);
			  System.out.println("reports are in:"+outputdirectory);
			}

    }
