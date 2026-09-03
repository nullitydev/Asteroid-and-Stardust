import java.util.Scanner; // use scanner lib for input
// student class
class Student {
    // Attributes for students
    private final String name;
    private final String sId;
    private final Major major;
    private float gpa; //private
   
    // enum for status
    enum Status {Pass, Fail}
    // enum for Major
    enum Major {
        Physics,
        Mathematics,
        Engineering,
        Explosions,
        Music
    }
    
    // enum for predicate
    enum Predicate {
        WithHonor,
        VerySatisfying,
        Satisfying,
        NeedFixing;

        // Method to define predicate
        public static Predicate calculate(float gpa) {
            if (gpa > 3.75) {
                return WithHonor;
            } else if (gpa >= 3.50) {
                return VerySatisfying;
            } else if (gpa >= 3.00) {
                return Satisfying;
            } else {
                return NeedFixing;
            }
        }
    }

    // student constructor to initialize the student data
    public Student(String name, String sId, Major major, float gpa) {
        this.name = name;
        this.sId = sId;
        this.major = major;
        this.gpa = gpa;
    }
    
    // method to display student info
    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Student Id: " + sId);
        System.out.println("Major: " + major);
        System.out.println("GPA: " + gpa);
        // using tenrary op to check gpa value
        Status status = (gpa >= 3.0) ? Status.Pass : Status.Fail;
        System.out.println("Status: " + status);
        // using the calculate method
        Predicate predicate = Predicate.calculate(gpa);
        System.out.println("Predicate: " + predicate);

        System.out.println("");
    }
    
    // method to get gpa
    public float getGpa() {return gpa;}

    // method to set gpa
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getSid() {return sId;}
}

// main class
public class tas1GpaCalc {
    public static void main(String[] args) {
        //initializing scanner instance
        Scanner scanner = new Scanner(System.in); 
        
        // declaring arraylist for the students so its loopable
        Student[] students = {
            // student objects
            new Student("Uzi Doorman", "44467001", Student.Major.Explosions, 3.25f),
            new Student("Bob Kerman", "44467002", Student.Major.Engineering, 4.0f),
            new Student("Kasane Teto", "44467003", Student.Major.Physics, 2.6f),
            new Student("Rice Shower", "44467004", Student.Major.Mathematics, 3.6f),
            new Student("Kanade Yoisaki", "44467005", Student.Major.Music, 3.8f),
        };
        
        // replace to use choice system because nice
        int choice;
        do { 
            System.out.println("==================");
            System.out.println("1. Show all Student data");
            System.out.println("2. Update Student GPA");
            System.out.println("3. Exit");
            System.out.println("Enter a number:");
            
            //using scanner for input
            choice = scanner.nextInt();
            scanner.nextLine(); //stupid leftover line consumer hungry
            
            switch (choice) {
                case 1 -> {
                    System.out.println("===Student Data===");
                    // Iterating in student array using for loop
                    for (Student student : students) {
                        student.displayInfo();
                    }
                }
                case 2 -> {
                    String searchSid;
                    System.out.println("==================");
                    System.out.println("Enter Student Id: ");
                    searchSid = scanner.nextLine();
                    boolean found = false; //declare found state
                    
                    // iterate in student array
                    for(Student student : students){
                        if(student.getSid().equals(searchSid)){ // check comparison between strings
                            found = true; //set found to true
                            
                            System.out.println("Enter new GPA: ");
                            float newGpa = scanner.nextFloat(); //save input into temporary variable
                            student.setGpa(newGpa); //set input into private gpa variable with setter
                            System.out.println("Data Updated Awesomesauce");
                            System.out.println("");

                            student.displayInfo(); // show updated data
                            break;
                        }
                    }
                    // set error if not found
                    if(!found) {
                        System.out.println("Cowabummer id not found buddy womp womp");
                    }
                }
                case 3 -> {
                    System.out.println("==================");
                    System.out.println("Exiting program adios!");
                }
                    
            }
        } while (choice != 3);
        scanner.close();
    }
}