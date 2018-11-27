/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   newClass.cpp
 * Author: user
 * 
 * Created on November 2, 2018, 1:36 AM
 */

#include "newClass.h"
#include <cstdlib>
#include <iostream>

using namespace std;
newClass::newClass(int i):
a(i){
    std::cout << i << std::endl;
}

newClass::newClass(const newClass& orig) {
}

newClass::~newClass() {
}

