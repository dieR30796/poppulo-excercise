package com.example.poppulo.lottery.ticket;

import com.example.poppulo.lottery.line.Line;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue
    private Long ticketId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Line> lineList;

    private boolean ticketChecked;

    public Ticket(List<Line> randomlyGeneratedLines) {
        this.lineList = randomlyGeneratedLines;
    }
}
