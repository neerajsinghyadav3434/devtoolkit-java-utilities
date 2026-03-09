# Contributing to DevToolkit

Thank you for your interest in contributing to **DevToolkit – Java Developer Utility Library**! 🎉

We welcome all contributions, including bug fixes, new utility methods, documentation improvements, and test additions. This guide will walk you through the process.

---

## 📋 Table of Contents

- [Code of Conduct](#code-of-conduct)
- [Getting Started](#getting-started)
- [How to Contribute](#how-to-contribute)
- [Project Standards](#project-standards)
- [Pull Request Checklist](#pull-request-checklist)
- [Reporting Issues](#reporting-issues)

---

## 🤝 Code of Conduct

By participating in this project, you agree to maintain a respectful and inclusive environment. Please be kind, constructive, and collaborative in all interactions.

---

## 🚀 Getting Started

### 1. Fork and Clone

```bash
# Fork the repo on GitHub, then clone your fork
git clone https://github.com/YOUR_USERNAME/DevToolkit.git
cd DevToolkit
```

### 2. Set Up Upstream Remote

```bash
git remote add upstream https://github.com/ORIGINAL_OWNER/DevToolkit.git
```

### 3. Install Prerequisites

- Java 17+
- Apache Maven 3.8+

### 4. Build & Verify

```bash
mvn clean test
```

All tests must pass before you start your changes.

---

## 🛠️ How to Contribute

### Step 1 – Create a Feature Branch

Use descriptive branch names following this convention:

| Type | Convention | Example |
|------|-----------|---------|
| Feature | `feature/description` | `feature/add-string-truncate` |
| Bug Fix | `fix/description` | `fix/email-validator-null-crash` |
| Docs | `docs/description` | `docs/update-readme-examples` |
| Tests | `test/description` | `test/add-calculator-edge-cases` |
| Refactor | `refactor/description` | `refactor/streamline-date-parser` |

```bash
git checkout -b feature/your-feature-name
```

### Step 2 – Make Your Changes

- Add new utility methods **only** inside the appropriate `com.devtoolkit.*` package.
- Follow the [Project Standards](#project-standards) below.

### Step 3 – Write Tests

Every new public method **must** be paired with at least one JUnit 5 test. Place tests in:

```
src/test/java/com/devtoolkit/<package>/<ClassName>Test.java
```

### Step 4 – Run the Full Test Suite

```bash
mvn clean test
```

Tests must pass with 0 failures and 0 errors.

### Step 5 – Commit & Push

Write clear, conventional commit messages:

```
feat: add StringUtils.truncate() method
fix: handle null in EmailValidator.isValid()
docs: add DateFormatter usage examples to README
test: add edge-case tests for Calculator.sqrt()
```

```bash
git add .
git commit -m "feat: your descriptive message"
git push origin feature/your-feature-name
```

### Step 6 – Open a Pull Request

Open a Pull Request against the `main` branch of the upstream repository and fill out the PR template.

---

## 📐 Project Standards

### Code Style

- **Indentation**: 4 spaces (no tabs)
- **Line length**: ≤ 120 characters
- **Naming**: `camelCase` for variables/methods, `PascalCase` for classes, `UPPER_SNAKE_CASE` for constants
- **No wildcard imports**

### Design Principles

- All utility classes must have a `private` constructor (non-instantiable).
- All public methods must be `static` and thread-safe (no shared mutable state).
- Follow SOLID principles — keep methods focused and single-purpose.
- Handle all edge cases (null inputs, empty strings, division by zero, etc.).
- Throw meaningful, descriptive `IllegalArgumentException` or domain-specific exceptions.

### JavaDoc

Every `public` method **must** include:

```java
/**
 * One-line summary.
 *
 * <p>Optional expanded description.</p>
 *
 * @param paramName  description of parameter
 * @return           description of return value
 * @throws ExceptionType  when this exception is thrown
 */
```

---

## ✅ Pull Request Checklist

Before submitting your PR, verify all of the following:

- [ ] Code compiles without warnings (`mvn clean compile`)
- [ ] All tests pass (`mvn test`)
- [ ] New public methods have full JavaDoc
- [ ] New methods have at least one unit test (including edge cases)
- [ ] Branch is based on the latest `main`
- [ ] Commit messages follow conventional commits format
- [ ] No IDE-generated files committed (`.idea/`, `*.iml`, etc.)

---

## 🐛 Reporting Issues

Please use the [Issue Template](ISSUE_TEMPLATE.md) when reporting bugs or requesting features.

When reporting a bug, include:
1. Java and Maven versions (`java -version`, `mvn -version`)
2. Steps to reproduce
3. Expected behaviour
4. Actual behaviour
5. Stack trace (if applicable)

---

Thank you for contributing to **DevToolkit**! Your work helps make this library better for everyone. 🙌
