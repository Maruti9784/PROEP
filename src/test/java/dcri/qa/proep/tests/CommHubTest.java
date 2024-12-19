package dcri.qa.proep.tests;

import org.testng.annotations.Test;
import dcri.qa.proep.base.BaseTest;
import dcri.qa.proep.utils.ExcelUtil;

public class CommHubTest extends BaseTest {

    @Test
    public void testFillCommunicationEntryForm() throws InterruptedException {
        String sheetName = "Comm Hub"; // Replace with your actual sheet name
        Object[][] data = ExcelUtil.getTestData(sheetName);

        // Navigate to Communications Hub once
        commhubpage.navigateToCommunicationsHub();

        for (Object[] record : data) {
            try {
                String studyNumber = (String) record[0];
                String firstName = (String) record[1];
                String lastName = (String) record[2];
                String email = (String) record[3];
                String confirmEmail = (String) record[4];
                String cell = (String) record[5];
                String confirmCell = (String) record[6];
                String home = (String) record[7];
                String confirmHome = (String) record[8];
                String work = (String) record[9];
                String confirmWork = (String) record[10];
                String formTopic = (String) record[11];
                String callStartDate = (String) record[12];
                String hours = (String) record[13];
                String minutes = (String) record[14];
                String amPm = (String) record[15];
                String methodOfCommunication = (String) record[16];
                String communicationDetail = (String) record[17];
                String whoCompletedInterview = (String) record[18];
                String yo = (String) record[19];

                // Fill the form for each record
                commhubpage.fillCommunicationEntryForm(
                    studyNumber, firstName, lastName, email, confirmEmail,
                    cell, confirmCell, home, confirmHome, work, confirmWork,
                    formTopic, callStartDate, hours, minutes, amPm,
                    methodOfCommunication, communicationDetail, whoCompletedInterview, yo);
            } catch (Exception e) {

            	System.err.println("Error processing record: " + e.getMessage());
                e.printStackTrace();
                // Optionally, you can continue to the next iteration
            }
        }
    }
}
