var mainAPI= 'https://pokeapi.co/api/v2/pokemon';
document.querySelector('#search').addEventListener("click", getPokemon);
document.querySelector('#show').addEventListener('click', getPokemon1);


function getPokemon(){

    const name = document.querySelector('#pokemonName').value;
    
    fetch(`${mainAPI}/${name}`).then ((response) => response.json()).then((data)=>{
        document.querySelector(".pokemonBox").innerHTML= `
        <div>
        <img 
        src="${data.sprites.other["official-artwork"].front_default}" 
        alt="${data.name}" width="15%" />
    
    </div>
    <div class="pokemonInfo">
        <h1>
            ${data.name}
        </h1>
        <p>
            ${data.name}
        </p>
    </div>
       `

    });
}

function getPokemon1(){
    const name = document.querySelector('#pokemonName').value;

    fetch(`${mainAPI}/${name}`).then ((response) => response.json()).then((data)=>{
        document.querySelector(".ptable").innerHTML=`
        <table >
                <tr>
                    <th>Name</th>
                    <th>Ability</th>
                    <th>Weight</th>
                    <th>icon</th>
                </tr>
                <tr>
                    <td>${data.name} </td>
                    <td>${data.abilities["0"].ability.name} </td>
                    <td>${data.weight} </td>
                    <td><img width="30px" src="${data.sprites.other["official-artwork"].front_default}" /> </td>
                </tr>

            </table>

        
        
        
        `
    });
    
}