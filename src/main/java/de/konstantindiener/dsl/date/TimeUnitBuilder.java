package de.konstantindiener.dsl.date;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class TimeUnitBuilder<T> {

    public interface Callback {
        void setTemporalUnit(TemporalUnit temporalUnit);
    }

    private final T parentBuilder;

    private final Callback callback;

    TimeUnitBuilder(T parentBuilder, Callback callback) {
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
