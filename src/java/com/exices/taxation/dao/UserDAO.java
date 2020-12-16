/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exices.taxation.dao;

import com.exices.taxation.models.UserModel;

/**
 *
 * @author Roshan
 */
public interface UserDAO {
    public UserModel getUserByLoginCredentials(String userName,String password);
}
