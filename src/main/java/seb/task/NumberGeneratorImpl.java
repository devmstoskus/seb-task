package seb.task;

public class NumberGeneratorImpl implements NamedGenerator<Long> {
    private static final Long DIVISOR = 2147483647L;
    private Long seed;
    private Long factor;
    private String name;

    public NumberGeneratorImpl(Long seed, Long factor, String name) {
        this.seed = seed;
        this.factor = factor;
        this.name = name;
    }

    @Override
    public Long generate() {
        this.seed = this.seed * this.factor % DIVISOR;
        return this.seed;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
