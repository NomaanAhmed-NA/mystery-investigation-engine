# Problem Statement

Manual mystery and crime investigation games often rely heavily on pen and paper to keep track of suspects, evidence, alibis, and overall progress. This manual tracking can become messy, confusing, and difficult to manage as the investigation expands, leading to a suboptimal gaming experience.

# Scope of the Project

The Mystery Investigation Engine is a lightweight, zero-dependency Java command-line utility designed to automate the process of tracking a crime scene investigation. The system handles the logging and examining of suspects and evidence (both physical and digital) and calculates a real-time confidence score based on the progress of the investigation. The scope is limited to a single investigation session managed entirely via a CLI interface.

# Target Users

- Players of mystery and crime-solving games who want a digital tool to manage their investigation.
- Developers and students looking for a simple, extensible Object-Oriented Java engine to integrate into larger GUI-based investigation games.

# High-Level Features

- **Suspect Management:** View and interview suspects, verify alibis.
- **Evidence Examination:** Examine different types of evidence (physical and digital) found at the crime scene.
- **Confidence Engine:** Real-time tracking of the investigation's progress through a generated score.
- **Automated Analysis:** Simulated background checks and analysis using multithreading for tasks like fingerprint scanning and CCTV review.
- **Report Generation:** Save the final case report and status to a text file.
