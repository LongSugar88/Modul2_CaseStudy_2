package SourceProductInformation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vallidate_ProductInformation {
    Pattern pattern;
    Matcher matcher;
    final String REGEX = "[,]{1}[0-9.][,]{1}[]";
}
