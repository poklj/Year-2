/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Zachary Higgs
 *
 * Created on November 1, 2018, 9:19 PM
 */

#include <cstdlib>
#include <iostream>

#include "Date.h"
#include <iostream>
#include <regex>
#include "AppointmentMenus.h"

int main(int argc, char** argv) {
	CLI::AppointmentMenus* am = new CLI::AppointmentMenus();

	delete am;
}

