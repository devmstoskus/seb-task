package seb.task;

public class App {

    public static void main(String[] args) {
        try {
            Long seedA = Long.valueOf(args[0]);
            Long seedB = Long.valueOf(args[1]);
            Generator<Long> generatorA = new NumberGeneratorImpl(seedA, 16807L, 2147483647L);
            Generator<Long> generatorB = new NumberGeneratorImpl(seedB, 48271L, 2147483647L);
            NumberMatcher matcher = new NumberMatcherImpl(8);
            var matchCount = 0;
            for (int x = 0; x < 1_000_000; x++) {
                if (matcher.match(generatorA.generate(), generatorB.generate())) {
                    matchCount++;
                }
            }
            System.out.println("The number of times a comparison gave a positive result after 1'000'000 (1 million) comparisons.");
            System.out.println(String.format("With parameters %d and %d the result is %d.", seedA, seedB, matchCount));
        } catch (IndexOutOfBoundsException ex) {
            printAndExit("Invalid number of arguments supplied.");
        } catch (NumberFormatException ex) {
            printAndExit("Could not parse number.");
        }
    }

    private static void printAndExit(String msg) {
        System.err.println(msg);
        System.exit(1);
    }
}
