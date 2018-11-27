/*
 * Menu.h
 *
 *  Created on: 28-Oct-2008
 *      Author: piotr
 */

#ifndef MENU_H_
#define MENU_H_

#include <iostream>
#include <vector>
#include <string>
#include "Runnable.h"

using namespace std;

// Making Menu Runnable allows us to create 
// sub-menus easily... 

// Also in this version:
// MenuItem is now defined *locally* and is private... 

class Menu : public Runnable {
public:
	Menu(string);
	virtual ~Menu();
	void operator() ();
	bool addItem(string, Runnable*);
private:
	class MenuItem {
	public:
		MenuItem(string, Runnable * );
		virtual ~MenuItem();
		const string & show() const;
		void action();
	private:
		string title_;
		Runnable* act_ ;
	};

	string title_;
	vector<MenuItem*> list_;
	void display() const;

	int getSelection(); 

};

#endif /* MENU_H_ */
