package me.yu.domain;

import lombok.Data;

@Data
public class Transfer {
    private Integer id;
    private Integer f_uid;
    private Integer t_uid;
    private Double money;
}
