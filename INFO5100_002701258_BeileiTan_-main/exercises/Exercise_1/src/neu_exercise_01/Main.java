package neu_exercise_01;

import java.util.*;

class Student {
    String name;
    int[] quizScores;

    public Student(String name, int[] quizScores) {
        this.name = name;
        this.quizScores = quizScores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int[] getQuizScores() {
        return quizScores;
    }

    public void setQuizScores(int[] quizScores) {
        this.quizScores = quizScores;
    }

}

class FullTime extends Student {
    int[] examScores = new int[2];

    //Full-time students will have an extra field to hold two Exam scores
    public FullTime(String name, int[] quizScores, int[] examScores) {
        super(name, quizScores);
        this.examScores = examScores;
    }

    public int[] getExamScores() {
        return examScores;
    }

    public void setExamScores(int[] examScores){
        this.examScores = examScores;
    }
}

class PartTime extends Student {
    public PartTime(String name, int[] quizScores) {
        super(name, quizScores);
    }
}

// Create a class Session

// Use data structure to hold 20 students in a Session, some are part-time, some are full-time

class Session {

    public Session(){
    }

    //Create public methods to calculate average quiz scores per student for the whole class
    public double getAverage(int[] quizScores){
        double sum = 0;
        for(int i = 0; i < quizScores.length; i++){
            sum += quizScores[i];
        }
        return  sum / quizScores.length;
    }

  // Create public method to print the list of quiz scores in ascending order for one session
   public void printQuizInAscendingOrder(int[] quizScores){
        Arrays.sort(quizScores);
        System.out.print("Grade in ascending order for this student:  ");
        for (int i = 0; i < quizScores.length; i++) {
            System.out.print(quizScores[i] + " ");
        }
       System.out.println();
   }
   //Create public method to print names of part-time students
   public void printNmaePartTime(String name){
        System.out.print("part-time student: ");
        System.out.print(name + " ");
        System.out.println();
    }

    //Create public method to print exam scores of full-time students
    public void printExamScore(int[] eScores){
        System.out.print("Exam score for full-time student:  ");
        for(int i = 0; i < eScores.length; i++){
            System.out.print(eScores[i] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        FullTime[] fullTimes = new FullTime[20];
        PartTime[] partTimes = new PartTime[20];
        Session session = new Session();
        //create random object
        Random ran = new Random();

        for (int i = 0; i < 20; i++) {
            //Given randomly input quiz scores and exam scores
            int[] qScore = new int[15];
            for (int j = 0; j < qScore.length; j++) {
                qScore[j] = ran.nextInt(100);
            }
            int[] eScores = new int[2];
            for (int k = 0; k < eScores.length; k++) {
                eScores[k] = ran.nextInt(100);
            }
            //Randomly classified some are Full-time, others are Part-time
            if (Math.random() > 0.5) {
                fullTimes[i] = new FullTime("FullTime" + i, qScore, eScores);
                //fullTimes[i].setName("FullTime" + i);
                fullTimes[i].setQuizScores(qScore);
                fullTimes[i].setExamScores(eScores);
                System.out.println("qScore: " + Arrays.toString(fullTimes[i].getQuizScores()));
                session.printExamScore(eScores);
                //System.out.println(fullTimes[i].getName() + "，qSore:" + Arrays.toString(fullTimes[i].getQuizScores()) + ", eScore:" + Arrays.toString(fullTimes[i].getExamScores()));
            } else {
                partTimes[i] = new PartTime("Partime" + i, qScore);
                partTimes[i].setName("Partime" + i);
                partTimes[i].setQuizScores(qScore);
                System.out.println("qScore: " + Arrays.toString(partTimes[i].getQuizScores()));
                session.printNmaePartTime(partTimes[i].getName());
                //System.out.println(partTimes[i].getName() + "，qSore:" + Arrays.toString(partTimes[i].getQuizScores()));
            }
            System.out.println("average score for this student: "+ session.getAverage(qScore));
            session.printQuizInAscendingOrder(qScore);
            System.out.println();
        }
    }
}
