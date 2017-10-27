package com.company;

import java.util.ArrayList;

class PrintResume {

    static void print(ArrayList<Person> personList, ArrayList<Education> educationList,
                      ArrayList<Experience> experienceList, ArrayList<Skill> skillList) {
        System.out.println("========================================================");

        //Displaying personal info
        for (Person eachPerson : personList) {
            System.out.println(eachPerson.getFirstName() + " " + eachPerson.getLastName());
            System.out.println(eachPerson.getEmail());
            System.out.println();
        }

        //Displaying education
        System.out.println("Education");
        for (Education eachEducation : educationList) {
            System.out.println(eachEducation.getDegree() + " in " + eachEducation.getMajor() + ",");
            System.out.println(eachEducation.getUniversity() + ", " + eachEducation.getDate());
            System.out.println();

        }
        //Displaying experience
        System.out.println("Experience");
        for (Experience eachExperience : experienceList) {
                System.out.println(eachExperience.getPosition());
                System.out.println(eachExperience.getCompany() + ", " + eachExperience.getDates());

             int count = 1;
             for (Duty eachDuty : eachExperience.getDutyList()) {
                 System.out.println("-Duty " + count + ", " + eachDuty.getDuty());
                count++;
             }
             System.out.println();
        }

        //Displaying skills
        System.out.println("Skills");
        for (Skill eachSkill : skillList) {
             System.out.println(eachSkill.getSkill() + ", " + eachSkill.getRating());

        }
    }

}
