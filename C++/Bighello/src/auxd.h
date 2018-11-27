/*
 * aux.h
 *
 *  Created on: Sep 10, 2018
 *      Author: zach
 */

#ifndef AUX_H_
#define AUX_H_

//void print(double[], int);
//void print(int[], int);

template <class T>

void print(T a[], int s){
	for (int i = 0; i<s; i++){
			std::cout << *a++ << ' ';
		}
		std::cout << std::endl;
}

#endif /* AUX_H_ */
