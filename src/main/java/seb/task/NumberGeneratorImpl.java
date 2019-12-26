package seb.task;

public class NumberGeneratorImpl implements Generator<Long> {
    private Long seed;
    private Long factor;
    private Long divisor;

    public NumberGeneratorImpl(Long seed, Long factor, Long divisor) {
        this.seed = seed;
        this.factor = factor;
        this.divisor = divisor;
    }

    @Override
    public Long generate() {
        this.seed = this.seed * this.factor % divisor;
        return this.seed;
    }
}
