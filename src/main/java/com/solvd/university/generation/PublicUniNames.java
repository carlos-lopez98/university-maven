package com.solvd.university.generation;

/*
*
* List of immutable school names -- will be used for generation in the project
*
*/

public enum PublicUniNames {

    CAL_STATE_LONG_BEACH("Cal State Long Beach"),
    CAL_STATE_SAN_DIEGO("Cal State San Diego"),
    CAL_STATE_SAN_FRANCISCO("Cal State San Francisco"),
    CAL_STATE_FRESNO("Cal State Fresno"),
    CALTECH("CalTech");


    private final String schoolName;

    PublicUniNames(String schoolName){
        this.schoolName = schoolName;
    }

    public String getSchoolName(){
        return schoolName;
    }

}
