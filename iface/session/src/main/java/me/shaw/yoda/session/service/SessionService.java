package me.shaw.yoda.session.service;

import me.shaw.yoda.session.dto.Session;

/**
 * Created by yes on 17/6/16.
 */
public interface SessionService {
    Session getSessionInfo(String token);

    String createSession();

    Session updateSession();

    String removeSession(String token);
}
