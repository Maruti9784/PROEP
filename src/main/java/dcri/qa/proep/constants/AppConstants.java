package dcri.qa.proep.constants;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
	
	public static final int DEFAULT_LONG_TIME_OUT = 20;
	public static final int DEFAULT_MEDIUM_TIME_OUT = 10;
	public static final int DEFAULT_SHORT_TIME_OUT = 5;
	public static final int DEFAULT_SHORTEST_TIME_OUT = 2;
	public static final int DEFAULT_ONE_MIN_TIME_OUT = 1;

	
	public static final List<String> EXPECTED_HOME_PAGE_HEADERS_LIST = Arrays.asList("Home", "ACD Phone System", 
			"Add a Schedule", "User", "Projects", "Reports", "Forecasting", "Requests", "Communications Hub", "Configuration", "Learning Center");
}
