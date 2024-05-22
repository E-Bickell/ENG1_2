package com.main.utils;

import java.util.ArrayList;

public class ScoreUtils {
    ArrayList<ArrayList<String>> recActivtities, studyTimes, meals;
    private ArrayList<String> streaks;
    int piazzaStudies;
    /** Constructs ScoreUtils - new code
     */
    public ScoreUtils(){
        this.recActivtities = new ArrayList<ArrayList<String>>();
        this.meals = new ArrayList<ArrayList<String>>();
        this.studyTimes = new ArrayList<ArrayList<String>>();
        this.streaks=new ArrayList<String>();
        this.piazzaStudies=0;
        
    }

    /** Adds a new study time - new code
     * @param time the time and place studied
     */
    public void study(ArrayList<String> time){
        studyTimes.add(time);
    }

    /** Adds a new recreational Activity time - new code
     * @param time the time and place the activity took place
     */
    public void addRecActivtity(ArrayList<String> time){
        recActivtities.add(time);
    }

    /** Adds a new eat time - new code
     * @param time the time and place that the player ate
     */
    public void eat(ArrayList<String> time){
        meals.add(time);
    }

    /** Calculates the final score - new code
     * @return int score
     */
    public int calculateFinalScore(){
        int score = 0;
        // studying related
         boolean diffLocation=false;
         int dayCheck = 1;
         boolean noneOfType = false;
        try {
            String firstLocation = studyTimes.get(0).get(1);
            score+=studyTimes.size()*5;
            for (int i = 0; i < studyTimes.size(); i++) {
                if (firstLocation != studyTimes.get(i).get(1) && !diffLocation) {
                    score += 5;
                    diffLocation = true;
                }
                if (Integer.valueOf(studyTimes.get(i).get(0)) == dayCheck) {
                    score++;
                    dayCheck++;
                } else if (Integer.valueOf(studyTimes.get(i).get(0)) > dayCheck) {
                    dayCheck = Integer.valueOf(studyTimes.get(i).get(0));
                }
            }
            if (studyTimes.size() > 7 && studyTimes.size() < 11) {
                score += 5;
            } else if (studyTimes.size() > 15) {
                score -= 15;
            } else if (studyTimes.size() > 10) {
                score -= 5;
            }
        }
        catch (Exception e) {
            noneOfType = true;
       }
        //eating regularly
       try {
           int perDay=meals.size()/7;
           if(perDay>2){
               score+=14;
          }
        
       }
       catch (Exception e) {
           noneOfType = true;
       }

        //recreation score
         if (recActivtities.size()<11){
             score+=recActivtities.size();
         }
         else{
             score+=10;
        }
        //streaks
        if (!recActivtities.isEmpty()) {
            int gymVisits = 0;
            for (int i = 0; i < recActivtities.size(); i++) {
                if (recActivtities.get(i).get(1) == "Gym_door") {
                    gymVisits += 1;
                }
            }
            if (gymVisits > 9) {
                score += 5;
                streaks.add("Gym Rat");
            }
        }
        if (!studyTimes.isEmpty()) {
            int compSciVisits = 0;
            int piazzaStudies = 0;
            for (int i = 0; i < studyTimes.size(); i++) {
                if (studyTimes.get(i).get(1) == "Comp_sci_door") {
                    compSciVisits += 1;
                }
                if (studyTimes.get(i).get(1) == "Piazza_door") {
                    piazzaStudies += 1;
                }

            }
            if (compSciVisits > 9) {
                score += 5;
                streaks.add("Hi,I'm Pepper");
            }
            if (piazzaStudies > 9) {
                score += 5;
                streaks.add("The Pizza Building");
            }
        }
        if (noneOfType){
            score = 0;
        }


        //neaten score
        if (score>100){
            score=100;
        }
        if(score<0){
            score=0;
        }
        return score;
    }

    /** Returns the streaks - new code
     * @return ArrayList streaks
     */
    public ArrayList<String> getStreaks(){
        return streaks;
    }

    /** Returns the study information - new code
     * @return ArrayList studyTimes
     */
    public ArrayList<ArrayList<String>> getStudyTimes(){
        return studyTimes;
    }

    /** Returns the meal times - new code
     * @return ArrayList meals
     */
    public ArrayList<ArrayList<String>> getMealTimes(){
        return meals;
    }

    /** Returns the recreational activity times - new code
     * @return ArrayList recActivities
     */
    public ArrayList<ArrayList<String>> getRecTimes(){
        return recActivtities;
    }

    public int getpizzastreak(){
        return(piazzaStudies);
    }
}
