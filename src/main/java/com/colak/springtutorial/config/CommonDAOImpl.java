package com.colak.springtutorial.config;

import org.springframework.stereotype.Component;


@Component("commonDAOImpl")
public class CommonDAOImpl implements ICommonDAO {

    @Override
    public void save() {
        System.out.println("save operator...");
    }
}
