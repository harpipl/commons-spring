package pl.harpi.commons.spring.base.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MultiExceptionDto {
    private List<ExceptionDto> messages = new ArrayList<>();
}
