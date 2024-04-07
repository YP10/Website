import java.util.ArrayList;


public class ScouterSchedule {
    private int curMatch;
    private int numRotate;
    private ArrayList<ScouterGroups> schedule;


    public ScouterSchedule(int match, int rotate ){
        curMatch=match;
        numRotate=rotate;
        schedule=new ArrayList<ScouterGroups>();
    }
    public void completeGroup(String nameOne, String nameTwo, String nameThree){
        schedule.add(new ScouterGroups(nameOne, nameTwo, nameThree));
        
    }
    public void rotations(){
        ScouterGroups x=schedule.get(schedule.size()-1);
        schedule.remove(schedule.size()-1);
        schedule.add(0,(new ScouterGroups(x.getNameOne(), x.getNameTwo(), x.getNameThree())));
    }
    public void duplicateGroups(){
        for(int k = 1; k < curMatch; k++){
            if ((k-1)% numRotate == 0) {
                rotations();
            }
            for(int i = 0; i < 3; i++){
                schedule.add(new ScouterGroups(schedule.get(i).getNameOne(), schedule.get(i).getNameTwo(), schedule.get(i).getNameThree()));
            }
            
        }
    }
    

            
        
    

    public void currSchedule(){
        for(int i=0;i<schedule.size();i++){
            
        }
        
    }
    public String toString(){
        String s=" ";
        for(ScouterGroups x: schedule){
            s+=("{Name: " + x.getNameOne() + " Name: " + x.getNameTwo()+" Name: " + x.getNameThree()+"}"+"\n");
        }
        return s;
    }
    
    public static void main(String [] args){
        ScouterSchedule s=new ScouterSchedule(6,3);
        s.completeGroup("Angel","Zander","Mark");
        s.completeGroup("Charles","Ishaan","Asher");
        s.completeGroup("Pedro","Krish","Declan");
        s.duplicateGroups();
        System.out.println(s.toString());
    }
}
