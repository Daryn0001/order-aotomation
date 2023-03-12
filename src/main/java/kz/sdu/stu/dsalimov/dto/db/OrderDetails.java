package kz.sdu.stu.dsalimov.dto.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kz.sdu.stu.dsalimov.util.Json;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Json
@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @Column(name = "uuid", nullable = false, unique = true)
    private String uuid;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "booking_uuid", nullable = false)
    private String bookingUuid;

    @Column(name = "table_uuid", nullable = false)
    private String tableUuid;

    @Column(name = "price", nullable = false)
    private int price;

}
