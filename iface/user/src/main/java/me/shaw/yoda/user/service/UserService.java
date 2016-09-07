package me.shaw.yoda.user.service;

import me.shaw.yoda.common.exception.ServiceException;
import me.shaw.yoda.user.dto.UserDto;

/**
 * Created by yes on 7/5/16.
 */
public interface UserService {
    /**
     * Get info by user id
     */
    UserDto getUserInfoById(String id) throws ServiceException;

    /**
     * test transaction propagate
     */
    void testTransaction() throws ServiceException;

    /**
     * test wrapper
     */
    void twoInsertAndThrowWrapper();

    /**
     *
     */
    void twoInsertAndThrow();

    void testNotSupport() throws ServiceException;

    void notSupportedMethod() throws ServiceException;

    String getById(Long id) throws ServiceException;
}
