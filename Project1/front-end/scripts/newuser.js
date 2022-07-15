let createUserbtn = document.getElementById('submituser');
createUserbtn.addEventListener('click', createUser);
let apiUrl="http://localhost:8081/task-manager";


async function createUser(){

    let userid= document.getElementById('userid').value;
    let username= document.getElementById('username').value;
    let passed=document.getElementById('password').value;
    let firstname = document.getElementById('fname').value;
    let lastname = document.getElementById('lname').value;
    let role = document.getElementById('role').value;

    let response = await fetch(`${apiUrl}/employee`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: JSON.stringify({
            "id": `${userid}`,
            "username": `${username}`,
            "password": `${passed}`,
            "firstname": `${firstname}`,
            "lastname":`${lastname}`,
            "role": `${role}`

        })
    });

    if (response.status== 201){
        window.alert('User Created Successfully');
        document.getElementById('userid').innerHTML.value="";
        
    }else (
        window.alert('Unable to Create New User')
    )


}