/***************************************************************
 *@purpose Implementing Indian States Census Analyser Problem.
 *@author Rekha
 *@version 1.0
 *@since 3-07-2021
 **************************************************************/

package censusanalyser;

public class CensusAnalyserException extends Exception 
{

    enum ExceptionType 
    {
        CENSUS_FILE_PROBLEM 
    }

    ExceptionType type;
    /** 
     * CensusAnalyserException is a class of public type
     * @param message 
     * @param type - ExceptionType
     */
    public CensusAnalyserException(String message, ExceptionType type) 
    {
        super(message);
        this.type = type;
    }
   
    /**
     * CensusAnalyserException class is public type 
     * @param message  
     * @param type - exception type
     * @param cause - throwable
     */
    
    public CensusAnalyserException(String message, ExceptionType type, Throwable cause) 
    {
        super(message, cause);
        this.type = type;
    }
}