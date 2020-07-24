package bai_hoc.string_regex.bai_tap.validate_so_dien_thoai;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelephoneNumber {
    private static final String TELEPHONE_REGEX="^\\(\\d{2}+\\)-\\(0[1-9]\\d{8}\\)$";
    public boolean validate(String regex){
        Pattern pattern=Pattern.compile(TELEPHONE_REGEX);
        Matcher matcher=pattern.matcher(regex);
        return matcher.matches();
    }
}
