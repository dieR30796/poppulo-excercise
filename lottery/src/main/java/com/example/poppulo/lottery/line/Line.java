package com.example.poppulo.lottery.line;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int lineValueOne;

    private int lineValueTwo;

    private int lineValueThree;

    private int result;

    Line(int lineValueOne, int lineValueTwo, int lineValueThree) {
        this.setLineValueOne(lineValueOne);
        this.setLineValueTwo(lineValueTwo);
        this.setLineValueThree(lineValueThree);
        this.setResult(getLineResult());
    }

    private int getLineResult() {
        int value = this.lineValueOne + this.lineValueTwo + this.lineValueThree;

        if (value == 2) {
            return 10;
        } else if (this.lineValueOne == this.lineValueTwo && this.lineValueOne == this.lineValueThree) {
            return 5;
        } else if (this.lineValueOne != this.lineValueTwo && this.lineValueOne != this.lineValueThree) {
            return 1;
        } else {
            return 0;
        }
    }
}
