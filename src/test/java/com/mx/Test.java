package com.mx;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by mx on 2019/3/5.
 */
public class Test {
    @org.junit.Test
    public void testDate() throws ParseException {
        List<Integer> lsit = new ArrayList<>();
        lsit.add(111);
        lsit.add(111);
        lsit.add(111);
        lsit.add(111);
        System.out.println(lsit);
        lsit.clear();
        if (lsit.size() == 0)
            System.out.println("null");
    }
}
