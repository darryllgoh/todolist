newTaskForm.addEventListener('submit', (event) => {


   // Prevent default action of the form submission
   event.preventDefault();
   //1) Select the inputs
   const title = document.querySelector('#title').value;
   const description = document.querySelector('#description').value;
   const date = document.querySelector('#date').value;

    //change from string to Date
   var dt = new Date(date);

   /* 2)
       Do the Validation code here
   */


   // 3) Add the task to the task manager
   addTask(title, description, dt); // arguments


});


var today = new Date();
var dd = String(today.getDate()).padStart(2, '0');
var mm = String(today.getMonth() + 1).padStart(2, '0');
var yyyy = today.getFullYear();

today = yyyy + '-' + mm + '-' + dd;
$(document.querySelector('#date')).attr('min',today);
