//imposto saluto in base all'ora
let contenitore = document.querySelector('h1');
        const ora = new Date().getHours();
        console.log(ora);

        function generaSaluto(orario){
     if (orario < 5) {
            contenitore.innerText = 'Buonanotte';
        } else if(orario < 12) {
            contenitore.innerText = 'Buongiorno';
        }else if(orario < 19) {
            contenitore.innerText = 'Buon Pomeriggio';
        }else{
            contenitore.innerText = 'Buonasera';
        }
    }
    window.addEventListener(onload, generaSaluto(ora));

    //cambiare colore del cuore al click
    let botthoni = document.querySelectorAll('.btn');
    console.log(botthoni);
    for (let i = 0; i < botthoni.length; i++) {       
        localStorage.setItem(`btn${i}`, "disattivo");
        botthoni[i].addEventListener("click", () => {           
            if(localStorage.getItem(`btn${i}`) == "attivo"){
                localStorage.setItem(`btn${i}`, "disattivo");
                botthoni[i].setAttribute('style','color: #000');
                console.log("disattivo");
            }
            else if(localStorage.getItem(`btn${i}`) == "disattivo"){   
                localStorage.setItem(`btn${i}`, "attivo");
                botthoni[i].setAttribute('style','color: #008000');
                console.log("attivo");
            }                                            
        })
        
    }


