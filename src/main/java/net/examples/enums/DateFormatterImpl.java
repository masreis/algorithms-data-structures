package net.examples.enums;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatterImpl {

    private SimpleDateFormat sdfBrasil = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdfBelgium = new SimpleDateFormat("dd.MM.yyyy");
    private SimpleDateFormat sdfUS = new SimpleDateFormat("MM/dd/yyyy");

    public String formatBrasil(Date date) {
        return this.sdfBrasil.format(date);
    }

    public String formatBelgium(Date date) {
        return this.sdfBelgium.format(date);
    }

    public String formatUS(Date date) {
        return this.sdfUS.format(date);
    }

}
