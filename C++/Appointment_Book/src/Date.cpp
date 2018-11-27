/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Date.cpp
 * Author: user
 * 
 * Created on November 3, 2018, 8:33 PM
 */

#include "Date.h"

Date::Date():
day(0), month(0), year(0){ 
}

Date::Date(int day, int month, int year):
day(day), month(month), year(year){
}
Date::Date(const Date& orig):
	day(orig.day), month(orig.month), year(orig.year){

}

Date::~Date() {
}
/**
 * Check if this date is valid
 * @return valid
 */

void Date::setDay(int value){
    this->day = value;
}
void Date::setMonth(int value){
    this->month = value;
}
void Date::setYear(int value){
    this->year = value;
}

int Date::getDay(){
    return this->day;
}
int Date::getMonth(){
    return this->month;
}
int Date::getYear(){
    return this->year;
}

bool Date::isValid(){
    int MAXDAY = 31;
    int MAXMONTH = 12;
    int EMPTY = 0;
    
    bool valid = true;
    
    if(this->getDay() <= EMPTY || this->getDay() > MAXDAY){
        valid = false;
    }
    if(this->getMonth() <= EMPTY || this->getMonth() > MAXMONTH){
        valid = false;
    }
    
    return valid;
}
