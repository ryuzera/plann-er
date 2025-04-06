package com.rocketseat.planner.link;

import com.rocketseat.planner.trip.Trip;

import java.util.UUID;

public record LinkData(UUID linkId, String title, String url) {
}
