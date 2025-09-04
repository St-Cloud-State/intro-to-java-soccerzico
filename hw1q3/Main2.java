
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Main2 {
    

    public static void main(String[] args) {


        PersonList people = new PersonList();
        try{
            people.store(new FileInputStream("people.txt"));
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            people.display(new FileOutputStream("output2.txt"));
        } catch(Exception e){
            e.printStackTrace();
        }
        people.find(123);
        people.find(785);
        people.find(377);
        people.find(999);


        
    }
  
    }
