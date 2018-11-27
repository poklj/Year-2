/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Time.cpp
 * Author: user
 * 
 * Created on November 3, 2018, 8:55 PM
 */

#include "Time.h"

Time::Time():
hour(0), minute(0){
}

Time::Time(int hour, int minute):
hour(hour), minute(minute){
}

Time::Time(const Time& orig): hour(orig.hour), minute(orig.minute) {
}

Time::~Time() {
}

void Time::setHour(int value){
    this->hour = value;
}
void Time::setMinute(int value){
    this->minute = value;
}

int Time::getHour(){
    return this->hour;
}
int Time::getMinute(){
    return this->minute;
}

bool isValid(){
    
}

