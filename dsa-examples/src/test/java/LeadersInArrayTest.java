package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LeadersInArrayTest {

    @Test
    void findLeaders() {
        int[] arr1 = {4, 7, 1, 0};
        ArrayList<Integer> leadersList = new ArrayList<>();
        leadersList.add(0);
        leadersList.add(1);
        leadersList.add(7);
        assertEquals(leadersList, LeadersInArray.findLeaders(arr1));
    }
}