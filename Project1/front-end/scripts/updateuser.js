let createUserbtn = document.getElementById('submituser');
createUserbtn.addEventListener('click', createUser);
let apiUrl="http://localhost:8081/task-manager";


async function createUser(){

    let userid= document.getElementById('userid').value;
    let username= document.getElementById('nusername').value;
    let passed=document.getElementById('npassword').value;
   
   
   

    let response = await fetch(`${apiUrl}/employee`, {
        method: 'PUT',
       // credentials: 'include',
     
        headers: {
           'Content-Type': 'application/x-www-form-urlencoded',
            'Accept':   '*'
        
        },
        body: JSON.stringify({
            "id": `${userid}`,
            "username": `${username}`,
            "password": `${passed}`,
          
         
            

        })
    });

    if (response.status== 201){
        window.alert('User Updated Successfully');
        document.getElementById('userid').innerHTML.value="";
        
    }else (
        window.alert('Unable to Update User')
    )


}