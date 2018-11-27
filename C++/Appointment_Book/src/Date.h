/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Date.h
 * Author: user
 *
 * Created on November 3, 2018, 8:33 PM
 */

#ifndef SRC_DATE_H
#define SRC_DATE_H

class Date {
public:
    Date();
    Date(int, int, int);
    Date(const Date& orig);
    virtual ~Date();

    bool operator==(Date& o){
        return day == o.getDay() && month == o.getMonth() && year == o.getYear();
    }

    int operator-(Date& o){
    	int dayCountlocal = day + (month * 31) + (year * 365);
    	int dayCount = o.getDay() + (o.getMonth() * 31) + (o.getYear() * 365);
        return dayCount - dayCountlocal;
    }
    int operator+(Date& o){

    	return 0;
    }
    bool operator<=(Date& o){
    	return day <= o.getDay() || month <= o.getMonth() || year <= o.getYear();
    }
    bool operator>=(Date& o){
    	return day >= o.getDay() || month >= o.getMonth() || year >= o.getYear();
    }
    
    void setDay(int);
    void setMonth(int);
    void setYear(int);
    
    int getDay();
    int getMonth();
    int getYear();
    

    bool isValid();
private:
    int day;
    int month;
    int year;
};

#endif /* DATE_H */

