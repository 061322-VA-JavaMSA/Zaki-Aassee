let welcomeH1 = document.getElementById('welcome');
var loggedUser = principal.username;





if(principal.role=="ADMIN"){
    welcomeH1.innerHTML = `Welcome` +  ` Admin`;
} else{
    welcomeH1.innerHTML = `Welcome ` + loggedUser ;
}

