
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class PersonList {
    private LinkedList<Person> people = new LinkedList<>();

    public void add(Person person){
        people.add(person);
    }

    public void display(OutputStream out){
        PrintWriter writer = new PrintWriter(out);
        for (int i = 0; i < people.size(); i++){
                
            Person person = people.get(i);
            writer.write(person.getFirstName() + " " + person.getLastName() + " " + String.valueOf(person.getId()) + "\n");
            System.out.println("printed " + String.valueOf(i+1) + " line(s)");
                
            }
            writer.close();
       }

    public void store(InputStream in){
        Scanner sc = new Scanner(in); 
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(" ");
                String firstName = parts[0];
                String lastName = parts[1];
                int id = Integer.parseInt(parts[2]);
                people.add(new Person(firstName, lastName, id));

            }
            sc.close();
    }

    public void find(int id){
        for (int i = 0; i < people.size(); i++){
            Person person = people.get(i);
            if (person.getId() == id){

                System.out.println("found target person at index " + String.valueOf(i));
                return;
            } else {
                
            }
        }
        System.out.println("ID " + String.valueOf(id)+ " not found.");
    }
}
