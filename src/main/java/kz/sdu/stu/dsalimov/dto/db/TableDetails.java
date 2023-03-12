package kz.sdu.stu.dsalimov.dto.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "table_details")
public class TableDetails {

    @Id
    @Column(name = "uuid", nullable = false, unique = true)
    private String uuid;

    @Column(name = "floor", nullable = false)
    private int floor;

    @Column(name = "internal_id", nullable = false)
    private String internalId;

    @Column(name = "temporary_key", nullable = false)
    private String temporaryKey;

    @Override
    public String toString() {
        return "TableDetails{" +
                "uuid='" + uuid + '\'' +
                ", floor=" + floor +
                ", internalId='" + internalId + '\'' +
                ", temporaryKey='" + temporaryKey + '\'' +
                '}';
    }

}
