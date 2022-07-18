
let apiUrl = 'http://localhost:8081/task-manager';

let principalString = sessionStorage.getItem('principal');
let principal = null;

let nav_right = document.getElementById("nav-right");
let nav_left = document.getElementById("nav-left");

if (principalString) {
   
    principal = JSON.parse(principalString);

    if (principal.role === 'ADMIN') {
        createNavElement('Users', nav_left, './users.html', null);
        createNavElement('Tasks', nav_left, './tasks.html', null);
        createNavElement('Create Users', nav_left, './newuser.html', null);
        createNavElement('TasksByID', nav_left, './tasksbyid.html', null);
         createNavElement('Logout', nav_right, null, logout);
  
        } else {
            createNavElement('New Request', nav_left, './request.html', null);
            createNavElement('My Requests', nav_left, './myrequests.html', null);
            createNavElement('Update My Info', nav_left, './updateuser.html', null);
           // createElement(principal.role, nav_right );
            createNavElement('Logout', nav_right, null, logout);
        }
} 
else {
    createNavElement('Login', nav-right, './login.html', null);

}

async function logout() {

    // Sends a DELETE request to API to invalidate session
    let response = await fetch(`${apiUrl}/auth`, {
        method: 'DELETE',
        // credentials: 'include'
    });

    if (response.status == 200) {
        // clears user object JSON string in session storage
        sessionStorage.clear();
        // clears principal variable representing logged in user
        principal = null;
        window.location.href="./index.html";
    } else {
        console.log('Unable to logout.')
    }
}

// Reusable function to create nav element in navbar
function createNavElement(innerHTML, parentElement, link, callback) {
    let li = document.createElement('li');
    // bootstrap class for styling
    li.setAttribute('class', 'nav-item');

    let a = document.createElement('a');
    // bootstrap class for styling
    a.setAttribute('class', 'nav-link');

    // if a link to a different page has been assigned, assign that link
    if (link) {
        a.setAttribute('href', link);
    } else {
        a.setAttribute('href', '#');
    }

    // if a callback function was passed in, assigns that function to the new element
    if (callback) {
        a.addEventListener('click', callback);
    }

    // Assigns nav-bar item name
    a.innerHTML = innerHTML;

    li.appendChild(a);

    parentElement.appendChild(li);
}