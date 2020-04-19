package com.kenji.wms.stock.utilis;

public class AgentUtilise {
    private final static String[] agent = { "X11", "Android", "iPhone", "iPod","iPad", "Windows Phone", "MQQBrowser", "SymbianOS" };
    public static boolean checkAgentIsMobile(String ua) {
        boolean flag = false;
        if (!ua.contains("Windows NT") || (ua.contains("Windows NT") && ua.contains("compatible; MSIE 9.0;"))) {
            if (!ua.contains("Windows NT") && !ua.contains("Macintosh")) {
                for (String item : agent) {
                    if (ua.contains(item)) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        return flag;
    }
}
