package top.codermhc.common.mvc.converter.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yemh
 */
@Component
public class DateConverter implements Converter<String, Date> {
    private static final Logger logger = LoggerFactory.getLogger(DateConverter.class);
    private static final List<String> FORMATS = new ArrayList<>(4);
    static {
        FORMATS.add("yyyy-MM");
        FORMATS.add("yyyy-MM-dd");
        FORMATS.add("yyyy-MM-dd HH:mm");
        FORMATS.add("yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public Date convert(String source) {
        String value = source.trim();
        if (value.isEmpty()) {
            return null;
        } else if (source.matches("^\\d{4}-\\d{1,2}$")) {
            return this.parseDate(source, FORMATS.get(0));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
            return this.parseDate(source, FORMATS.get(1));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}$")) {
            return this.parseDate(source, FORMATS.get(2));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
            return this.parseDate(source, FORMATS.get(3));
        } else if (source.matches("^\\d+$")) {
            return new Date(Long.parseLong(source));
        } else {
            throw new IllegalArgumentException("Invalid value '" + source + "'");
        }
    }

    public Date parseDate(String dateStr, String format) {
        Date date = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            logger.error("parseDate failed, value={}, format={}", dateStr, format);
        }
        return date;
    }

}
