if(!principal){
    window.location.href="./index.html";
}
// else{
//     getTasks();
// }


// let approvebtn = document.getElementById('approve');
// approvebtn.addEventListener('click', approveF);
// function approveF(){
//     console.log('approved');
// }
let refreshtasks = document.getElementById('refresh');
refreshtasks.addEventListener('click', getTasks1);
let infobtn = document.getElementById('info');
infobtn.addEventListener('click', getTasks);

async function getTasks(){

    let response =await fetch (`${apiUrl}/reimbursement`, {

    });
    if (response.status==200){
        let data = await response.json();
      
console.log(data)

        populateTable1(data);
    }else {
        console.log("Cann't get");
    }
}

function populateTable1(data){
    let tableBody = document.getElementById('tasks-tbody');

    data.forEach(task =>{
        let tr = document.createElement('tr');
        var tdId = document.createElement('td');
        let tdDes= document.createElement('td');
        let tdSubDate = document.createElement('td');
        let tdamount= document.createElement('td');
        let tdStatus = document.createElement('td');
        let tdAuthor = document.createElement('td');

       // let tdAction= document.createElement('td');

        tdId.innerHTML= task.reimb_Id;
        tdDes.innerHTML= task.description;
        tdSubDate.innerHTML= new Date(task.submitted).toLocaleDateString();
        tdamount.innerHTML= '$'+task.amount;
        tdStatus.innerHTML= task.status;
        tdAuthor.innerHTML= task.reimb_author.username;
        

       // tdAction.innerHTML='<button Type="button" id = "approve" >Approve</button>';


        tr.append(tdId);
        tr.append(tdDes);
        tr.append(tdSubDate);
        tr.append(tdamount);
        tr.append(tdStatus);
        tr.append(tdAuthor);
       // tr.append(tdAction);

        tableBody.append(tr);


    })

    document.getElementById('info').disabled=true;
}





async function getTasks1(){

    let response =await fetch (`${apiUrl}/reimbursement`, {

    });
    if (response.status==200){
        let data = await response.json();
      
console.log(data)

        populateTable2(data);
    }else {
        console.log("Cann't get");
    }
}

function populateTable2(data){
    let tableBody = document.getElementById('tasks-tbody');

    data.forEach(task =>{
        let tr = document.createElement('tr');
        var tdId = document.createElement('td');
        let tdDes= document.createElement('td');
        let tdSubDate = document.createElement('td');
        let tdamount= document.createElement('td');
        let tdStatus = document.createElement('td');
        let tdAuthor = document.createElement('td');

       // let tdAction= document.createElement('td');

        tdId.innerHTML= task.reimb_Id;
        tdDes.innerHTML= task.description;
        tdSubDate.innerHTML= new Date(task.submitted).toLocaleDateString();
        tdamount.innerHTML= '$'+task.amount;
        tdStatus.innerHTML= task.status;
        tdAuthor.innerHTML= task.reimb_author.username;
        

       // tdAction.innerHTML='<button Type="button" id = "approve" >Approve</button>';


        tr.append(tdId);
        tr.append(tdDes);
        tr.append(tdSubDate);
        tr.append(tdamount);
        tr.append(tdStatus);
        tr.append(tdAuthor);
       // tr.append(tdAction);

        tableBody.append(tr);


    })

   // document.getElementById('refresh').disabled=true;
}

