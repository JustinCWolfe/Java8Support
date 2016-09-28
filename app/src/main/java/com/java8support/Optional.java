package com.java8support;

import java.util.NoSuchElementException;

public class Optional<T>
{
    private static final Optional<?> EMPTY = new Optional<>();

    private final T value;

    private Optional()
    {
        this.value = null;
    }

    private Optional(T value) throws NullPointerException
    {
        if (value == null) {
            throw new NullPointerException();
        }
        this.value = value;
    }

    @SuppressWarnings("unchecked")
    public static <T> Optional<T> empty()
    {
        return (Optional<T>) EMPTY;
    }

    public static <T> Optional<T> of(T value) throws NullPointerException
    {
        return new Optional<>(value);
    }

    @SuppressWarnings("unchecked")
    public static <T> Optional<T> ofNullable(T value)
    {
        return value == null ? (Optional<T>) EMPTY : of(value);
    }

    public T get()
    {
        if (value == null) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }

    public T orElse(T other)
    {
        return value != null ? value : other;
    }

    public boolean isPresent()
    {
        return value != null;
    }
}

