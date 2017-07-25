package utils;

/**
 * Created by Виктор on 24.07.2017.
 */
public class StringUtils {

    public static boolean isEmpty(String string) {
        return !isNotEmpty(string);
    }

    public static boolean isNotEmpty(String string) {
        return string != null && string.length() > 0;
    }

    public static boolean isNotEmpty(String... strings) {
        if (strings != null) {
            for (String string : strings) {
                if (isEmpty(string)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
