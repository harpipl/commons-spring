package pl.harpi.commons.spring.base.types;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.util.StringUtils;
import pl.harpi.commons.base.exceptions.ApplicationException;
import pl.harpi.commons.base.types.ExceptionDto;

import java.io.Serializable;
import java.util.Locale;

public class ExceptionMapper {
    private MessageSource messageSource;

    public ExceptionMapper(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public ExceptionDto map(ApplicationException ex, Locale locale) {
        String exceptionClassName = ex.getClass().getSimpleName();
        String description;
        try {
            description = messageSource.getMessage(exceptionClassName, null, locale);

            int i = 0;
            for (Serializable a : ex.getArgs()) {
                description = StringUtils.replace(description, "%" + ++i, a.toString());
            }

        } catch (NoSuchMessageException e) {
            description = exceptionClassName;
        }
        return new ExceptionDto(description);
    }
}
