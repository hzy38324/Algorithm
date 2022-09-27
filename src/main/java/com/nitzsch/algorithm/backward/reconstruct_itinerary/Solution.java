package com.nitzsch.algorithm.backward.reconstruct_itinerary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: nitzschhong
 * @create: 2022-09-26 22:08
 */
public class Solution {

    List<String> res = new ArrayList<>();
    private LinkedList<String> path = new LinkedList<>();
    int[] used;

    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        path.add("JFK");
        used = new int[tickets.size()];
        backward(tickets);
        return res;
    }

    private boolean backward(List<List<String>> tickets) {
        if (path.size() == tickets.size() + 1) {
            res = new LinkedList(path);
            return true;
        }
        for (int i = 0; i < tickets.size(); i++) {
            if (used[i] == 1) {
                continue;
            }
            List<String> ticket = tickets.get(i);
            if (ticket.get(0).equals(path.get(path.size() - 1))) {
                path.add(ticket.get(1));
                used[i] = 1;
                if (backward(tickets)) {
                    return true;
                }
                used[i] = 0;
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList(new String[]{"JFK", "KUL"}));
        tickets.add(Arrays.asList(new String[]{"JFK", "NRT"}));
        tickets.add(Arrays.asList(new String[]{"NRT", "JFK"}));
        List<String> itinerary = new Solution().findItinerary(tickets);
        System.out.println(itinerary);
    }
}
