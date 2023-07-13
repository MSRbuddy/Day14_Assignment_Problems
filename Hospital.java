import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Patient {
    private String name;
    private int age;
    private String contactNumber;

    public Patient(String name, int age, String contactNumber) {
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Contact Number: " + contactNumber;
    }
}

class Hospital {
    private String name;
    private String location;
    private List<Patient> patients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(String name) {
        this.patients = patients;
    }

    public Hospital(String name, String location) {
        this.name = name;
        this.location = location;
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient added successfully.");
    }

    public void deletePatient(Patient patient) {
        patients.remove(patient);
        System.out.println("Patient deleted successfully.");
    }

    public void editPatient(Patient patient, String newName, int newAge, String newContactNumber) {
        patient.setName(newName);
        patient.setAge(newAge);
        patient.setContactNumber(newContactNumber);
        System.out.println("Patient edited successfully.");
    }

    public void searchPatient(String name) {
        boolean found = false;
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                found = true;
                System.out.println("Patient found: " + patient);
                break;
            }
        }
        if (!found) {
            System.out.println("Patient not found.");
        }
    }

    public void printAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found in the hospital.");
        } else {
            System.out.println("All patients in the hospital:");
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }
}

class HospitalManagementSystem {
    private Map<Hospital, List<Patient>> hospitalPatientMap;

    public HospitalManagementSystem() {
        hospitalPatientMap = new HashMap<>();
    }

    public void addHospital(Hospital hospital) {
        hospitalPatientMap.put(hospital, new ArrayList<>());
        System.out.println("Hospital added successfully.");
    }

    public void addPatientToHospital(Hospital hospital, Patient patient) {
        if (hospitalPatientMap.containsKey(hospital)) {
            List<Patient> patients = hospitalPatientMap.get(hospital);
            patients.add(patient);
            System.out.println("Patient added to the hospital successfully.");
        } else {
            System.out.println("Hospital not found.");
        }
    }

    public void deletePatientFromHospital(Hospital hospital, Patient patient) {
        if (hospitalPatientMap.containsKey(hospital)) {
            List<Patient> patients = hospitalPatientMap.get(hospital);
            patients.remove(patient);
            System.out.println("Patient deleted from the hospital successfully.");
        } else {
            System.out.println("Hospital not found.");
        }
    }

    public void editPatientInHospital(Hospital hospital, Patient patient, String newName, int newAge, String newContactNumber) {
        if (hospitalPatientMap.containsKey(hospital)) {
            hospital.editPatient(patient, newName, newAge, newContactNumber);
        } else {
            System.out.println("Hospital not found.");
        }
    }

    public void searchPatientInHospital(Hospital hospital, String name) {
        if (hospitalPatientMap.containsKey(hospital)) {
            hospital.searchPatient(name);
        } else {
            System.out.println("Hospital not found.");
        }
    }

    public void printAllPatientsInHospital(Hospital hospital) {
        if (hospitalPatientMap.containsKey(hospital)) {
            hospital.printAllPatients();
        } else {
            System.out.println("Hospital not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalManagementSystem hospitalManagementSystem = new HospitalManagementSystem();

        while (true) {
            System.out.println("\n---- Hospital Management System Menu ----");
            System.out.println("1. Add Hospital");
            System.out.println("2. Add Patient to Hospital");
            System.out.println("3. Delete Patient from Hospital");
            System.out.println("4. Edit Patient in Hospital");
            System.out.println("5. Search Patient in Hospital");
            System.out.println("6. Print All Patients in Hospital");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter hospital name: ");
                    String hospitalName = scanner.nextLine();
                    System.out.print("Enter hospital location: ");
                    String hospitalLocation = scanner.nextLine();

                    Hospital newHospital = new Hospital(hospitalName, hospitalLocation);
                    hospitalManagementSystem.addHospital(newHospital);
                    break;

                case 2:
                    System.out.print("Enter hospital name: ");
                    String addPatientHospitalName = scanner.nextLine();
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter patient age: ");
                    int patientAge = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter patient contact number: ");
                    String patientContactNumber = scanner.nextLine();

                    Patient newPatient = new Patient(patientName, patientAge, patientContactNumber);
                    Hospital addPatientHospital = getHospitalByName(hospitalManagementSystem, addPatientHospitalName);
                    if (addPatientHospital != null) {
                        hospitalManagementSystem.addPatientToHospital(addPatientHospital, newPatient);
                    } else {
                        System.out.println("Hospital not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter hospital name: ");
                    String deletePatientHospitalName = scanner.nextLine();
                    System.out.print("Enter patient name: ");
                    String deletePatientName = scanner.nextLine();

                    Hospital deletePatientHospital = getHospitalByName(hospitalManagementSystem, deletePatientHospitalName);
                    if (deletePatientHospital != null) {
                        Patient deletePatient = getPatientByName(deletePatientHospital, deletePatientName);
                        if (deletePatient != null) {
                            hospitalManagementSystem.deletePatientFromHospital(deletePatientHospital, deletePatient);
                        } else {
                            System.out.println("Patient not found.");
                        }
                    } else {
                        System.out.println("Hospital not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter hospital name: ");
                    String editPatientHospitalName = scanner.nextLine();
                    System.out.print("Enter patient name: ");
                    String editPatientName = scanner.nextLine();

                    Hospital editPatientHospital = getHospitalByName(hospitalManagementSystem, editPatientHospitalName);
                    if (editPatientHospital != null) {
                        Patient editPatient = getPatientByName(editPatientHospital, editPatientName);
                        if (editPatient != null) {
                            System.out.print("Enter updated patient name: ");
                            String updatedPatientName = scanner.nextLine();
                            System.out.print("Enter updated patient age: ");
                            int updatedPatientAge = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character
                            System.out.print("Enter updated patient contact number: ");
                            String updatedPatientContactNumber = scanner.nextLine();

                            hospitalManagementSystem.editPatientInHospital(editPatientHospital, editPatient, updatedPatientName, updatedPatientAge, updatedPatientContactNumber);
                        } else {
                            System.out.println("Patient not found.");
                        }
                    } else {
                        System.out.println("Hospital not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter hospital name: ");
                    String searchPatientHospitalName = scanner.nextLine();
                    System.out.print("Enter patient name to search: ");
                    String searchPatientName = scanner.nextLine();

                    Hospital searchPatientHospital = getHospitalByName(hospitalManagementSystem, searchPatientHospitalName);
                    if (searchPatientHospital != null) {
                        hospitalManagementSystem.searchPatientInHospital(searchPatientHospital, searchPatientName);
                    } else {
                        System.out.println("Hospital not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter hospital name: ");
                    String printPatientsHospitalName = scanner.nextLine();

                    Hospital printPatientsHospital = getHospitalByName(hospitalManagementSystem, printPatientsHospitalName);
                    if (printPatientsHospital != null) {
                        hospitalManagementSystem.printAllPatientsInHospital(printPatientsHospital);
                    } else {
                        System.out.println("Hospital not found.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Hospital getHospitalByName(HospitalManagementSystem hospitalManagementSystem, String hospitalName) {
        for (Hospital hospital : hospitalManagementSystem.hospitalPatientMap.keySet()) {
            if (hospital.getName().equalsIgnoreCase(hospitalName)) {
                return hospital;
            }
        }
        return null;
    }

    private static Patient getPatientByName(Hospital hospital, String patientName) {
        for (Patient patient : hospital.getPatients()) {
            if (patient.getName().equalsIgnoreCase(patientName)) {
                return patient;
            }
        }
        return null;
    }
}
