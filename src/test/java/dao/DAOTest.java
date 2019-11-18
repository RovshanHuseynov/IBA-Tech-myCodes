package dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DAOTest {

    DAOPersonHashMap phm;

    @After
    public void after(){
        System.out.println("finish");
    }

    @Before
    public void before(){
        phm = new DAOPersonHashMap();
    }

    @Test
    public void put() {
    }

    @Test
    public void get() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void getAll() {
    }
}