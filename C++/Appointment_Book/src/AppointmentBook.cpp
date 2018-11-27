/*
 * AppointmentBook.cpp
 *
 *  Created on: Nov 5, 2018
 *      Author: zach
 */

#include "AppointmentBook.h"
#include "CODEOPT.h"

AppointmentBook::AppointmentBook() {
}

AppointmentBook::~AppointmentBook() {
	for(Appointment* a : this->Appointmentlist){
			delete a;
	}
}


Appointment* AppointmentBook::createAppointment(ApptType value){
	Appointment* a = nullptr;
	try{
		this->Appointmentlist.push_back(a = this->ABfactory->Create(value));
	} catch (int n){
	}
	return a;
}

std::vector<Appointment*> AppointmentBook::findOnDate(Date o){

	std::vector<Appointment*> foundList;
	for(Appointment* appt : this->Appointmentlist){
		if(appt->chkOccurance(o)){
			foundList.push_back(appt);
		}
	}

	return foundList;
}
