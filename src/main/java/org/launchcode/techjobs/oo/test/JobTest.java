package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job jobTest1 = new Job();
        Job jobTest2 = new Job();
        assertNotSame(jobTest1,jobTest2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobTest3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(jobTest3.getName(),"Product tester");
        assertEquals(jobTest3.getEmployer().getValue(),"ACME");
        assertEquals(jobTest3.getLocation().getValue(), "Desert");
        assertEquals(jobTest3.getPositionType().getValue(), "Quality control");
        assertEquals(jobTest3.getCoreCompetency().getValue(), "Persistence");
        assertTrue(jobTest3 instanceof Job);
        assertTrue(jobTest3.getEmployer() instanceof Employer);
        assertTrue(jobTest3.getLocation() instanceof Location);
        assertTrue(jobTest3.getPositionType() instanceof PositionType);
        assertTrue(jobTest3.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality(){
        Job jobTest4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTest5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(jobTest4.equals(jobTest5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job jobTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char first = jobTest.toString().charAt(0);
        char last = jobTest.toString().charAt(jobTest.toString().length()-1);
        assertEquals(first, '\n');
        assertEquals(last, '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job jobTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(jobTest.toString().contains("ID: "));
        assertEquals(jobTest.getName(),"Product tester");

//        assertEquals(jobTest.getName(),"Product tester");
//        assertEquals(jobTest.getEmployer().getValue(),"ACME");
//        assertEquals(jobTest.getLocation().getValue(),"Desert");
//        assertEquals(jobTest.getPositionType().getValue(),"Quality control");
//        assertEquals(jobTest.getCoreCompetency().getValue(),"Persistence");
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job jobTest = new Job("", new Employer("ACME"), new Location(""), new PositionType(""), new CoreCompetency(""));
        System.out.println(jobTest.getName());
        assertEquals("\nID: " + jobTest.getId() + "\nName: Data not available\nEmployer: ACME\nLocation: Data not available" +
                "\nPosition Type: Data not available\nCore Competency: Data not available\n", jobTest.toString());
//        assertEquals(jobTest.getEmployer().getValue(),"Data not available");
//        assertEquals(jobTest.getLocation().getValue(), "Data not available");
//        assertEquals(jobTest.getPositionType().getValue(), "Data not available");
//        assertEquals(jobTest.getCoreCompetency().getValue(), "Data not available");

    }


}
