/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Time.h
 * Author: user
 *
 * Created on November 3, 2018, 8:55 PM
 */

#ifndef SRC_TIME_H
#define SRC_TIME_H

/**
 * Use 24 hour time.
 */
class Time {
public:
    Time();
    Time(int, int);
    Time(const Time& orig);
    virtual ~Time();
    
    void setHour(int);
    void setMinute(int);
    
    int getHour();
    int getMinute();
    
    bool isValid();
private:
    int hour;
    int minute;
};

#endif /* TIME_H */

