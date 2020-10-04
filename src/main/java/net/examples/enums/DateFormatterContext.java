package net.examples.enums;

import java.util.Date;

public class DateFormatterContext {

    private DateFormatterStrategy strategy;
    private DateFormatterImpl formatter = new DateFormatterImpl();

    public DateFormatterContext(DateFormatterStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(DateFormatterStrategy strategy) {
        this.strategy = strategy;
    }

    public String format(Date date) {
        return this.strategy.doFormat(formatter, date);
    }

}
