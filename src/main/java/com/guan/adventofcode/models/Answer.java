package com.guan.adventofcode.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Answer {
    public String FirstAnswer;
    public String SecondAnswer;

    @Override
    public String toString() {
        return "First Answer: " + getFirstAnswer() + "\n Second Answer: " + getSecondAnswer();
    }
}
