package datasource.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import datasource.model.GameEntity;
import domain.model.GameBoard;
import domain.model.GameSession;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {

    // Встроенный инструмент Спринга для работы с JSON
    private final ObjectMapper objectMapper = new ObjectMapper();

    // Переводим из бизнес-модели (domain) в сущность базы данных (entity)
    public GameEntity toEntity(GameSession domain) {
        try {
            // Превращаем двумерный массив int[][] в JSON-строку
            String boardJson = objectMapper.writeValueAsString(domain.board().board());
            return new GameEntity(domain.id(), boardJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Ошибка при конвертации доски в JSON", e);
        }
    }

    // Переводим из сущности базы данных (entity) обратно в бизнес-модель (domain)
    public GameSession toDomain(GameEntity entity) {
        try {
            // Превращаем JSON-строку обратно в двумерный массив int[][]
            int[][] boardArray = objectMapper.readValue(entity.getBoard(), int[][].class);
            return new GameSession(entity.id(), new GameBoard(boardArray));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Ошибка при чтении доски из JSON", e);
        }
    }
}