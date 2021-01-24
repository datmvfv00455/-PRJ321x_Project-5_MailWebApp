package vn.funix.prj321x.project5.core.utils;

public class ValidationUtil {

	// --------------------------------------------------------------------------

	public static final String UUID_PATTERN = 
			"^[a-fA-F0-9]{8}"
			+ "-?[a-fA-F0-9]{4}"
			+ "-?[a-fA-F0-9]{4"
			+ "}-?[a-fA-F0-9]{4}"
			+ "-?[a-fA-F0-9]{12}$";

	public static boolean verifyUUID(String uuid) {
		if (uuid == null)
			return false;
		return uuid.matches(UUID_PATTERN);
	}

	// --------------------------------------------------------------------------

	private static final String USERNAME_PATTERN = 
			"^[a-zA-Z0-9_-]{7,}$";

	public static boolean validateUsername(String username) {
		if (username == null)
			return false;
		return username.matches(USERNAME_PATTERN);
	}

	// --------------------------------------------------------------------------

	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static boolean verifyEmail(String email) {
		if (email == null)
			return false;
		return email.matches(EMAIL_PATTERN);
	}

	// --------------------------------------------------------------------------

	// PASSWORD_PATTERN2 =
	// "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{9,}$";

	/**
	 * RegEx Description ^ The password string will start this way
	 * (?=.*[a-z]) The string must contain at least 1 lowercase alphabetical
	 * character
	 * (?=.*[A-Z] ) The string must contain at least 1 uppercase alphabetical
	 * character
	 * (?=.*[0-9]) The string must contain at least 1 numeric character
	 * (?=.*[!@#$%^&*]) The string must contain at least one special character,
	 * but
	 * we are escaping reserved RegEx characters to avoid conflict
	 * (?=.{9,}) The string must be nine characters or longer
	 * (?=\\S+$) Not contain whitespace
	 * 
	 * @param password
	 * 
	 * @return
	 */

	private static final String PASSWORD_PATTERN = 
			"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{9,}$";

	public static boolean validatePassword(String password) {
		if (password == null)
			return false;
		return password.matches(PASSWORD_PATTERN);
	}

	// --------------------------------------------------------------------------

	private static final String FULLNAME_PATTERN = 
			"^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ"
			+ "ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ"
			+ "ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$";

	public static boolean verifyFullname(String fullname) {
		if (fullname == null)
			return false;
		return fullname.matches(FULLNAME_PATTERN);
	}

	// --------------------------------------------------------------------------

	private static final String NUMBER_PATTERN = "^[0-9]*$";

	public static boolean verifyOnlyNumber(String number) {
		if (number == null)
			return false;
		return number.matches(NUMBER_PATTERN);
	}

	// --------------------------------------------------------------------------

	public static boolean isPositiveIntegerNumber(String text) {
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// --------------------------------------------------------------------------

}
