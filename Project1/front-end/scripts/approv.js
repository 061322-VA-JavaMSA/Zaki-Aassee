let apbtn =document.getElementById('accept');
let rjbtn = document.getElementById('reject');
//let apiUrl="http://localhost:8081/task-manager"

apbtn.addEventListener('click', ApproveReimbursements);
rjbtn.addEventListener('click', RejectReimbursement);


async function ApproveReimbursements (){
    let inputfield = document.getElementById('reimbId').value;
    let tabblebody = document.getElementById('tasksid-tbody');
    let response = await fetch (`${apiUrl}/reimbursement/${inputfield}`,{

    });
    if (response.status==200){
        let data = await response.json();
    //   var row = `<tr>
    //   <td>${data.reimb_Id}</td>
    //   <td>${data.decription}</td>
    //   <td>${new Date(data.submitted)}</td>
    //   <td>${data.amount}</td>
    //   <td>${data.status}</td>
    //   <td>${data.reimb_author.username}</td>
    //   </tr>`
   // Could storre them in variables instead of table
//tabblebody.innerHTML=row;

          if (inputfield == data.reimb_Id){
        
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
            "sub_Date": `${data.submitted}`,
            "descripion": `${data.description}`,
            "author": {
                "id": `${data.reimb_author.id}`
            }


        })

        })
            if(response1.status==201){
                window.alert("Reimbursement Approved!")

            }
            //    window.alert('Request Approved!')
        }else {
               window.alert('Wrong Selection')
               }
            } else {
                window.alert('cannot get date');
        }

  



}

 





async function RejectReimbursement(){
   

    let inputfield = document.getElementById('reimbId').value;
    let tabblebody = document.getElementById('tasksid-tbody');
    let response = await fetch (`${apiUrl}/reimbursement/${inputfield}`,{

    });
    if (response.status==200){
        let data = await response.json();
  
          if (inputfield == data.reimb_Id){
        
           let response1 = await fetch(`${apiUrl}/reimbursement`,{
            method: 'PUT',
            headers : {
                'Content-Type': 'application/x-www-form-urlencoded',
            'Accept':   '*'
            },
            body: JSON.stringify({

            "reimb_Id": `${data.reimb_Id}`,
            "status": "Rejected",
            "amount":`${data.amount}`,
            "sub_Date": `${data.submitted}`,
            "descripion": `${data.description}`,
            "author": {
                "id": `${data.reimb_author.id}`
            }

        })

        })
            if(response1.status==201){
                window.alert("Reimbursement Rejected!")

            }
            //    window.alert('Request Approved!')
        }else {
               window.alert('Wrong Selection')
               }
            } else {
                window.alert('cannot get date');
        }

  








}