# JavaSeleniumAutomationFramework
## 🎯 Project Overview
This is a professional-grade UI automation framework designed for testing e-commerce web applications. It demonstrates the implementation of a scalable and maintainable automation architecture using the Page Object Model (POM).

## 🛠 Tech Stack
* **Language:** Java 17+
* **Automation:** Selenium WebDriver
* **Test Runner:** TestNG
* **Build Tool:** Maven
* **Version Control:** Git & GitHub

## 🏗 Framework Architecture
The project follows the **Page Object Model (POM)** to ensure clean separation of test logic from UI elements.
* **Base Layer:** Handles browser initialization, teardown, and configuration loading.
* **Page Objects:** Individual classes representing web pages, encapsulating locators and actions.
* **Tests:** TestNG classes containing assertions and business logic.

## 💻 How to Run
1. Ensure you have Maven installed.
2. Clone the repository: `git clone [Your Repo Link]`
3. Execute tests via terminal:
   ```bash
   mvn clean test
