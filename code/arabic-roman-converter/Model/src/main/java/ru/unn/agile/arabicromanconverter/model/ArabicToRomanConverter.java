package ru.unn.agile.arabicromanconverter.model;

public class ArabicToRomanConverter implements Converter {

    private static final int[] ARABIC_NUMERALS = {1000, 900, 500, 400,
            100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD",
            "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int MIN_ARABIC_VALUE = 1;
    private static final int MAX_ARABIC_VALUE = 3999;

    public ArabicToRomanConverter() {
    }

    public boolean validate(final String number) {
        return number.matches("-?\\d+(\\.\\d+)?")
                && Integer.parseInt(number) <= MAX_ARABIC_VALUE
                && Integer.parseInt(number) >= MIN_ARABIC_VALUE;
    }

    @Override
    public String convertValue(final String number) {
        return convert(Integer.parseInt(number));
    }

    public String convert(final Integer arabicNumber) {
        if (arabicNumber < MIN_ARABIC_VALUE || arabicNumber > MAX_ARABIC_VALUE) {
            throw new IllegalArgumentException("Roman Number"
                    + "doesn't exist for Arabic" + arabicNumber);
        }
        StringBuilder romanNumber = new StringBuilder();
        int arabic = arabicNumber;
        for (int i = 0; i < ARABIC_NUMERALS.length; i++) {
            while (arabic >= ARABIC_NUMERALS[i]) {
                romanNumber.append(ROMAN_NUMERALS[i]);
                arabic -= ARABIC_NUMERALS[i];
            }
        }
        return romanNumber.toString();
    }
}
