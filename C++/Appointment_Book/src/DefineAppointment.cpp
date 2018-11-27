/*
 * DefineAppointment.cpp
 *
 *  Created on: Nov 22, 2018
 *      Author: zach
 */

#include "DefineAppointment.h"
using namespace std;
namespace CLI {

DefineAppointment::DefineAppointment(Appointment* appt): appt_(appt) {

}

DefineAppointment::~DefineAppointment() {
	// TODO Auto-generated destructor stub
}
void DefineAppointment::operator() (){
	this->defineDate();
	this->defineTime();
	this->defineLocation();
	this->defineDescription();
}

void DefineAppointment::defineDate(){
	std::regex re = std::regex("(\\d\\d)-(\\d\\d)-(\\d\\d\\d\\d)");
	std::string a;
	std::smatch rematch;
	//get User Input, making sure it matches
	while(rematch.empty()){
		std::cout << "Set Date [dd-mm-yyyy]:";
		std::cin >> a;
		std::regex_match(a, rematch, re);
		std::cout << std::endl;
	}
	int day = std::stoi(rematch[1],nullptr, 10);
	int month = std::stoi(rematch[2], nullptr, 10);
	int year = std::stoi(rematch[3], nullptr, 10);
	//We know that the match should only go up to four (0-3)
	appt_->setDate(day, month,year);
}

void DefineAppointment::defineTime(){
	std::regex re = std::regex("(\\d\\d):(\\d\\d)");
	std::string a;
	std::smatch rematch;
	while(rematch.empty()){
			std::cout << "Set Time [hh:mm]:";
			std::cin >> a;
			std::regex_match(a, rematch, re);
	}

	int hour = std::stoi(rematch[1],nullptr, 10);
	int minute = std::stoi(rematch[2],nullptr,10);
	appt_->setTime(hour, minute);
}

void DefineAppointment::defineLocation(){
	std::string a;
	while(a.empty()){
		std::cout << "Set Location:";
		std::cin >> a;
	}
	appt_->setLocation(a);
}

void DefineAppointment::defineDescription(){
	std::string a;
	std::string b = " ";
	std::cout << "Set Description(Enter twice to end): " <<std::endl;
	std::getline(std::cin, b);
	while(true){
		std::getline(std::cin, b);
		if(b.empty())
			break;
		a.append(b+"\n");
	}
	appt_->setDescription(a);
}

} /* namespace CLI */
