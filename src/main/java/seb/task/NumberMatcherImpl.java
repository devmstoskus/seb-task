package seb.task;

public class NumberMatcherImpl implements NumberMatcher {
    private int numOfLastChars;

    public NumberMatcherImpl(int numOfLastChars) {
        this.numOfLastChars = numOfLastChars;
    }

    @Override
    public boolean match(Long first, Long second) {
        return nLastChars(mapToBinary(first), numOfLastChars).equals(nLastChars(mapToBinary(second), numOfLastChars));
    }

    private String mapToBinary(Long value) {
        return String.format("%" + Long.SIZE + "s", Long.toBinaryString(value)).replace(' ', '0');
    }

    private String nLastChars(String text, int n) {
        return text.substring(Math.max(0, text.length() - n));
    }
}
