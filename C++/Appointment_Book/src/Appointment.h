/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Appointment.h
 * Author: user
 *
 * Created on November 3, 2018, 8:28 PM
 */

#ifndef APPOINTMENT_H
#define APPOINTMENT_H

#include "Date.h"
#include "Time.h"
#include <string>
#include <FactoryC++11.h>
#include "CODEOPT.h"
class Appointment {
public:
    Appointment();
    Appointment(const Appointment& orig);
    virtual ~Appointment();
    
    
    //I can do it both waaaaays! CODEOPT.h (This causes a little more work, mostly Error checking)
    virtual bool chkOccurance(Date&) = 0;
    
    void setDate(int, int, int);
    void setDate(Date);
    
    void setTime(int, int);
    void setTime(Time);
    
    void setLocation(std::string);
    void setDescription(std::string);
    void setType(std::string);
    
    Date& getDate();
    Time& getTime();
    std::string getLocation();
    std::string getDescription();
    std::string getType();
    
private:
    std::string type;

    Date * date = nullptr; 
    Time * time = nullptr;
    //int repeat;

    std::string location;
    std::string description;
    
};



#endif /* APPOINTMENT_H */

