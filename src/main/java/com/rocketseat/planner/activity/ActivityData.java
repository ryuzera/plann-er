package com.rocketseat.planner.activity;

import com.rocketseat.planner.trip.Trip;

import java.time.LocalDateTime;
import java.util.UUID;

public record ActivityData (UUID id, String title, LocalDateTime occurs_at, Trip trip) {
}
