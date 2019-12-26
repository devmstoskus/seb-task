package seb.task;

public class NumberGeneratorImpl implements Generator<Long> {
    private static final Long DIVISOR = 2147483647L;
    private Long seed;
    private Long factor;

    public NumberGeneratorImpl(Long seed, Long factor) {
        this.seed = seed;
        this.factor = factor;
    }

    @Override
    public Long generate() {
        this.seed = this.seed * this.factor % DIVISOR;
        return this.seed;
    }

}
