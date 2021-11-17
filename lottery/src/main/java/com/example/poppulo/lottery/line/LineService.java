package com.example.poppulo.lottery.line;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class LineService {
    public List<Line> generateLines(Long numberOfLines) {
        List <Line> lineList = new ArrayList<>();

        for (int i = 0; i < numberOfLines; i++) {
            lineList.add(new Line(generateRandomNumber(), generateRandomNumber(), generateRandomNumber()));
        }

        return lineList;
    }

    private int generateRandomNumber() {
        Random random = new Random();

        return random.nextInt(3);
    }
}
