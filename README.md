# 🛠️ DevToolkit – Java Developer Utility Library

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?logo=java" alt="Java 17"/>
  <img src="https://img.shields.io/badge/Build-Maven-blue?logo=apache-maven" alt="Maven"/>
  <img src="https://img.shields.io/badge/License-MIT-green" alt="MIT License"/>
  <img src="https://img.shields.io/badge/Contributions-Welcome-brightgreen" alt="Contributions Welcome"/>
  <img src="https://img.shields.io/badge/Status-Active-success" alt="Active"/>
</p>

> A beginner-friendly, well-structured Java utility library providing everyday developer helpers — ideal as a first open-source contribution or a learning reference.

---

## 📋 Table of Contents

- [Features](#-features)
- [Project Structure](#-project-structure)
- [Installation](#-installation)
- [Usage](#-usage)
  - [Running the CLI](#running-the-cli)
  - [Using as a Library](#using-as-a-library)
- [Modules & API Reference](#-modules--api-reference)
- [Running Tests](#-running-tests)
- [Example CLI Session](#-example-cli-session)
- [Learning Purpose](#-learning-purpose)
- [Contributing](#-contributing)
- [License](#-license)

---

## ✨ Features

| Module | Description |
|--------|-------------|
| **StringUtils** | Reverse strings, palindrome detection, extra-space removal, word counting |
| **EmailValidator** | Regex-based email validation + domain/local-part extraction |
| **PasswordValidator** | Strength checking with detailed violation messages and WEAK/MODERATE/STRONG label |
| **DateFormatter** | Format `LocalDate`/`LocalDateTime`, convert between date format patterns |
| **Calculator** | Add, subtract, multiply, divide (with divide-by-zero guard), power, sqrt, abs |
| **CLI Interface** | Interactive menu-driven CLI to exercise all utilities without writing code |

---

## 📁 Project Structure

```
devtoolkit/
├── src/
│   ├── main/java/com/devtoolkit/
│   │   ├── app/
│   │   │   └── Main.java               ← CLI entry point
│   │   ├── stringutils/
│   │   │   └── StringUtils.java
│   │   ├── validation/
│   │   │   ├── EmailValidator.java
│   │   │   └── PasswordValidator.java
│   │   ├── datetime/
│   │   │   └── DateFormatter.java
│   │   └── math/
│   │       └── Calculator.java
│   └── test/java/com/devtoolkit/
│       ├── stringutils/StringUtilsTest.java
│       ├── validation/
│       │   ├── EmailValidatorTest.java
│       │   └── PasswordValidatorTest.java
│       ├── datetime/DateFormatterTest.java
│       └── math/CalculatorTest.java
├── pom.xml
├── README.md
├── CONTRIBUTING.md
├── LICENSE
├── ISSUE_TEMPLATE.md
└── PR_TEMPLATE.md
```

---

## ⚙️ Installation

### Prerequisites

| Tool | Minimum Version |
|------|----------------|
| JDK  | 17             |
| Maven | 3.8+          |
| Git  | Any            |

### Clone & Build

```bash
# 1. Clone the repository
git clone https://github.com/yourusername/DevToolkit.git
cd DevToolkit

# 2. Compile and package
mvn clean package

# 3. Run tests to verify everything works
mvn test
```

---

## 🚀 Usage

### Running the CLI

```bash
mvn exec:java
```

You will see an interactive menu:

```
  ╔══════════════════════════════════════════╗
  ║        DevToolkit – Java Utility CLI     ║
  ║           v1.0.0  |  MIT License         ║
  ╚══════════════════════════════════════════╝

  ┌─────────────────────────────────────────┐
  │              MAIN MENU                  │
  ├─────────────────────────────────────────┤
  │  1. Reverse a String                    │
  │  2. Check Palindrome                    │
  │  3. Remove Extra Spaces                 │
  │  4. Validate Email Address              │
  │  5. Password Strength Check             │
  │  6. Calculator                          │
  │  7. Date Format Converter               │
  │  0. Exit                                │
  └─────────────────────────────────────────┘
```

### Using as a Library

Copy the source classes you need into your project or add this as a local Maven dependency after running `mvn install`.

```java
// String utilities
String reversed   = StringUtils.reverse("Hello");          // "olleH"
boolean isPalin   = StringUtils.isPalindrome("racecar");   // true
String cleaned    = StringUtils.removeExtraSpaces("a  b"); // "a b"

// Email validation
boolean valid = EmailValidator.isValid("user@example.com");    // true
String domain = EmailValidator.extractDomain("u@example.com"); // "example.com"

// Password strength
boolean strong       = PasswordValidator.isStrong("MyP@ss9!");
List<String> issues  = PasswordValidator.validate("weak");     // violation list
String label         = PasswordValidator.strengthLabel("abc"); // "WEAK"

// Calculator
double result = Calculator.add(3, 4);      // 7.0
double ratio  = Calculator.divide(10, 4);  // 2.5
// ⚠️ throws ArithmeticException:
Calculator.divide(5, 0);

// Date formatting
String today = DateFormatter.formatToday(DateFormatter.FORMAT_ISO);   // "2026-03-10"
String conv  = DateFormatter.convert("10/03/2026",
    DateFormatter.FORMAT_DD_MM_YYYY,
    DateFormatter.FORMAT_ISO);                                         // "2026-03-10"
```

---

## 📚 Modules & API Reference

### `StringUtils`
| Method | Signature | Description |
|--------|-----------|-------------|
| `reverse` | `reverse(String) → String` | Reverses a string |
| `isPalindrome` | `isPalindrome(String) → boolean` | Case-insensitive, ignores non-alphanumeric |
| `removeExtraSpaces` | `removeExtraSpaces(String) → String` | Collapses multiple spaces into one |
| `wordCount` | `wordCount(String) → int` | Number of words in string |
| `isBlank` | `isBlank(String) → boolean` | Null or whitespace-only check |

### `EmailValidator`
| Method | Signature | Description |
|--------|-----------|-------------|
| `isValid` | `isValid(String) → boolean` | Regex-based format check |
| `extractDomain` | `extractDomain(String) → String` | Returns domain part |
| `extractLocalPart` | `extractLocalPart(String) → String` | Returns local/username part |

### `PasswordValidator`
| Method | Signature | Description |
|--------|-----------|-------------|
| `isStrong` | `isStrong(String) → boolean` | True only if all rules pass |
| `validate` | `validate(String) → List<String>` | Returns list of violations |
| `strengthLabel` | `strengthLabel(String) → String` | Returns WEAK / MODERATE / STRONG |

### `DateFormatter`
| Method | Signature | Description |
|--------|-----------|-------------|
| `formatToday` | `formatToday(String) → String` | Formats today using given pattern |
| `format` | `format(LocalDate, String) → String` | Formats any `LocalDate` |
| `convert` | `convert(String, String, String) → String` | Converts between two format patterns |
| `parse` | `parse(String, String) → LocalDate` | Parses a string to `LocalDate` |

### `Calculator`
| Method | Signature | Description |
|--------|-----------|-------------|
| `add` | `add(double, double) → double` | Addition |
| `subtract` | `subtract(double, double) → double` | Subtraction |
| `multiply` | `multiply(double, double) → double` | Multiplication |
| `divide` | `divide(double, double) → double` | Division — throws on zero |
| `modulo` | `modulo(double, double) → double` | Remainder — throws on zero |
| `power` | `power(double, double) → double` | Exponentiation |
| `sqrt` | `sqrt(double) → double` | Square root — throws for negatives |
| `abs` | `abs(double) → double` | Absolute value |

---

## 🧪 Running Tests

```bash
# Run all JUnit 5 tests
mvn test

# Run tests for a specific class
mvn test -Dtest=CalculatorTest

# View surefire test report
target/surefire-reports/
```

**Test coverage includes:**
- ✅ Normal cases for all utility methods
- ✅ Edge cases (empty strings, zero values, boundary inputs)
- ✅ Null-input handling
- ✅ Exception assertions (`ArithmeticException`, `IllegalArgumentException`)

---

## 📖 Example CLI Session

Example usage of the DevToolkit CLI after running `mvn exec:java`:

```
  ┌─────────────────────────────────────────┐
  │              MAIN MENU                  │
  └─────────────────────────────────────────┘
  Enter your choice: 1

  ── Reverse a String ──
  Enter a string: hello
  ✅  Reversed: olleh

  Enter your choice: 4

  ── Email Validator ──
  Enter an email address: user@example.com
  ✅  Valid email.
      Local part : user
      Domain     : example.com

  Enter your choice: 6

  ── Calculator ──
  Operations:  1) Add  2) Subtract  3) Multiply  4) Divide  5) Power  6) Square Root
  Select operation: 1
  Enter first number : 12
  Enter second number: 8
  ✅  Result = 20.0000

  Enter your choice: 0
  👋  Thank you for using DevToolkit. Goodbye!
```

---

## 💡 Learning Purpose

This project demonstrates:

- **Clean Java project structure** – modular packages and single-responsibility classes
- **Maven-based build system** – dependency management, compilation, and test execution
- **CLI application design** – interactive menus, input validation, and user feedback
- **Unit testing with JUnit 5** – test cases for normal, edge, and error scenarios
- **Open-source contribution workflow** – branching strategy, commit conventions, PR and issue templates

---

## 🤝 Contributing

Contributions are warmly welcomed! Please read [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines on:
- How to fork the repository
- Branch naming conventions
- Code style requirements
- Pull request process

For bug reports and feature requests, please use the [issue templates](ISSUE_TEMPLATE.md).

---

## 📄 License

This project is licensed under the **MIT License** – see the [LICENSE](LICENSE) file for details.

---

<p align="center">
  Made with ❤️ by the DevToolkit community · 
  <a href="CONTRIBUTING.md">Contribute</a> · 
  <a href="https://github.com/yourusername/DevToolkit/issues">Report Bug</a>
</p>
