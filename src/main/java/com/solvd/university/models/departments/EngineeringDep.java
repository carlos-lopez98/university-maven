package com.solvd.university.models.departments;

import java.util.List;

public class EngineeringDep extends Department implements Budget {

    private List<String> buildingToolsAvailable;

    public EngineeringDep(String departmentTeamName) {
        super(departmentTeamName);
    }

    @Override
    public void seeDepartmentTutoringHours() {
        System.out.println("Hours: M-F 5PM - 7PM");
    }

    @Override
    public void showBudget() {
        System.out.println("This semester's budget for the Engineering department is $350,000");
    }

    public List<String> getBuildingToolsAvailable() {
        return buildingToolsAvailable;
    }

    public void setBuildingToolsAvailable(List<String> buildingToolsAvailable) {
        this.buildingToolsAvailable = buildingToolsAvailable;
    }
}
