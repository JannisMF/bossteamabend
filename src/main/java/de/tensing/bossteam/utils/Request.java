package de.tensing.bossteam.utils;

import javax.servlet.http.HttpServletRequest;

public class Request {
    public static String getServerUrl(HttpServletRequest request) {
        String protocol;
        if (request.getScheme() == "https") {
            protocol = "https";
        } else {
            protocol = "http";
        }
        String serverUrl = protocol + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
        System.out.println(serverUrl);
        return serverUrl;
    }
}
