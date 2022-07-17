let reqsubmit = document.getElementById('submitButton');


reqsubmit.addEventListener('click', request);

let apiUrl="http://localhost:8081/task-manager";

async function request(){
    let rid=document.getElementById('rid').value;
    let rt= document.getElementById('rtype').value;
    let ra=document.getElementById('ramount').value;
    let rd = document.getElementById('rdate').value;
    let rdes = document.getElementById('rd').value;
    let requestor = document.getElementById("authorid").value;

    //let author =1;


    console.log('request');

    let response = await fetch (`${apiUrl}/reimbursement`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: JSON.stringify({
            "reimb_Id":`${rid}`,
            "descripion": `${rdes}`,
            "amount": `${ra}`,
            "sub_Date": `${rd}`,
            "receipt": `${rt}`,
            "author":{
                "id": `${requestor}`}
            })

    }); 


    if (response.status == 201){
       // console.log('created');
       window.alert('created');
       window.location.href="./request.html";

    } else {
        window.alert("Couldn't Submit Request!")
    }

    


}