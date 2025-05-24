This repository contains a structured Selenium Automation Framework implemented using Java, Cucumber BDD, and Page Object Model (POM) design pattern.
The framework automates key functionalities like Login, Product addition to cart, and End-to-End Checkout for the Demoblaze e-commerce site.
📌 Features Implemented
✅ BDD with Cucumber
Implemented Feature Files using:
Background to eliminate repetitive steps
Scenario for specific test cases
Scenario Outline for data-driven testing (login with multiple credentials)
✅ Functional Test Coverage
Login
Valid credentials
Data-driven login using Scenario Outline
Add Product to Cart
Navigate to category
Select product
Add to cart and validate alert
Cart Checkout (E2E Flow)
Validate product in cart
Remove additional products (retain only one)
Fill checkout form
Validate success message
⚙️ Technical Stack
Component	Technology
Language	Java
Build Tool	Maven
Automation	Selenium WebDriver
BDD Framework	Cucumber
Design Pattern	Page Object Model (POM)
Config	config.properties for URL, username, password, browser
Hooks	@Before and @After to launch and tear down browser

Project Structure
src/test/java
│
├── stepDefinitions        # Step definitions + Hooks + BaseClass
│   ├── BaseClass.java     # Shared WebDriver and PageObject setup
│   ├── Hooks.java         # Browser start/close using @Before/@After
│   └── StepDefinitions.java
│
├── pageObjects            # All Page Object classes
│   ├── LoginPage.java
│   ├── AddProduct.java
│   └── CartCheckout.java
│
├── utilities              # Utility classes
│   └── ConfigReader.java  # Reads from config.properties
│
└── resources
    └── config.properties  # URL, credentials, browser config

src/test/resources
└── features
    ├── Login.feature
    ├── AddProduct.feature
    └── CartCheckout.feature

🔧 Configurations
config.properties contains:

properties
Copy
Edit
baseURL=https://demoblaze.com/index.html
username=admin
password=admin
browser=chrome
These values are dynamically read using a utility class (ConfigReader.java) and used in both hooks and step definitions.

