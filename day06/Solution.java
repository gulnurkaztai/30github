package day06;

import java.util.List;

public class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int row = 0;
        int col = 0;
        for (int i =0; i < commands.size(); i++){
        switch(commands.get(i)){
            case "UP":
                row--;
                break;
            case "RIGHT":
                col++;
                break;
            case "DOWN":
                row++;
                break;
            case "LEFT":
                col--;
                break;
        }
    }
    return (row * n) + col;
    }
} {
    
}
