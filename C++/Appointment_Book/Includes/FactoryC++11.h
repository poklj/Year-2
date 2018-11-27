/*
 *
 * Based on the code by Andrei Alexandrescu
 * published in "Modern C++ Design"
 *
 * Adapted by PWP.
 *
 * C++11 Version.
 *
 */

#ifndef FACTORY_H_
#define FACTORY_H_

#include <string>
#include <map>
#include <stdexcept>
#include <sstream>


template <typename T, typename K>
class Factory
{
public:
        static Factory * Instance()  // Yes, a singleton...
        {
                if ( ! one_Instance_ )
                        one_Instance_ = new Factory{};
                return one_Instance_;
        }

        Factory(const Factory&) = delete;
        ~Factory() = delete;
        Factory& operator= (const Factory&) = delete;
        
        typedef T * (*CreateFunctionPtr)();

        bool Register(K, CreateFunctionPtr);
        bool Unregister (K);
        T * Create(K); 
        std::string listTypes (char = ' ');

private:
        static Factory * one_Instance_;
        typedef std::map<K, CreateFunctionPtr> Catalogue;
        Catalogue cat_;
        
        // Constructor must remain private:
        Factory() = default;
};


template <class T, class K>
Factory<T, K> * Factory<T, K>::one_Instance_(nullptr);  // 'cause is static!

template <class T, class K>
bool Factory<T, K>::Register(K PTid, CreateFunctionPtr CreateF)
{
        // Ah! This returns the second element...  of the pair returned
        // by insert(!) Such a pair contains: an iterator, and a bool (!) ;
        // the former points to the the pair just inserted, if all went well;
        // the latter indicates, if the insert was successful
        return cat_.insert(typename Catalogue::value_type(PTid, CreateF)).second;
}

template <class T, class K>
bool Factory<T,K>::Unregister (K PTid)
{
        return cat_.erase(PTid) == 1;
}

template <class T, class K>
T * Factory<T,K>::Create(K devId)
{
		typename Catalogue::const_iterator i = cat_.find(devId);
        if ( i == cat_.end()) {
		std::ostringstream os{};
        	os << devId;
                throw std::logic_error( std::string("Unknown type ")+os.str());
	}
        return (i->second)();
}

template <class T, class K>
std::string Factory<T,K>::listTypes (char sep)
{
	std::ostringstream os{};
	for (auto i=cat_.begin(); i!=cat_.end(); i++)
		os << i->first << sep ;

	return os.str();

}

#endif /*FACTORY_H_*/


/* An efficient use of this Factory requires that any new type to be produced
 * will "self-register" (??!), rather leaving this to a prospective user...
 * Adding the following at the bottom of the new type's .cpp file will 
 * do the job:

 !!! Note: T and K must be replace by the actual types used!

#include "Factory.h"
namespace {
   T * Create()
   {
        return new <a type *derived* from T>;
   }

   const bool reg=Factory<T,K>::Instance()->Register(<A const of type K>, Create);
}

*/
