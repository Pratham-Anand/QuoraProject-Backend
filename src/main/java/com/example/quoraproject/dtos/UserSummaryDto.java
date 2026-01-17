package com.example.quoraproject.dtos;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSummaryDto {

    private UUID userId;
    private String name;

}
