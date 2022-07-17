let welcomeH1 = document.getElementById('welcome');
let username = principal.username;





if(principal.role=="ADMIN"){
    welcomeH1.innerHTML = `Welcome` +  ` Admin`;
} else{
    welcomeH1.innerHTML = `Welcome ` +  username;
}

