package de.konstantindiener.dsl.date;

import java.time.LocalDate;

public interface DateRangeBuilderCallback {
    void setDateRange(LocalDate from, LocalDate to);
}
