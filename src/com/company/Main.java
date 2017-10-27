package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Prepare to accept user input
        Scanner Keyboard = new Scanner(System.in);
        ArrayList<Person> personList = new ArrayList<>();
        ArrayList<Education> educationList = new ArrayList<>();
        ArrayList<Experience> experienceList = new ArrayList<>();
        ArrayList<Skill> skillList = new ArrayList<>();

        Person newPerson = new Person();
        Education newEducation;
        Experience newExperience;
        Skill newSkill;
        Duty newDuty;
        String answer;
        int counter=1;
        String userInput;


        // Adding personal info
        System.out.println("Enter first name  : ");
        newPerson.setFirstName(Keyboard.nextLine());
        System.out.println("Enter last name  : ");
        newPerson.setLastName(Keyboard.nextLine());
        System.out.println("Enter email address : ");
        newPerson.setEmail(Keyboard.nextLine());
        personList.add(newPerson);


        //Adding education
        System.out.println("Education (Up to 10 entries accepted): ");
        do {
            newEducation = new Education();

            System.out.println("Enter Degree (BS, MS, Phd,...: ");
            userInput=Keyboard.nextLine();

            // If user hits enter without entering any degree, they are prompted again to enter a valid degree
            if (userInput.isEmpty()){
                System.out.println("Enter a valid education: ");
                answer="A";
            }
            else {

                newEducation.setDegree(userInput);
                System.out.println("Enter Major: ");
                newEducation.setMajor(Keyboard.nextLine());
                System.out.println("Enter University name: ");
                newEducation.setUniversity(Keyboard.nextLine());
                System.out.println("Enter year of graduation: ");
                newEducation.setDate(Keyboard.nextInt());
                Keyboard.nextLine();
                counter++;
                educationList.add(newEducation);

                // Control for the max number of entries
                if (counter <= 10) {
                    // Prompting user for a new entry
                    System.out.println("(A)dd education or move to (N)ext? ");
                    answer = Keyboard.nextLine();

                } else {
                    //
                    System.out.println("You've reached the maximum allowed for education !!! ");
                    break;}
            }
        } while (answer.equalsIgnoreCase("A"));

        //Adding experience
        System.out.println("Do you want to add experience? (Y/N) " );
        userInput=Keyboard.nextLine();
        if (userInput.equalsIgnoreCase("y")) {
            counter=1;
            do {
                newExperience = new Experience();
                System.out.println("Work Experience: ");
                System.out.println("Enter Position: ");
                newExperience.setPosition(Keyboard.nextLine());
                System.out.println("Enter company name: ");
                newExperience.setCompany(Keyboard.nextLine());
                System.out.println("Enter dates(Month YYYY-Month YYYY): ");
                newExperience.setDates(Keyboard.nextLine());

                String dutyAnswer;

                //Adding duties
                do {
                    newDuty = new Duty();
                    System.out.println("Enter duties:");
                    newDuty.setDuty(Keyboard.nextLine());
                    newExperience.getDutyList().add(newDuty);

                    System.out.println("(A)dd another duty of move to (N)ext? ");
                    dutyAnswer = Keyboard.nextLine();

                } while (dutyAnswer.equalsIgnoreCase("A"));
                counter++;
                experienceList.add(newExperience);

                // Control for the max number of entries
                if (counter <= 10) {
                    System.out.println("(A)dd experience or move to (N)ext? ");
                    answer = Keyboard.nextLine();
                }else{
                    System.out.println("You've reached the maximum allowed for experience !!!  ");
                    break;
                }
            } while (answer.equalsIgnoreCase("A"));
        }


        //Adding skills
        System.out.println("Enter skills (Up to 20 enteries accepted  : ");
        counter=1;
        do {
            newSkill = new Skill();
            System.out.println("Enter Skill: ");
            userInput=Keyboard.nextLine();
            if (userInput.isEmpty()){
                System.out.println("Enter a valid skill: ");
                answer="A";
            }else {

                newSkill.setSkill(userInput);
                System.out.println("Enter ratings (highly skilled, proficient, familiar): ");
                newSkill.setRating(Keyboard.nextLine());
                counter++;
                skillList.add(newSkill);

                // Control for the max number of entries
                if (counter <= 20) {
                    // Prompting user for a new entry
                    System.out.println("(A)dd skills or move to (P)rint resume? ");
                    answer = Keyboard.nextLine();

                } else {
                    //
                    System.out.println("You've reached the maximum allowed for skills !!! ");
                    break;
                }
            }
        } while (answer.equalsIgnoreCase("A"));

        // Calling method to print resume
        PrintResume.print (personList, educationList, experienceList, skillList);
    }
}

