package by.epam.exercise02.service;

import by.epam.exercise02.domain.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListValidator {
    public boolean isLineValid(String line) {
        if (line == null) {
            return false;
        }
        String regex = Constants.REGEX;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }
}
