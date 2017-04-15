# Tasky
Android app for storing tasks

Task description:

Application uses one simple database for creating some kind of users notes.
User can create note, store it in a database and delete note.
Also, user can have a look at all stored tasks as a list.


Description of program solutions & problems:

*User interface:

Application has 2 layouts. Main layout contains ListView and a Button.
Layout of one item in ListView is defined in seperate .xml file called task_item.xml.
It contains 1 ImageView and 2 TextViews. ImageView is used only for displaying color of task based on a priority.
Colors red,yellow and green are used for displaying the following priorities sequentially: high, normal and low.
One TextView contains task's title and the other one task's text.
Also, main layout has a button which redirects, on a click, to activity for adding new task - NewTask activity.

Layout for NewTask activity has 1 TextView for the title (NEW TASK), 2 EditTexts, Spinner and a Button.
One EditText is used for task's title input, and the other one is used for task's text input.
Spinner contains three possible values: Low, Normal and High.
Layout also has a button for adding task to database. 


*Working with Spinner

Working with spinner is done by adding android:entries attribute in .xml file, because values inside spinner are predefined and there only three of them.
Values are defined in strings.xml in a string-array.


*Task class

Task class contains information about users's tasks such as task's title, task's text, task's priority and task's ID. 
Class has 2 constructors, one with ID and other one without ID argument. 
Constructor with ID argument is used in TaskDBHelper class for adding task in database so that it has ID.
Constructor without ID argument is used in MainActivity when a user's input is processed and a Task object is created based on that input.


*Working with ListView

Working with ListView required couple of things. First it was neccessary to put ListView container in main layout.
After that I created Task class which contains information about task, and a task_item.xml file which represents a layout for one item in the ListView.
In MainActivity a ListView object is created and connected with associated ID.
To the ListView object an TaskAdapter was set. TaskAdapter is class that extends BaseAdapter class and overrides its functions. 
Also, in MainActivity, I created ArrayList of Tasks and called function loadTasks() which returns ArrayList of tasks from database by calling function getAllTasks().
Function getAllTasks() is defined in class written for working with database - TaskDBHelper.

Source: https://loomen.carnet.hr/pluginfile.php/775479/mod_resource/content/1/LV3%20-%20predlo%C5%BEak%282017%29.pdf


*TaskAdapter Class

TaskAdapter class extends BaseAdapter class and overrides functions: getCount(), getItem(), getItemId(), and getView().
In a getView() function View object is returned. Function uses ViewHolder object for setting Tag on returned View object.
If an object is null, it inflates task_item layout. 
TaskAdapter class also has functions insert() and deleteAt() for adding and removing item in a ListView.
After changing ListView's look functions notify that dataset was changed.

Source: https://loomen.carnet.hr/pluginfile.php/775479/mod_resource/content/1/LV3%20-%20predlo%C5%BEak%282017%29.pdf


*TaskDBHelper Class

TaskDBHelper extends SQLiteOpenHelper class and overrides functions: onCreate(), onUpgrade().
Similat to TaskAdapter class, TaskDBHelper class also has functions insertTask() and deleteTask().
Function insertTask() uses ContentValues object and with put method all neccessary information about task which is being stored is stored in that object.
Using insert method from SQLiteDatabase class that ContentValue object is stored in database defined by information in class Schema.
Schema is inner class in TaskDBHelper class that contains information about database.
Function deleteTask() uses SQLiteDatabase method delete to delete task with a corresponding ID. Function has argument of type Task so by using getID() method, function knows ID of the task.

Class also has getAllTasks() function which returns ArrayLists of tasks stored in database. 
By using Cursor object raw query is performed on a database and then obtained values are parsed to appropriate data types using moveToFirst() and moveToNext() methods. 
That parsed values are stored in Task object by calling constructor with and ID. 

Source: https://loomen.carnet.hr/pluginfile.php/775479/mod_resource/content/1/LV3%20-%20predlo%C5%BEak%282017%29.pdf



