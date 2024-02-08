package mx.com.interware.ssync.common.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Utility class used for date conversion.
 * 
 * @author Interware
 *
 */
@Component
@Slf4j
public class DateUtil {

    /**
     * Default date format.
     */
    public static final String YMD_FORMAT = "yyyy-MM-dd";

    /**
     * Parses date string in "yyyy-MM-dd" format.
     * 
     * @param dateStr date string
     * @return object of type LocalDate
     */
    public LocalDate parseFecha(final String dateStr) {
        LocalDate date = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YMD_FORMAT);
            date = LocalDate.parse(dateStr, formatter);
        } catch (Exception e) {
            log.warn("Date could not be converted.", e);
        }

        return date;
    }

}
