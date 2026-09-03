# Introduction to Object Oriented Programming
- create GPA calculation program
	- [x] student details (Name, SID, Major, GPA)
	- [x] student class seperate from main class
- use java
	- [x] use private modifier for attribute and public for method
	- [x] provide example for encapsulation and methods
	- [x] use scanner for input 
- show student detail in a list
	- [x] minimal 3 student object
	- [x] use loop to show data
	- [x] calculate passing status

**Pathfinder :**
[[#Q1 Create class and objects]]
[[#Q2 Apply encapsulation and method]]
[[#Q3 Automate Academic Predicate]]

# Q1 Create class and objects
- Create student class
	- Name, SID, Major, GPA
- add constructor to initialize data
- method to display info
- create 5 different student objects

**Code**
```
// student class
class Student {
    // Attributes for students
    String name;
    String sId;
    Major major;
    float gpa;

    // enum for Major
    enum Major {
        Physics,
        Mathematics,
        Engineering,
        Explosions,
        Music
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
        System.out.println("");
    }
}

// main class
public class tas1GpaCalc {
    public static void main(String[] args) {
        // declaring arraylist for the students so its loopable
        Student[] students = {
            // student objects
            new Student("Uzi Doorman", "44467001", Student.Major.Explosions, 3.2f),
            new Student("Bob Kerman", "44467002", Student.Major.Engineering, 4.0f),
            new Student("Kasane Teto", "44467003", Student.Major.Physics, 2.6f),
            new Student("Rice Shower", "44467004", Student.Major.Mathematics, 3.6f),
            new Student("Kanade Yoisaki", "44467005", Student.Major.Music, 3.8f),
        };
        
        System.out.println("===Student Data===");
        // Iterating using for loop
        for (Student student : students) {
            student.displayInfo();
        }
    }
}
```
**Output**
![[ss-T1-1.png]]
# Q2 Apply encapsulation method
- change GPA to private
- make getter and setter to access  GPA
- add method to calc passing status
	- GPA > 3.00 = Passed || GPA < 3.00 = Fail
- add method to change/update GPA
- show the full information after GPA change

**Code**
```
import java.util.Scanner; // use scanner lib for input
// student class
class Student {
    // Attributes for students
    String name;
    String sId;
    Major major;
    private float gpa; //private

    // enum for Major
    enum Major {
        Physics,
        Mathematics,
        Engineering,
        Explosions,
        Music
    }
    // enum for status
    enum Status {Pass, Fail}

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

        System.out.println("");
    }
    
    // method to get gpa
    public float getGpa() {return gpa;}

    // method to set gpa
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
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
                case 1:
                    System.out.println("===Student Data===");
                    // Iterating in student array using for loop
                    for (Student student : students) {
                        student.displayInfo();
                    }
                    break;
                case 2:
                    String searchSid;
                    System.out.println("==================");
                    System.out.println("Enter Student Id: ");
                    searchSid = scanner.nextLine();
                    boolean found = false; //declare found state
                    
                    // iterate in student array
                    for(Student student : students){
                        if(student.sId.equals(searchSid)){ // check comparison between strings
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
                    break;
                case 3:
                    System.out.println("==================");
                    System.out.println("Exiting program adios!");
                    break;
                    
            }
        } while (choice != 3);
        scanner.close();
    }
}
```

**Output**
![[ss-T1-2.png]]

# Q3 Automate Academic Predicate
- add method to calculate the predicate
	- GPA > 3.75 = With Honor
	- GPA 3.50 - 3.75 = Very Satisfying
	- GPA 3.00 - GPA 3.50 = Satisfying
	- GPA < 3.00 = Need Fixing
- show the full details

**Code + little improvement**
```
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
```

**Output**
![[ss-T1-3.png]]

reference :
Scanner https://www.w3schools.com/java/java_user_input.asp
Array object https://www.geeksforgeeks.org/java/how-to-create-array-of-objects-in-java/
Getter Setter https://www.geeksforgeeks.org/java/getter-and-setter-in-java/
Newline Error https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo