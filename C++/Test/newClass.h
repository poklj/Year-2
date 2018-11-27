/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   newClass.h
 * Author: user
 *
 * Created on November 2, 2018, 1:36 AM
 */

#ifndef NEWCLASS_H
#define NEWCLASS_H
#include <cstdlib>

using namespace std;


class newClass {
public:
    newClass(int);
    newClass(const newClass& orig);
    virtual ~newClass();
private:
    int a;
};

#endif /* NEWCLASS_H */

