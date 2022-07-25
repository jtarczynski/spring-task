package com.deloitte.carApp;

import com.deloitte.carApp.facility.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql(value = "/scripts/facilityServiceTestScripts/FacilityServiceTestSetUp.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/scripts/facilityServiceTestScripts/FacilityServiceTestCleanUp.sql",
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class FacilityServiceTests {

    @Autowired
    private FacilityService facilityService;





}
