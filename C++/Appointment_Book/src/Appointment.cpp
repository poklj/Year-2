/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Appointment.cpp
 * Author: user
 * 
 * Created on November 3, 2018, 8:28 PM
 */

#include "Appointment.h"
#include "Time.h"


Appointment::Appointment() {
}

Appointment::Appointment(const Appointment& orig) {
}

Appointment::~Appointment() {
    delete this->date;
    delete this->time;
}


void Appointment::setDate(int day, int month, int year){
    if(nullptr != this->date){
        this->date->setDay(day);
        this->date->setMonth(month);
        this->date->setYear(year);
    } else {
        this->date = new Date(day, month, year);
    }
}
void Appointment::setDate(Date value){
    if(nullptr != this->date)
        delete this->date;
    this->date = &value;
}
void Appointment::setTime(int hour, int minute){
    if(this->time){
        this->time->setHour(hour);
        this->time->setMinute(minute);
    } else {
        this->time = new Time(hour, minute);
    }
}
void Appointment::setTime(Time value){
    if(nullptr != this->time)
        delete this->time;
    this->time = &value;
}
void Appointment::setLocation(std::string value){
    this->location = value;
}
void Appointment::setDescription(std::string value){
    this->description = value;
}

std::string Appointment::getType(){
    return this->type;
}
Date& Appointment::getDate(){
    return *this->date;
}
Time& Appointment::getTime(){
    return *this->time;
}
std::string Appointment::getDescription(){
    return this->description;
}
std::string Appointment::getLocation(){
    return this->location;
}


