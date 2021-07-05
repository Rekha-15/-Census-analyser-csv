/***************************************************************
 *@purpose Implementing Indian States Census Analyser Problem.
 *@author Rekha
 *@version 1.0
 *@since 3-07-2021
 **************************************************************/
package censusanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * CensusAnalyserTest is a test class
 * testing weather it return given Indian Census CSVFile Returns Correct Records.
 * and testing giving India CensusData withWrong File Should Throw Exception
 */
public class CensusAnalyserTest {

    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    static String INCORRECT = "./src/test/resources/CensusDataIncorrectDelimiter.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    public static final String INDIAN_STATE_CODE_FILE = "C:\\CensusAnalyser (1)\\CensusAnalyser\\src\\test\\resources\\IndiaStateCode";

    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() 
    {
        try 
        {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
        } catch (CensusAnalyserException e) { }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() 
    {
        try 
        {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
    @Test
    public void givenIndianStateCodeCSVFile_ReturnsCorrectRecords() {
        try {
            int count = CensusAnalyser.loadCodeData(INDIAN_STATE_CODE_FILE);
            System.out.println(count);
            Assert.assertEquals(37, count);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    
    @Test
	public void givenIndianStateCodeCSVFile_WhenCorrectButDelimitorIsIncorrect_ThrowsCustomException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			@SuppressWarnings("unused")
			int numOfRecords = censusAnalyser.loadIndiaCensusData(INCORRECT);
		}
		catch(CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
		}	
	}

}