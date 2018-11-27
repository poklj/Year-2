/*
 * Menu.cpp
 *
 *  Created on: 28-Oct-2008
 *      Author: piotr
 */

#include "Menu.h"

Menu::Menu(string s)
: title_(s)
{
}

Menu::~Menu() {
        // MenuItems  are assumed to be created dynamically
        // and are deleted here:
	for (unsigned i=0; i<list_.size(); i++)
		delete list_[i];
}

bool Menu::addItem(string s, Runnable * p)
{
	list_.push_back(new Menu::MenuItem(s,p));
	return true;
}

void Menu::operator() ()
{
	int j;
	display();
	while ((j=getSelection())) {
		list_[j-1]->action();
		display();
	}
}
int Menu::getSelection() 
{
	unsigned foo;
	char c;
		while (true) {
			if (cin >> foo) {
				if ( foo < 0 or foo > list_.size()) {
					cout << "Can't you read pal!? " << endl;
					cout << "This menu'd got " << list_.size() << " items!" << endl;
				}
				else
				return foo;
			}
			else {
				cin.clear();
				cout << "Bad Selection. Input " ;
				while ((c=cin.get()) != '\n' )
					cout << c;
				cout << " ignored. " << endl;
			}

			cout << "Please, reenter now: ";

		}
}


void Menu::display() const{
	cout << "\n\n\t\t\t" << title_ << "\n" << endl;

	for (unsigned i = 0 ; i < list_.size() ; i++)
		cout << "\t\t" << i+1 <<".  " << list_[i]->show() << endl;

	cout << "\t\t0.  Exit." << "\n" << endl;
	cout << "Select: " ;
}


Menu::MenuItem::MenuItem(string s, Runnable * p )
:title_(s), act_(p)
{
}

Menu::MenuItem::~MenuItem() {
	delete act_;
}

const string & Menu::MenuItem::show() const
{
	return title_;
}

void Menu::MenuItem::action()
{
	(*act_)();
}


