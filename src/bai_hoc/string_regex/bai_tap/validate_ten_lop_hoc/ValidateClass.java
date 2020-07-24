package bai_hoc.string_regex.bai_tap.validate_ten_lop_hoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {
    private static final String CLASS_REGEX = "^[C|A|P]+\\d{4}+[G|H|I|K|L|M]$";

    public boolean validate(String regex){
        Pattern pattern=Pattern.compile(CLASS_REGEX);
        Matcher matcher=pattern.matcher(regex);
        return matcher.matches();
    }
}

