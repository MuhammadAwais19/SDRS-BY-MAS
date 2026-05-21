# 🏥 Smart Doctor Recommendation System Engine (SDRS-BMA)

An advanced, enterprise-grade **3-Tier Healthcare Recommender & Hospital Management System** designed to bridge the gap between regional patient syndromic data and medical specialist registries. Built on a fully decoupled micro-architecture utilizing Java Spring Boot on the backend engine and dynamic asynchronous JS data mapping layers on the frontend dashboard.

---

## 🛠️ System Architecture & Stack

- **Backend Architecture:** Java 17, Spring Boot 3.4.x, Spring Data JPA, Hibernate ORM Engine.
- **Database Architecture:** MySQL 8.x Unifier Node (Optimized relational schema indexes with cascading referential integrity constraints).
- **Frontend Client:** Semantic HTML5, CSS3 Component Framework Variables, Asynchronous Vanilla JS Promises (Fully responsive matrix layout).

---

## 🚀 Core Features Matrix

### 👤 Patient-Facing Portal
- **Syndromic Parsing Engine:** Dynamically translates diverse ambient diagnostic user triggers (e.g., Smog Cough, Naegleria alert flags, High Seasonal Fevers) into accurate clinical medical specializations (Cardiologist, Dermatologist, General Physician).
- **Regional Zone Mapping:** Automated double-ended location validation utilizing reverse static city-to-province lookups across multiple Pakistan region metrics (Lahore, Karachi, Islamabad, Multan, etc.).
- **Transactional Slot Allocation:** Real-time patient appointment routing pipeline persisting direct data parameters straight into core database nodes.

### 🛠️ Advanced Administrator Panel (The Control Matrix)
- **Session Protection Layer:** Secure entry point shielded behind client-side state authentication tokens.
- **Live Sync Dropdowns:** Asynchronous CORS-proof parameters instantly committing patient status updates (`📅 Booked`, `✅ Checkup Done`, `❌ Missing / No Show`) seamlessly into the live database state.
- **Bi-Directional Schema Updates:** Empowering administrators to dynamically registers new clinical medical staff entities and completely purge/delete old entries straight from the SQL registry node.
- **Dynamic Checkpoint Printing:** Integrated DOM manipulation wrapper allowing on-demand printing of selected patient receipt summaries using customizable interactive print checkboxes.

---

## 📂 Project Structure Directory

```text
├── src
│   ├── main
│   │   ├── java/com/example/doctorsystem
│   │   │   ├── DoctorSystemApplication.java   # App Bootstrapper
│   │   │   ├── ApiController.java              # REST Micro-Endpoints Controller
│   │   │   ├── Doctor.java                     # Clinical Registry Entity Map
│   │   │   └── Appointment.java                # Patient Transactional Entity Map
│   │   └── resources
│   │       ├── static
│   │       │   ├── index.html                  # Core Diagnostic Portal UI
│   │       │   └── admin.html                  # Advanced Management Dashboard Matrix
│   │       └── application.properties          # Production/Database Handshake Configs
└── pom.xml                                     # Dependency Orchestrator Manifest
```

---

## 🛡️ Production & Deployment Strategy (Upcoming)
- Implementing **Spring Security Suite** coupled with asymmetric **JWT (JSON Web Tokens)** validation filters.
- Decentralizing properties files via secure environmental variable configurations.
- Containerization utilizing **Docker** blueprints for seamless deployment orchestration onto cloud instances (AWS / Railway Cloud infrastructure).

---
**Designed, Developed, and Maintained by:** [M. Awais Shakur](https://github.com) 🚀
