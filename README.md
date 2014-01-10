MVC Android slot machine ListView Example
==============================================


This is for showing a MVC model idea in Android UI development.

## Model
In package [org.ratpoisonfactory.slotListviewmvc.model](https://github.com/comperge/MVC-mode-Android-slot-machine-ListView-Example/tree/master/src/org/ratpoisonfactory/slotListviewmvc/model)
There is a [ModelCreator.java](https://github.com/comperge/MVC-mode-Android-slot-machine-ListView-Example/blob/master/src/org/ratpoisonfactory/slotListviewmvc/model/ModelCreator.java) which is a dummy data files. Yes, you can replace it to Xml,JSON parser or something else. Whatever it is, Notion of model here is bringing data from somewhere and make it nicer to use (or not). I assume data is packed in traditional JavaBean which is [BcInfoBean.java](https://github.com/comperge/MVC-mode-Android-slot-machine-ListView-Example/blob/master/src/org/ratpoisonfactory/slotListviewmvc/model/BcInfoBean.java). Most of bean members do not have setter methods.

##View
This example composed of three fragments. [TopView](https://github.com/comperge/MVC-mode-Android-slot-machine-ListView-Example/tree/master/src/org/ratpoisonfactory/slotListviewmvc/view/top) fragment which is for Title, [Center](https://github.com/comperge/MVC-mode-Android-slot-machine-ListView-Example/tree/master/src/org/ratpoisonfactory/slotListviewmvc/view/center) fragment for message screen and a Listview [bottom](https://github.com/comperge/MVC-mode-Android-slot-machine-ListView-Example/tree/master/src/org/ratpoisonfactory/slotListviewmvc/view/bottom). We know, a fragment is a view and decorates UI and gives connection between .java code and .xml View.

##Control
Each View fragments are related with Controller class. For example here [bottom](https://github.com/comperge/MVC-mode-Android-slot-machine-ListView-Example/tree/master/src/org/ratpoisonfactory/slotListviewmvc/view/bottom), [BottomControl.java](https://github.com/comperge/MVC-mode-Android-slot-machine-ListView-Example/blob/master/src/org/ratpoisonfactory/slotListviewmvc/view/bottom/BottomControl.java). 
###What Controller do?
Controller brings Data from model and send to Views.
Controller dose control a UI(View) events and return event results to the UI or othre UI(UIs).
 - Most of UI events require Data alteration such typical Database actions, select, insert, update and delete. 
 - and sometime, view events have to call other Views action. 
Controller handle such data related works and other View actions. However, I believe simple event callings should be done in Views. For example, popping up alert windows, or Text color changing. More importantly If the action dose not require any data(Model) handling. just DO IT in View area.
##Event Calling.

  
