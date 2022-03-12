package ojt.simpletask.app.common.excel;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2> Constant Class</h2>
 * <p>
 * Process for Displaying Constant
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
public class Constant {
	
	/**
	 * <h2> EXCELFILETYPE</h2>
	 * <p>
	 * EXCELFILETYPE
	 * </p>
	 */
	public static final String EXCELFILETYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	public static final String AUTO_GENERATE_COURSE="Auto Generate Course";
	public static final String SKIP_UNKNOWN_COURSE="Skip Unknown Course";
	public static final List<String> defaultSetting(){
		List<String> defaultsettings = new ArrayList<String>();
		defaultsettings.add("Auto Generate Course");
		defaultsettings.add("Skip Unknown Course");
		return defaultsettings;
	}
}
