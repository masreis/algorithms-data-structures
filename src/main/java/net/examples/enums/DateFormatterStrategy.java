package net.examples.enums;

import java.util.Date;

public enum DateFormatterStrategy {
    BRAZIL {
        @Override
        public String doFormat(DateFormatterImpl formatter, Date date) {
            return formatter.formatBrasil(date);
        }
    },
    BELGIUM {
        @Override
        public String doFormat(DateFormatterImpl formatter, Date date) {
            return formatter.formatBelgium(date);
        }
    },
    US {
        @Override
        public String doFormat(DateFormatterImpl formatter, Date date) {
            return formatter.formatUS(date);
        }
    };

    public abstract String doFormat(DateFormatterImpl formatter, Date date);

}
