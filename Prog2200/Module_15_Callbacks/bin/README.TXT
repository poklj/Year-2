
Implementing callbacks in Java.

These samples show how to declare an interface 
with a method, and then use that method as a callback
from another class.

The calling class and call-ie don't "know" about each 
other, except that someone (main line, or other)
needs to register the callie with the caller.

More than one caller is possible, calling one callback.

More than one callback is possible, as more classes 
can implement the callback interface.
