package datasource.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "game_sessions")
public class GameEntity {

    @Id
    private UUID id;

    private String board;

    public GameEntity() {}

    public GameEntity(UUID id, String board) {
        this.id = id;
        this.board = board;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }
}