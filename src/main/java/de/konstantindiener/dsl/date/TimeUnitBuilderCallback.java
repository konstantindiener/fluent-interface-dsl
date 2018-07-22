package de.konstantindiener.dsl.date;

import java.time.temporal.TemporalUnit;

public interface TimeUnitBuilderCallback {

    void setTemporalUnit(TemporalUnit temporalUnit);
}
