package com.phlink.bus.api.route.domain.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class StopAttendanceDownVO {
    @NotNull(message = "{required}")
    private Long studentId;
    @NotNull(message = "{required}")
    private Long tripId;
}
