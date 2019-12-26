package seb.task;

public interface NamedGenerator<T> extends Generator<T> {
    String getName();
}
