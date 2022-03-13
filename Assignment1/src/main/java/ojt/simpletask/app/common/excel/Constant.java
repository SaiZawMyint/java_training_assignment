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
	/**
	 * <h2> AUTO_GENERATE_COURSE</h2>
	 * <p>
	 * AUTO_GENERATE_COURSE
	 * </p>
	 */
	public static final String AUTO_GENERATE_COURSE="Auto Generate Course";
	/**
	 * <h2> SKIP_UNKNOWN_COURSE</h2>
	 * <p>
	 * SKIP_UNKNOWN_COURSE
	 * </p>
	 */
	public static final String SKIP_UNKNOWN_COURSE="Skip Unknown Course";
	/**
	 * <h2> defaultSetting</h2>
	 * <p>
	 * Default setting.
	 * </p>
	 *
	 * @return
	 * @return List<String>
	 */
	public static final List<String> defaultSetting(){
		List<String> defaultsettings = new ArrayList<String>();
		defaultsettings.add(AUTO_GENERATE_COURSE);
		defaultsettings.add(SKIP_UNKNOWN_COURSE);
		return defaultsettings;
	}
}
