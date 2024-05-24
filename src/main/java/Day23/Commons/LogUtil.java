package Day23.Commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {
    public static Logger log=LogManager.getLogger("Orangehrm");

    public static void inform(String logInfo){
        log.info(logInfo);
    }
    public static void error(String logError){
        log.error(logError);
    }
    public static void warning(String logWarn){
        log.warn(logWarn);
    }
}
