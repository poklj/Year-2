/*
 * Project Airport: A sample solution using references.
 * by PWP 
 * The Stats computing class.
 */


#ifndef STAT_H_
#define STAT_H_

class Stat
{
public:
	Stat();
	virtual ~Stat();
	void tally(int);
	unsigned count() const;
	double average() const;
private: 
	unsigned cnt_;
	double total_;
};

#endif /*STAT_H_*/
