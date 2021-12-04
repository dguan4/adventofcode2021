package com.guan.adventofcode.days.day1;

import com.guan.adventofcode.days.DefaultApplicationTmpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Component("day1Application")
public class Day1Application implements DefaultApplicationTmpl {

    private List<Integer> stringSplit;
    private int slidingWindowRange = 3;

    @Override
    public String GetAnswer(String input) {
        BigInteger count = BigInteger.ZERO;

        stringSplit = Arrays.stream(input.split("\n"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < stringSplit.size(); i++) {
            if (i > 0) {
                int prevIdx = i - 1;
                if (stringSplit.get(prevIdx) < stringSplit.get(i)) {
                    count = count.add(BigInteger.ONE);
                }
            }
        }

        return count.toString();
    }

    @Override
    public String GetAnswer2(String input) {
        BigInteger count = BigInteger.ZERO;

        stringSplit = Arrays.stream(input.split("\n"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < stringSplit.size(); i++) {
            if (checkIfIncreased(i,i+3)) {
                count = count.add(BigInteger.ONE);
            }
        }

        return count.toString();
    }

    private boolean checkIfIncreased(int start, int end) {
        if (start >= 0 && end < stringSplit.size()) {
            if (stringSplit.get(end) > stringSplit.get(start)) {
                return true;
            }
        }
        return false;
    }
}
