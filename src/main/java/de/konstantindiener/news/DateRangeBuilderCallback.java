package de.konstantindiener.news;

import java.time.LocalDate;

public interface DateRangeBuilderCallback {
    void setDateRange(LocalDate from, LocalDate to);
}
