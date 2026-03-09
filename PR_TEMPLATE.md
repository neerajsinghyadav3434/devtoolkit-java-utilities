# Pull Request

## Summary

> Provide a concise description of **what** this PR does and **why** it was needed.

---

## Type of Change

Please check all that apply:

- [ ] 🐛 Bug fix (non-breaking change that fixes an issue)
- [ ] ✨ New feature (non-breaking change that adds functionality)
- [ ] 💥 Breaking change (fix or feature that changes existing behaviour)
- [ ] 📖 Documentation update
- [ ] 🧪 Test improvement
- [ ] 🔧 Refactoring (no functional change)

---

## Related Issues

> Link any related issues: `Closes #123` or `Fixes #456`

---

## Changes Made

> List all significant changes with a short explanation:

- `StringUtils.java` – Added `truncate(String, int)` method
- `StringUtilsTest.java` – Added 4 test cases for `truncate`
- `README.md` – Updated API reference table

---

## How Has This Been Tested?

> Describe how you tested your changes.

- [ ] Ran the full test suite (`mvn clean test`) – all tests pass
- [ ] Manually tested via the CLI (`mvn exec:java`)
- [ ] Added new unit tests (describe below)

**New Test Cases Added:**
- `truncate_emptyString()` – verifies empty string returns empty
- `truncate_shorter_than_max()` – string shorter than limit is unchanged
- `truncate_longer_than_max()` – string is truncated with ellipsis
- `truncate_null_throws()` – null input throws `IllegalArgumentException`

---

## Pull Request Checklist

- [ ] Code compiles without warnings (`mvn clean compile`)
- [ ] All existing tests pass (`mvn test`)
- [ ] New/changed public methods have complete JavaDoc
- [ ] New methods have at least one unit test
- [ ] No unrelated files included (IDE config, build artifacts, etc.)
- [ ] Branch is based on the latest `main`
- [ ] Commit messages follow [Conventional Commits](https://www.conventionalcommits.org/) format
- [ ] `README.md` updated if API surface changed

---

## Screenshots / Demo (if applicable)

> Paste CLI screenshots or output here if the PR introduces visible behaviour changes.

---

## Additional Notes

> Anything else reviewers should know? Performance considerations, known limitations, follow-up work?
