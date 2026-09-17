# 🕵️‍♂️ Mystery Investigation Engine

> A lightweight, zero-dependency Java command-line utility for playing out a crime scene investigation. Built for the flipped course evaluation in Programming in Java.

---

## 📝 Overview

Manual mystery games can get messy on paper. I built this tool to automate the process of keeping track of suspects, evidence, and alibis. It provides a simple CLI menu to go through the case and lets you interview people or examine the crime scene on the fly to generate a quick confidence score.

### 🌟 Key Features
- **Zero Dependencies:** Written purely in standard Java (`java.io`, `java.util`). No Maven, Gradle, or external libraries required.
- **Object-Oriented Design:** Uses inheritance with `Evidence`, `PhysicalEvidence`, and `DigitalEvidence` to model real-world concepts.
- **Custom Exceptions:** Gracefully handles bad inputs using custom classes like `InvalidSuspectException` without throwing a stack trace.
- **Background Analysis:** Uses Java Threads to run simulated background checks on fingerprints and phone records.

---

## 🚀 Getting Started

### Prerequisites
- Any standard **Java Development Kit (JDK 8 or higher)** installed on your machine.
- A terminal or command prompt.

### Compilation
Clone the repository or download the files, go to the folder in your terminal, and run:

```bash
javac *.java
```

---

## 💻 Usage Guide

Once compiled, start the tool using `java Main`.

### Command Syntax
```bash
java Main
```

### Examples

**1. View Crime Scene**  
Simply print out the initial description of the room.
Choose option `1` from the main menu.

**2. Interview Suspects**  
Check their alibis and add to the confidence score.
Choose option `2` and then input the suspect's ID number (e.g., `1`).

**3. Examine Evidence**  
Inspect digital or physical clues.
Choose option `3` and then input the evidence ID (e.g., `E01`).

**4. 📊 Analyze Case (Threading)**  
Scan the case in the background. The engine spawns 3 threads to simulate running fingerprints, CCTV, and phone traces.
Choose option `4` from the main menu.

**5. Save Case Report**  
Export the final score to a text file (`case_report_047.txt`).
Choose option `5` from the main menu.

---

## ⚙️ Data Format Requirements

This tool currently hardcodes dummy data for suspects and evidence directly inside `InvestigationManager.java` for testing purposes. 

**Expected Suspect Format:**
`Name, Age, Relation, Alibi`

**Example Line:**
`"bob the janitor", 45, "employee", "cleaning the 3rd floor"`

---

## 🔌 Integration into Other Projects

If you want to use this logic inside a larger Java application (like a GUI dashboard), you can easily adapt the code:

1. **Remove the CLI wrapper:** Take the main loop out of `Main.java` and link the `InvestigationManager` directly to button clicks.
2. **Use File I/O for Loading:** Instead of hardcoding, map incoming data from a `.csv` file directly to the `ArrayList<Suspect>`.
3. **Return the Score:** The `ConfidenceEngine` tracks the investigation progress. You can simply return this integer score to your frontend to generate a real progress bar instead of printing ASCII blocks.

---
*Developed for a course project. Pure Java, no external libraries.*
