import java.util.LinkedList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;


public class Main {
    public static void display(OutputStream out, LinkedList<Person> list){
        PrintWriter writer = new PrintWriter(out);
        for (int i = 0; i < list.size(); i++){
                
            Person person = list.get(i);
            writer.write(person.getFirstName() + " " + person.getLastName() + " " + String.valueOf(person.getId()) + "\n");
            System.out.println("printed " + String.valueOf(i+1) + " line(s)");
                
            }
            writer.close();
       }

    public static void store(InputStream in, LinkedList<Person> list){
        Scanner sc = new Scanner(in); 
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(" ");
                String firstName = parts[0];
                String lastName = parts[1];
                int id = Integer.parseInt(parts[2]);
                list.add(new Person(firstName, lastName, id));

            }
            sc.close();
    }

    public static void find(int id, LinkedList<Person> list){
        for (int i = 0; i < list.size(); i++){
            Person person = list.get(i);
            if (person.getId() == id){

                System.out.println("found target person at index " + String.valueOf(i));
                return;
            } else {
                
            }
        }
        System.out.println("ID " + String.valueOf(id)+ " not found.");
    }

    public static void main(String[] args) {


        LinkedList<Person> personList =  new LinkedList<>();
        
        try {
            store(new FileInputStream("people.txt"), personList );
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(personList);
        try{
            display(new FileOutputStream("output.txt"), personList);
        } catch(Exception e){
            e.printStackTrace();
        }
        find(123, personList);
        find(785, personList);
        find(377, personList);
        find(999, personList);


        
    }
  
    }