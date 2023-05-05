package com.solvd.university.models.departments;

public abstract class Department {

    private String departmentTeamName;

    public Department(String departmentTeamName) {
        this.departmentTeamName = departmentTeamName;
    }

    //Abstract Method
    public abstract void seeDepartmentTutoringHours();

    public String getDepartmentTeamName() {
        return departmentTeamName;
    }

    public void setDepartmentTeamName(String departmentTeamName) {
        this.departmentTeamName = departmentTeamName;
    }

}
