import java.util.ArrayList;
import java.util.Scanner;  


public class ScouterSchedule {
    private int currMatch;
    private int rotate;
    private ArrayList<ScouterGroups> schedule;


    public ScouterSchedule(int match, int numRotate ){
        currMatch=match;
        rotate=numRotate;
        schedule=new ArrayList<ScouterGroups>();
    }
    public void completeGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name One:");
        String nameOne = scanner.nextLine();
        System.out.println("Enter Name Two:");
        String nameTwo = scanner.nextLine();
        System.out.println("Enter Name Three:");
        String nameThree = scanner.nextLine();
        schedule.add(new ScouterGroups(nameOne, nameTwo, nameThree));
    }
    public void rotations(){
        ScouterGroups x=schedule.get(schedule.size()-1);
        schedule.remove(schedule.size()-1);
        schedule.add(0,(new ScouterGroups(x.getNameOne(), x.getNameTwo(), x.getNameThree())));
    }
    public void finalRotation(){
        int numRotations= currMatch/rotate;
        if(currMatch%rotate==0) numRotations--;
        for(int i=0;i<numRotations;i++){
            rotations();
        }
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (ScouterGroups x : schedule) {
            s.append("Name: ").append(x.getNameOne()).append(" | Name: ").append(x.getNameTwo()).append(" | Name: ").append(x.getNameThree()).append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the match number: ");
        int match = scanner.nextInt();

        System.out.print("Enter the rotation number: ");
        int numRotate = scanner.nextInt();

        ScouterSchedule s = new ScouterSchedule(match, numRotate);

        System.out.print("Enter number of groups: ");
        int numGroups = scanner.nextInt();

        for (int i = 0; i < numGroups; i++) {
            System.out.println("Entering Group " + (i + 1));
            s.completeGroup();
        }

        s.finalRotation();
        System.out.println(s.toString());
    }
}
