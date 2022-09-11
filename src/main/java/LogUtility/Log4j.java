package LogUtility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4j 
{	
	public static void logInfo(String message)
	{
		Logger log= Logger.getLogger("Log4j");
		PropertyConfigurator.configure("Log4j.properties");
		log.info(message);
	}
	
	public static void logDebug(String message)
	{
		Logger log= Logger.getLogger("Log4j");
		PropertyConfigurator.configure("Log4j.properties");
		log.debug(message);
	}
	
	public static void logFatal(String message)
	{
		Logger log= Logger.getLogger("Log4j");
		PropertyConfigurator.configure("Log4j.properties");
		log.fatal(message);
	}
	
	public static void logError(String message)
	{
		Logger log= Logger.getLogger("Log4j");
		PropertyConfigurator.configure("Log4j.properties");
		log.error(message);
	}
	
	public static void logWarn(String message)
	{
		Logger log= Logger.getLogger("Log4j");
		PropertyConfigurator.configure("Log4j.properties");
		log.warn(message);
	}

}
