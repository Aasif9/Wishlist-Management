package com.example.wishlist.management.Model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * DTO class representing employee data transferred between client and server.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    @NotEmpty
    private String name;
    @NotNull
    private Double price;
}