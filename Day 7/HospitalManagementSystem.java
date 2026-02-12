import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Doctor extends Person {
    private String specialization;

    public Doctor(String id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}

class Patient extends Person {
    private boolean discharged;

    public Patient(String id, String name) {
        super(id, name);
        this.discharged = false;
    }

    public boolean isDischarged() {
        return discharged;
    }

    public void discharge() {
        this.discharged = true;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", discharged=" + discharged +
                '}';
    }
}

class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String appointmentTime;

    public Appointment(Doctor doctor, Patient patient, String appointmentTime) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentTime = appointmentTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "doctor=" + doctor.getName() +
                ", patient=" + patient.getName() +
                ", time='" + appointmentTime + '\'' +
                '}';
    }
}

class Hospital {
    private String name;
    private List<Doctor> doctors; 
    private List<Patient> patients; 
    private List<Appointment> appointments; 
    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void scheduleAppointment(Doctor doctor, Patient patient, String time) {
        if (doctors.contains(doctor) && patients.contains(patient)) {
            appointments.add(new Appointment(doctor, patient, time));
            System.out.println("Appointment scheduled for " + patient.getName() + " with Dr. " + doctor.getName() + " at " + time);
        } else {
            System.out.println("Error: Doctor or patient not found in the hospital system.");
        }
    }

    public void dischargePatient(String patientId) {
        for (Patient patient : patients) {
            if (patient.getId().equals(patientId)) {
                patient.discharge();
                System.out.println("Patient " + patient.getName() + " (ID: " + patientId + ") discharged.");
                return;
            }
        }
        System.out.println("Patient with ID " + patientId + " not found.");
    }

    public List<Doctor> searchDoctorsBySpecialization(String specialization) {
        System.out.println("\nSearching for doctors in specialization: " + specialization);
        return doctors.stream()
                .filter(doctor -> doctor.getSpecialization().equalsIgnoreCase(specialization))
                .collect(Collectors.toList());
    }

    public void displayAllAppointments() {
        System.out.println("\nCurrent Appointments:");
        appointments.forEach(System.out::println);
    }

    public void displayAllPatients() {
        System.out.println("\nCurrent Patients:");
        patients.forEach(System.out::println);
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Hospital myHospital = new Hospital("City General Hospital");

        Doctor d1 = new Doctor("D101", "Alice Smith", "Cardiology");
        Doctor d2 = new Doctor("D102", "Bob Johnson", "Orthopedics");
        Doctor d3 = new Doctor("D103", "Charlie Brown", "Cardiology");
        myHospital.addDoctor(d1);
        myHospital.addDoctor(d2);
        myHospital.addDoctor(d3);

        Patient p1 = new Patient("P001", "Eve Adams");
        Patient p2 = new Patient("P002", "Frank White");
        myHospital.addPatient(p1);
        myHospital.addPatient(p2);

        myHospital.scheduleAppointment(d1, p1, "10:00 AM");
        myHospital.scheduleAppointment(d2, p2, "11:00 AM");

        myHospital.displayAllAppointments();

        myHospital.dischargePatient("P001");
        myHospital.displayAllPatients();

        List<Doctor> cardiologists = myHospital.searchDoctorsBySpecialization("Cardiology");
        System.out.println("Cardiologists found:");
        cardiologists.forEach(System.out::println);
    }
}
