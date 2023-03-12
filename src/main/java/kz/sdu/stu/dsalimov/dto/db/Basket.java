package kz.sdu.stu.dsalimov.dto.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import kz.sdu.stu.dsalimov.util.Json;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Json
public class Basket {

    @Id
    @Column(name = "uuid", nullable = false, unique = true)
    private String uuid;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "dish_uuid", nullable = false, unique = true)
    private String dishUuid;

    @Column(name = "order_uuid", nullable = false, unique = true)
    private String orderUuid;

}
