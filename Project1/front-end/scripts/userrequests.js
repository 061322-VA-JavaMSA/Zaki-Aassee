if(!principal){
    window.location.href="./index.html";
}

// else{
//     getTasks();
// }



let infobtn = document.getElementById('info');

infobtn.addEventListener('click', getTasks);




async function getTasks(){

    let response =await fetch (`${apiUrl}/reimbursement`, {

    });
    if (response.status==200){
        let data = await response.json();
       
        populateTable1(data);
    }else {
        console.log("Cann't get");
    }
}

function populateTable1(data){
    let tableBody = document.getElementById('tasks-tbody');


 
    data.forEach(task =>{
        let tr = document.createElement('tr');
        let tdId = document.createElement('td');
        let tdDes= document.createElement('td');
        let tdSubDate = document.createElement('td');
        //let tdResDate= document.createElement('td');
        let tdStatus = document.createElement('td');
        let tdAuthor = document.createElement('td');
       
        tdId.innerHTML= task.reimb_Id;
        tdDes.innerHTML= task.description;
        tdSubDate.innerHTML= new Date(task.submitted).toDateString();
        //tdResDate.innerHTML= new Date(task.resolved).toLocaleDateString();
        tdStatus.innerHTML= task.status;
        tdAuthor.innerHTML= task.reimb_author.username;
       
    

        tr.append(tdId);
        tr.append(tdDes);
        tr.append(tdSubDate);
        //tr.append(tdResDate);
        tr.append(tdStatus);
        tr.append(tdAuthor);
       

        tableBody.append(tr);
    

    })
    
    document.getElementById('info').disabled=true;
}

