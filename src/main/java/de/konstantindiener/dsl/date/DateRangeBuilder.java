package de.konstantindiener.dsl.date;

import java.time.LocalDate;
import java.time.temporal.TemporalUnit;

public class DateRangeBuilder<T> {

    public interface Callback {
        void setDateRange(LocalDate from, LocalDate to);
    }

    private final LocalDate from;

    private final T parentBuilder;

    private final Callback callback;

    public DateRangeBuilder(LocalDate from, T parentBuilder, Callback callback) {
        this.from = from;
        this.parentBuilder = parentBuilder;
        this.callback = callback;
    }

    public T to(LocalDate to) {
        this.callback.setDateRange(this.from, to);
        return this.parentBuilder;
    }

    public TimeUnitBuilder<T> lasting(int numberOfTimeUnits) {
        return new TimeUnitBuilder<>(
                parentBuilder,
                ((TemporalUnit tu) -> this.callback.setDateRange(from, from.plus(numberOfTimeUnits, tu))));
    }
}