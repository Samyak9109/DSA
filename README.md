# DSA Practice Repository

This repository contains data structures and algorithms solutions organized by study sheet and topic. Each sheet has its own folder so solutions can grow independently while keeping the main repository easy to navigate.

## Repository Structure

```text
.
|-- NeetCode150/
|   `-- Python solutions for the NeetCode 150 sheet
|-- PatternWiseDSA/
|   `-- Java solutions grouped by DSA pattern
|-- Striver-A2Z-DSA/
|   `-- Java solutions for the Striver A2Z DSA sheet
|-- pyproject.toml
`-- README.md
```

## Sheets

| Folder | Language | Description |
| --- | --- | --- |
| `NeetCode150/` | Python | Topic-wise solutions from the NeetCode 150 sheet. |
| `PatternWiseDSA/` | Java | Pattern-wise DSA solutions, such as two pointers. |
| `Striver-A2Z-DSA/` | Java | Topic-wise solutions from the Striver A2Z DSA sheet. |

More sheets or practice collections can be added as separate top-level folders.

## Naming and Organization

- Keep each sheet in its own top-level folder.
- Group problems by topic or pattern inside the folder, such as arrays, strings, binary search, recursion, linked lists, two pointers, trees, graphs, and dynamic programming.
- Use clear file names that match the problem name.
- Prefer one problem solution per file unless a topic intentionally groups related examples.

## Languages

This repository is intended for DSA solutions in:

- Java
- Python

Generated files, build outputs, virtual environments, IDE settings, and cache folders are ignored through `.gitignore`.

## Running Solutions

Java files can be compiled and run from their `src` folder:

```bash
javac ProblemName.java
java ProblemName
```

Python files can be run directly:

```bash
python ProblemName.py
```

Some files may use local sample input or hardcoded examples for practice.

## Status

This is an ongoing learning repository. Solutions and new sheets will be added over time.
