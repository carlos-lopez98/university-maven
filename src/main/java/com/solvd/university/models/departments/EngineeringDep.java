package com.solvd.university.models.departments;

import com.solvd.university.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class EngineeringDep extends Department implements Budget {

    private Logger logger = LogManager.getLogger(Main.class);

    private List<String> buildingToolsAvailable;

    public EngineeringDep(String departmentTeamName) {
        super(departmentTeamName);
    }

    @Override
    public void seeDepartmentTutoringHours() {
        logger.info("Hours: M-F 5PM - 7PM");
    }

    @Override
    public void showBudget() {
        logger.info("This semester's budget for the Engineering department is $350,000");
    }

    public List<String> getBuildingToolsAvailable() {
        return buildingToolsAvailable;
    }

    public void setBuildingToolsAvailable(List<String> buildingToolsAvailable) {
        this.buildingToolsAvailable = buildingToolsAvailable;
    }
}
