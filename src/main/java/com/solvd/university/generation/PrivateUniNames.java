package com.solvd.university.generation;


/*
*
* Immutable list of private school names -- using for generation purposes
*
*/


public enum PrivateUniNames {
    STANFORD("Stanford University"),
    UCLA("University of California, Los Angeles"),
    UNIVERSITY_OF_THE_PACIFIC("University of the Pacific"),
    USC("University of Southern California"),
    SANTA_CLARA_UNIVERSITY("Santa Clara University");

    private final String schoolName;

    PrivateUniNames(String schoolName) {
        this.schoolName = schoolName;
    }


    public String getSchoolName(){
        return schoolName;
    }
}
