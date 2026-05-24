package com.example.doctorsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Repository
interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findBySpecializationAndLocationIgnoreCase(String specialization, String location);
}

@Repository
interface AppointmentRepository extends JpaRepository<Appointment, Integer> {}

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApiController {

    @Autowired private DoctorRepository doctorRepo;
    @Autowired private AppointmentRepository appointmentRepo;

    @GetMapping("/doctors")
    public List<Doctor> searchDoctors(@RequestParam String symptom, @RequestParam String location) {
        String spec = "General";

        switch (symptom.toLowerCase().trim()) {
            case "fever":
            case "high seasonal fever / body shivers":
                spec = "General"; break;

            case "smog_cough":
            case "smog cough / severe asthma / lung burn":
            case "naegleria":
            case "water diarrhea / naegleria alert / typhoid":
            case "pollen_allergy":
            case "pollen allergy / constant sneezing":
                spec = "General"; break;

            case "chest_pain":
            case "severe chest pain / angina compression":
            case "angioplasty":
            case "angioplasty block / left jaw pain":
            case "heart_attack":
            case "heart attack warning / low pulse":
            case "high_bp":
            case "high blood pressure / hypertension":
                spec = "Cardiologist"; break;

            case "smog_rash":
            case "smog skin rash / severe dryness":
            case "acne_scars":
            case "cystic acne breakout / scars":
            case "eczema":
            case "sea humidity fungal / eczema flare-up":
            case "hair_fall":
            case "extreme hair fall / thinning":
                spec = "Dermatologist"; break;
        }

        return doctorRepo.findBySpecializationAndLocationIgnoreCase(spec, location.trim());
    }

    @PostMapping("/book")
    public String bookAppointment(@RequestBody Appointment appointment) {
        try {
            appointmentRepo.save(appointment);
            return "Successfully Booked! Patient: " + appointment.getPatientName() +
                    " (Confirmation alert code transited safely to " + appointment.getPatientPhone() + ")";
        } catch (Exception e) {
            return "Server Side Integration Process Failure: " + e.getMessage();
        }
    }

    // 1. GET ALL APPOINTMENTS
    @GetMapping("/admin/bookings")
    public List<Appointment> getAllBookingsForAdmin() {
        return appointmentRepo.findAll();
    }

    // 2. GET ALL DOCTORS
    @GetMapping("/admin/doctors_list")
    public List<Doctor> getAllDoctorsForAdmin() {
        return doctorRepo.findAll();
    }

//     3. DELETE BOOKING ACTION (CORS-Safe GetMapping strategy)
    @GetMapping("/admin/bookings/delete/{id}")
    public String deleteBooking(@PathVariable int id) {
        try {
            appointmentRepo.deleteById(id);
            return "Booking #" + id + " successfully deleted!";
        } catch (Exception e) {
            return "Error deleting booking: " + e.getMessage();
        }
    }

    // 4. UPDATE STATUS ACTION (CORS-Safe GetMapping strategy to completely bypass port blocks)
    @GetMapping("/admin/bookings/update_status")
    public String updateBookingStatus(@RequestParam int id, @RequestParam String status) {
        try {
            Appointment app = appointmentRepo.findById(id).orElse(null);
            if (app != null) {
                app.setStatus(status);
                appointmentRepo.save(app);
                return "Status successfully updated to " + status;
            }
            return "Appointment session not found!";
        } catch (Exception e) {
            return "Error writing status: " + e.getMessage();
        }
    }

    // 5. REGISTER NEW DOCTOR NODE
    @PostMapping("/admin/doctors")
    public String addDoctor(@RequestBody Doctor doctor) {
        try {
            doctorRepo.save(doctor);
            return "Successfully Added Doctor: " + doctor.getName();
        } catch (Exception e) {
            return "Error compiling doctor node: " + e.getMessage();
        }
    }

    // 6. DELETE DOCTOR ACTION (CORS-Safe GetMapping strategy)
    @GetMapping("/admin/doctors/delete/{id}")
    public String deleteDoctor(@PathVariable int id) {
        try {
            doctorRepo.deleteById(id);
            return "Doctor profile #" + id + " successfully removed from registry!";
        } catch (Exception e) {
            return "Error deleting doctor node: " + e.getMessage();
        }
    }
}
