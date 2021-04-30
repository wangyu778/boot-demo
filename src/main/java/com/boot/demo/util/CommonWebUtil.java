package com.boot.demo.util;

import javax.servlet.ServletRequest;
import java.util.Date;

/**
 * @author Bl
 */
public class CommonWebUtil {

    public static void setAccessStartTime(ServletRequest request, Date startTime) {
        request.setAttribute("access_start_time", startTime);
    }

}
