let apbtn =document.getElementById('accept');
let rjbtn = document.getElementById('reject');
//let apiUrl="http://localhost:8081/task-manager"

//let inputfield = document.getElementById('reimbId');
//let approve = 'Approved';


apbtn.addEventListener('click', GetTasksByID);
rjbtn.addEventListener('click', RejectReimbursement);


async function GetTasksByID (){
    let inputfield = document.getElementById('reimbId').value;
    let tabblebody = document.getElementById('tasksid-tbody');
    let response = await fetch (`${apiUrl}/reimbursement/${inputfield}`,{

    });
    if (response.status==200){
        let data = await response.json();

      var row = `<tr>
      <td>${data.reimb_Id}</td>
      <td>${data.decription}</td>
      <td>${new Date(data.submitted)}</td>
      <td>${data.amount}</td>
      <td>${data.status}</td>
      <td>${data.reimb_author.username}</td>
      
      </tr>`
   
//tabblebody.innerHTML=row;

    if (inputfield == data.reimb_Id){
        window.alert('Request Approved!')
        let response1 = await fetch(`${apiUrl}/reimbursement`,{
            method: 'PUT',
            headers : {
                'Content-Type': 'application/x-www-form-urlencoded',
            'Accept':   '*'
            },
        body: JSON.stringify({

            "reimb_Id": `${data.reimb_Id}`,
            "status": "Approved",
            "amount":`${data.amount}`,
            "descripion": `${data.descripion}`,
            "author": {
                "id": `${data.reimb_author.id}`
            }

        })

        })


    }else {
        console.log("dont mathc");
    }
    
    
}
    else {
        window.alert('cannot get date');

    }



}

 



























function RejectReimbursement(){
    console.log('Reject');

}