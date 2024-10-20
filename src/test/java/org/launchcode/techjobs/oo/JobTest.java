package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertTrue(job.getName() != null);
        assertTrue(job.getEmployer() != null);
        assertTrue(job.getLocation() != null);
        assertTrue(job.getPositionType() != null);
        assertTrue(job.getCoreCompetency() != null);

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job job2 = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String jobString = job.toString();
        String lineSeparator = System.lineSeparator();
        assertEquals(lineSeparator, jobString.substring(0, lineSeparator.length()));
        assertEquals(lineSeparator, jobString.substring(jobString.length() - lineSeparator.length()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String correctLabelsAndData = String.join(
                System.lineSeparator(),
                "",
                "ID: " + job.getId(),
                "Name: Product tester",
                "Employer: ACME",
                "Location: Desert",
                "Position Type: Quality control",
                "Core Competency: Persistence",
                ""
        );
        assertEquals(correctLabelsAndData, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job(
                "",
                new Employer(""),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency(""));
        String expectedLabelsAndData = String.join(
                System.lineSeparator(),
                "",
                "ID: " + job.getId(),
                "Name: Data not available",
                "Employer: Data not available",
                "Location: Desert",
                "Position Type: Quality control",
                "Core Competency: Data not available",
                ""
        );
        assertEquals(expectedLabelsAndData, job.toString());
    }
}
