/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exicise.taxation.actions;

import com.exices.taxation.dao.UserDAO;
import com.exices.taxation.daoImpl.UserDAOImpl;
import com.exices.taxation.models.UserModel;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roshan
 */
public class LoginAction extends ActionSupport{
 
    private String name;
    private String password;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("In password fielddddd");
        UserDAO clienteDAO = new UserDAOImpl();
        System.out.println("Hello I am in");
        UserModel user = clienteDAO.getUserByLoginCredentials(name, password);
        System.out.println(user);
        if (user != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
        
    }
    public String userLogin(){
        System.out.println("In password fielddddd");
        UserDAO userDAO = new UserDAOImpl();
        System.out.println("Hello I am in");
        UserModel user = userDAO.getUserByLoginCredentials(name, password);
        System.out.println(user);
        return SUCCESS;   
    }
}
