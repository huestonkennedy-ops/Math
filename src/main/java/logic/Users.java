package logic;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import user.User;
import subject.Subject;

public class Users {
    HashMap<String, User> users = new HashMap<>();
    Subject[] subjects = Subject.values();
    User activeUser;
    public void writeToFile() {
        try {
        PrintWriter writer = new PrintWriter("UserInfo.txt");
        for(User i: users.values()) {
            writer.println(i.toString());
        }
        writer.close();
    }catch(Exception e) {
        System.out.println("Something went wrong" + e.getMessage());
    }
    }
    public void printUsers() {
        for(User i: users.values()) {
            System.out.println(i.getName());
        }
    }
    public void read() {
        try(Scanner scanner = new Scanner(Paths.get("UserInfo.txt"))) {
            while(scanner.hasNextLine()) {
                String user = scanner.nextLine();
                String[] info = user.split(",");
                users.put(info[0], new User(info[0], info[1]));
                for(int i = 0; i<subjects.length; i ++) {
                    String[] score = new String[2];
                    try {
                        score = info[i+2].split("/");
                    } catch(Exception e) {
                        score[0] = "0";
                        score[1] = "0";
                    }
                    try {
                    users.get(info[0]).setScore(Integer.valueOf(score[0]), Integer.valueOf(score[1]), subjects[i]);
                    } catch(Exception e) {
                        users.get(info[0]).setScore(0, 0, subjects[i]);
                    }
                }
            }
            
        } catch(Exception e) {
            System.out.println("Couldn't get users: " + e.getMessage());
        }
    }
    public void setActiveUser(String name, String password) throws Exception {
        if(!(users.containsKey(name) && users.get(name).unlock(name, password))) {
            throw new FileNotFoundException("invalid name or password");
        }
        activeUser = users.get(name);
    }
    public User activeUser() {
        return activeUser;
    }
    public void createUser(String name, String password) {
        users.put(name, new User(name, password));
    }
    public boolean hasUser(String name) {
        return users.containsKey(name);
    }

}
