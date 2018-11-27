/*
 * QueryAppt.cpp
 *
 *  Created on: Nov 25, 2018
 *      Author: zach
 */

#include "QueryAppt.h"

QueryAppt::QueryAppt(AppointmentBook* apb): apb_(apb) {
	// TODO Auto-generated constructor stub

}

QueryAppt::~QueryAppt() {
	// TODO Auto-generated destructor stub
}

void QueryAppt::operator()(){
	std::vector<Appointment*> foundList = this->apb_->findOnDate(this->queryUser_());
	std::cout << "Found " << foundList.size() << "Appointment(s)" << std::endl;
	std::cout << "==================================" << std::endl;
	for (Appointment* appt : foundList){
		std::cout << "Date: " << appt->getDate().getDay() << "-" << appt->getDate().getMonth() << "-" << appt->getDate().getYear() << std::endl;
		std::cout << "Time: " << appt->getTime().getHour() << ":" << appt->getTime().getMinute() << std::endl;
		std::cout << "Location: " << appt->getLocation() << std::endl;
		std::cout << "Description:" << std::endl << appt->getDescription() << std::endl;
	}
}

Date QueryAppt::queryUser_(){

		std::regex re = std::regex("(\\d\\d)-(\\d\\d)-(\\d\\d\\d\\d)");
		std::string a;
		std::smatch rematch;
		//get User Input, making sure it matches
		while(rematch.empty()){
			std::cout << "Date to query [dd-mm-yyyy] (Type 0 to stop searching):";
			std::cin >> a;
			if (a == "0")
				break;
			std::regex_match(a, rematch, re);
			std::cout << std::endl;
		}
		int day,month,year;
		if(!rematch.empty()){
			day = std::stoi(rematch[1],nullptr, 10);
			month = std::stoi(rematch[2], nullptr, 10);
			year = std::stoi(rematch[3], nullptr, 10);
		}else{
			day, month, year = 0;
		}
		return Date(day, month, year);
}



