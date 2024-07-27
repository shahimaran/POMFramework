package utils;

import java.util.Hashtable;

public class TestDataProvider {

    /******************************** to the Data for TestCase *********************************************/


    public static Object[][] getTestData(String DataFileName, String SheetName, String TestName) {
        ReadExcelDateFile readdata = new ReadExcelDateFile(System.getProperty("user.dir") + "\\src\\main\\resources\\DataFile\\" + DataFileName);

        String sheetName = SheetName;
        String testName = TestName;

        // Find start row of testcase
        int startRowNum = 0;
        while (!readdata.getCellData(sheetName, 0, startRowNum).equalsIgnoreCase(testName)) {
            startRowNum++;
        }

        int startTestColumn = startRowNum + 1;
        int startTestRow = startRowNum + 2;

        // Find number of rows of testcase
        int rows = 0;
        while (!readdata.getCellData(sheetName, 0, startTestRow + rows).equals("")) {
            rows++;
        }
        //System.out.println("Total number of Rows In Test : " + testName + " is : " + rows);

        int colmns = 0;
        while (!readdata.getCellData(sheetName, colmns, startTestColumn).equals("")) {
            colmns++;
        }


        Object[][] dataSet = new Object[rows][1];
        Hashtable<String, String> dataTable = null;

        int dataRowNumber = 0;
        for (int i = startTestRow; i <= startTestColumn + rows; i++) {
            dataTable = new Hashtable<String, String>();
            for (int j = 0; j < colmns; j++) {

                String key = readdata.getCellData(sheetName, j, startTestColumn);
                String value = readdata.getCellData(sheetName, j, i);
                dataTable.put(key, value);

            }
            //store data in 2d array assigning the data table to data det
            dataSet[dataRowNumber][0] = dataTable;
            dataRowNumber++;
        }
        return dataSet;

    }
}
