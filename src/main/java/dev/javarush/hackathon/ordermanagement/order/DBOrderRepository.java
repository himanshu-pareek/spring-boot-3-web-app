package dev.javarush.hackathon.ordermanagement.order;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

@Repository
public class DBOrderRepository {
    private final JdbcClient jdbcClient;

    public DBOrderRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Order> findAll() {
        return jdbcClient.sql("SELECT * FROM orders")
                .query((rs, rowNum) -> new Order(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTimestamp("placed_time").toLocalDateTime(),
                        rs.getInt("total_amount"),
                        OrderStatus.valueOf(rs.getString("status"))
                ))
                .list();
    }

    public Order insert(Order order) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql("INSERT INTO orders(name, placed_time, total_amount, status) VALUES (:name, :placed_time, :total_amount, :status)")
                .params(Map.of(
                        "name", order.getName(),
                        "placed_time", order.getPlacedTime(),
                        "total_amount", order.getTotalAmount(),
                        "status", order.getStatus().toString()
                ))
                .update(keyHolder);

        order.setId(Integer.parseInt(keyHolder.getKey().toString()));
        return order;
    }

    public Optional<Order> findById(Integer id) {
        return jdbcClient.sql("SELECT * FROM orders WHERE id = :id")
                .params(Map.of("id", id))
                .query((rs, rowNum) -> new Order(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTimestamp("placed_time").toLocalDateTime(),
                        rs.getInt("total_amount"),
                        OrderStatus.valueOf(rs.getString("status"))
                ))
                .optional();
    }

    public Optional<Order> update(Integer id, Order order) {
        int updateCount = jdbcClient.sql("UPDATE orders SET name = :name, placed_time = :placed_time, total_amount = :total_amount, status = :status WHERE id = :id")
                .params(Map.of(
                        "id", id,
                        "name", order.getName(),
                        "placed_time", order.getPlacedTime(),
                        "total_amount", order.getTotalAmount(),
                        "status", order.getStatus().toString()
                ))
                .update();
        if (updateCount == 0) {
            return Optional.empty();
        }
        order.setId(id);
        return Optional.of(order);
    }

    public void deleteById(Integer id) {
        jdbcClient.sql("DELETE FROM orders WHERE id = :id")
                .params(Map.of("id", id))
                .update();
    }

    public void saveAll (Iterable<Order> orders) {
        orders.forEach(this::insert);
    }

    public long count() {
        return (Long) jdbcClient.sql("SELECT COUNT(*) FROM orders")
                .query()
                .singleValue();
    }
}
