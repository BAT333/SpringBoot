package com.rafael.demo.APIWeb.user.model;

import jakarta.validation.constraints.NotNull;

public record DataUser(
        @NotNull
        String login,
        @NotNull
        String password


) {
}
