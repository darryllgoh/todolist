/*
    taskController perform action to the tasks to be displayed

    (1) Display all tasks to be retrieved from the back-end
    (2) Add task to the task list (send the new project to the back-end)
    --- edit an existing task
    -- remove an existing task from the customer list
*/

//development APIs
const addAPI= 'http://localhost:8080/item/add';
const displayAPI = 'http://localhost:8080/item/all';
let taskController = [];

function displayTask()
{
taskController = [];
//fetch data from database using the REST API endpoint from Spring Boot
       //GET http method is a default
       fetch(displayAPI)
           .then((resp) => resp.json())
           .then(function(data) {
               console.log("2. receive data")
               console.log(data);
               data.forEach(function (item, index) {

                   const itemObj = {
                       id: item.id,
                       title: item.title,
                       description: item.description,
                       date: item.date

                  };

                   //array of the objects
                   taskController.push(itemObj);
             });
             //display all customers from the customerController array
             renderTaskPage();

           })
           .catch(function(error) {
               console.log(error);
           });
}

//(3)  Display all customers when user launch the index.html page
//const displayCustomer = () => {
function renderTaskPage() {

    let display = "<tr><th>Title</th><th>Description</th><th>Target Date</th></tr>";

        for (let j = 0; j < taskController.length; j++) {

        display += `
                    <tr><td>${taskController[j].title}</td>
                    <td>${taskController[j].description}</td>
                    <td>${taskController[j].date}</td></tr>
        `
    };

    //End of renderCustomerPage function
    document.querySelector("#table").innerHTML = display;

}

function addTask(title, description, dt) { //date
    const formData = new FormData();
    formData.append('title', title);
    formData.append('description', description);
    formData.append('date', dt); //date

    fetch(addAPI, {
            method: 'POST',
            body: formData
            })
            .then(function(response) {
                console.log(response.status); // Will show you the status
                if (response.ok) {
                    alert("Successfully Added Task!")
                    document.getElementById("newTaskForm").reset();
                }
                else {
                   alert("Something went wrong. Please try again")
                }
            })
            .catch((error) => {
                console.error('Error:', error);
                alert("Error adding task")
            });
}
