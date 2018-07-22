package de.konstantindiener.dsl.date;

import java.time.temporal.ChronoUnit;

public class TimeUnitBuilder<T> {

    private final T parentBuilder;

    private final TimeUnitBuilderCallback callback;

    TimeUnitBuilder(T parentBuilder, TimeUnitBuilderCallback callback) {
        this.parentBuilder = parentBuilder;
        this.callback = callback;
    }

    public T days() {
        callback.setTemporalUnit(ChronoUnit.DAYS);
        return parentBuilder;
    }

    public T weeks() {
        callback.setTemporalUnit(ChronoUnit.WEEKS);
        return parentBuilder;
    }

    public T months() {
        callback.setTemporalUnit(ChronoUnit.MONTHS);
        return parentBuilder;
    }
}
