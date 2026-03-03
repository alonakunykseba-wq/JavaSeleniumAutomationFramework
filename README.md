# JavaSeleniumAutomationFramework

## 🚀 Project Status:** Active Development (Updated Weekly)

## 🎯 Project Overview
This repository contains a professional‑grade UI automation framework built with Java, Selenium WebDriver, and TestNG.
It is designed to demonstrate clean automation architecture, scalability, and best practices suitable for enterprise‑level testing — especially in e‑commerce and financial domains.

## 🛠 Tech Stack
* **Language:** Java 17+
* **Automation:** Selenium WebDriver
* **Test Runner:** TestNG
* **Build Tool:** Maven
* **Version Control:** Git & GitHub

## 🏗 Framework Architecture
The project follows the **Page Object Model (POM)** to ensure clean separation of test logic from UI elements.
* **Base Layer:** 
- Browser initialization
- WebDriver lifecycle management
- Common setup/teardown logic
* **Page Objects:**
- Each page represented by a dedicated class
- Encapsulated locators and reusable actions
* **Tests:** 
- TestNG classes containing assertions and business logic
- Clean, readable test flow
- 
## 📖 Test Strategy
  For a detailed breakdown of all test scenarios and logic, please see the [Test Plan](TEST_PLAN.md).

## 💻 How to Run
1. Ensure you have Maven installed.
2. Clone the repository: `git clone [Your Repo Link]`
3. Execute tests via terminal:
   ```bash
   mvn clean test
