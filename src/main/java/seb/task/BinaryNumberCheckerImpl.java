package seb.task;

public class BinaryNumberCheckerImpl implements NumberChecker {
    private NamedGenerator<Long> generatorA;
    private NamedGenerator<Long> generatorB;

    public BinaryNumberCheckerImpl(NamedGenerator<Long> generatorA, NamedGenerator<Long> generatorB) {
        this.generatorA = generatorA;
        this.generatorB = generatorB;
    }

    @Override
    public boolean isMatch() {
        return nLastChars(mapToBinary(generatorA.generate()), 8).equals(nLastChars(mapToBinary(generatorB.generate()), 8));
    }

    private String mapToBinary(Long value) {
        return String.format("%" + Long.SIZE + "s", Long.toBinaryString(value)).replace(' ', '0');
    }

    private String nLastChars(String text, int n) {
        return text.substring(Math.max(0, text.length() - n));
    }
}
