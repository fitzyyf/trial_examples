/*
 * Copyright (c) 2012-2013 www.iflytek.com. All Rights Reserved.
 * This software for customer relationship management system, developed by yi-Ware team.
 * Software code and design for the team, copy rights reserved.
 */

package osy;

import java.nio.CharBuffer;

/**
 * <p>
 * .
 * </p>
 *
 * @author poplar.yfyang
 * @version 1.0 2013-02-26 10:01 PM
 * @since JDK 1.5
 */
public class BufferFillDrain {

    private static int      index   = 0;
    private static String[] strings = {
            "A random string value",
            "The product of an infinite number of monkeys",
            "Hey hey we're the Monkees",
            "Opening act for the Monkees: Jimi Hendrix",
            "'Scuse me while I kiss this fly", // Sorry Jimi ;-)
            "Help Me! Help Me!",
    };

    public static void main(String[] args) {
        // 分配新的缓冲
        CharBuffer buffer = CharBuffer.allocate(100);
        while (fillBuffer(buffer)) {
            buffer.flip();
            drainBuffer(buffer);
            buffer.clear();
        }
    }

    private static void drainBuffer(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
        System.out.println("");
    }

    private static boolean fillBuffer(CharBuffer buffer) {
        if (index >= strings.length) {
            return false;
        }
        String str = strings[index];
        for (int i = 0; i < str.length(); i++) {
            buffer.put(str.charAt(i));
        }
        return true;
    }
}
