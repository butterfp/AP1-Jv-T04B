package domain.model;

import java.util.UUID;

public record User(UUID id, String login, String password) {
}
