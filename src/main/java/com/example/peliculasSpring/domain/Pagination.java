 package com.example.peliculasSpring.domain;

import java.io.Serializable;

public class Pagination implements Serializable{
    private int  page;
    private int  size;
    private String sort;
    public int getPage;


    public int  getPage(){
        return page;
    }
    
    public void setPage(int  page){
        this.page = page;
    
    }
    
    public int  getSize(){
        return size ;
    }
    
    public void setSize(int  size){
    this.size = size;
        
    }
    
    public String getSort(){
        return sort;
    }
    
    public void setSort(String sort){
        this.sort = sort;
    }

    

    }
    