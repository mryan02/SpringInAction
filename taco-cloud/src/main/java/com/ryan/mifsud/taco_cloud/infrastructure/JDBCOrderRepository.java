package com.ryan.mifsud.taco_cloud.infrastructure;

import java.util.List;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.ryan.mifsud.taco_cloud.domain.DTO.Ingredient;
import com.ryan.mifsud.taco_cloud.domain.DTO.Taco;
import com.ryan.mifsud.taco_cloud.domain.DTO.TacoOrder;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JDBCOrderRepository implements OrderRepository {

    private final JdbcTemplate jdbcTemplate;
    private final JdbcOperations jdbcOperations;

    @Override
    public TacoOrder save(TacoOrder order) {
        PreparedStatementCreatorFactory preparedStatementCreatorFactory = new PreparedStatementCreatorFactory(
                "INSERT INTO TACO_ORDER (delivery_name, delivery_street, delivery_city, delivery_state, delivery_zip, cc_number, cc_expiration, cc_cvv, placed_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, 
                java.sql.Types.VARCHAR,java.sql.Types.VARCHAR, java.sql.Types.VARCHAR,
                java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.TIMESTAMP);

        preparedStatementCreatorFactory.setReturnGeneratedKeys(true);
        order.setPlacedAt(new java.util.Date());

        final PreparedStatementCreator psc = preparedStatementCreatorFactory.newPreparedStatementCreator(new Object[]{
                order.getDeliveryName(),
                order.getDeliveryStreet(),
                order.getDeliveryCity(),
                order.getDeliveryState(),
                order.getDeliveryZip(),
                order.getCcNumber(),
                order.getCcExpiration(),
                order.getCcCVV(),
                new java.sql.Timestamp(order.getPlacedAt().getTime())
        });

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long orderId = keyHolder.getKey().longValue();
        order.setId(orderId);

        int key = 0;
        List<Taco> tacos = order.getTacos();
        for (Taco taco : tacos) {
            saveTaco(taco, key++, orderId);
        }

        return null;
    }

    private long saveTaco(Taco taco, long orderKey, long orderId) {
        PreparedStatementCreatorFactory preparedStatementCreatorFactory = new PreparedStatementCreatorFactory(
                "INSERT INTO TACO (name,order_id, sequence, created_at) VALUES (?, ?, ?, ?)",
                java.sql.Types.VARCHAR, java.sql.Types.BIGINT, java.sql.Types.BIGINT, java.sql.Types.TIMESTAMP);

        preparedStatementCreatorFactory.setReturnGeneratedKeys(true);
        taco.setCreatedAt(new java.util.Date());

        final PreparedStatementCreator psc = preparedStatementCreatorFactory.newPreparedStatementCreator(new Object[]{
                taco.getName(),
                orderId,
                orderKey,
                new java.sql.Timestamp(taco.getCreatedAt().getTime()),
        });

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long tacoId = keyHolder.getKey().longValue();
        taco.setId(tacoId);
        saveTacoIngredient(taco.getIngredients(), tacoId);
        return tacoId;
    }

    private long saveTacoIngredient(List<Ingredient> ingredients, long tacoId) {
        int key = 0;

        for (Ingredient ingredient : ingredients) {
            jdbcTemplate.update("INSERT INTO TACO_INGREDIENT (taco_id, ingredient_id, sequence) VALUES (?, ?, ?)",
                    tacoId, ingredient.getId(), key++);
        }
        return tacoId;
    }

}
