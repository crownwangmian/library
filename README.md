1.	Date and Time Formatting:
o	The date and time displayed when books are added appear in a default format that is not very user-friendly. The program currently outputs the date in its raw form, which might be difficult to read.
**A:  Using SimpleDateFormat to format time**

2.	Search Method:
o	The search functionality only works with a book's title but might not handle searches by price properly. Additionally, there could be issues with method overloading when searching by different data types.
**A: Implementing method overloading through try catch**

3.	Sorting Issues:
o	While sorting by price and title works in theory, the sorting algorithm might not always behave as expected. There could be problems with how the sorting algorithms swap elements or handle book data.
**A: The title needs to ignore upper and lower case, and the price needs to adjust the precision of decimals.**

4.	Book Count:
o	The program keeps track of the total number using a static variable. However, there may be issues with the count not updating correctly, especially when adding eBooks.
**A: Currently, no problems have been found because both book and ebook are created through parameterized constructors, and neither book nor ebook has a parameterless constructor, so the total number of books will automatically increase.**

5.	Lack of a Switch Menu:
o	The program lacks an interactive menu where users can easily switch between different actions such as adding a book, sorting, or searching. Although the main methods are implemented, the program does not have an intuitive interface for users to choose actions. 
**A: Done**

6.	Generics Missing:
o	The program could benefit from the use of generics for handling collections more efficiently, but this is not currently implemented.
**A: Because ebook inherits book, both book and Ebook can be stored in the list collection, so no place to use Generics is found. However, there is a design problem here, that is, the relationship between book and Ebook. Book and ebook are not peers, just like dogs and huskies. All huskies are dogs, but all dogs are not huskies.**
