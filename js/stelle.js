//facciamo una costante
const stars = document.querySelectorAll(".stars img"); //richiamiamo, con una costante gli elementi stars che abbiamo creato nell'html

stars.forEach((star, clickedIdx) => {       //creamo un callbakc per ogni stella data dall'indice
    star.addEventListener("click", () => {      //aggiungiamo un evento al click   

        stars.forEach((otherStar, otherIdx) => {
            if (otherIdx <= clickedIdx) {           //creamo un secondo index che dirà di bloccare la valutazione data, nel caso dovesse essere ricaricata la pagina 
                otherStar.classList.add("active");
            }
            else {
                otherStar.classList.remove("active");   //cosi anche se volessimo rifare la valutazione, l'index non è solo crescente ma anche decrescente
            }
        });
        console.log(`star of index ${idx + 1} was clicked`);     //in uscità avremo così la stellina cliccata nell'indice

    });
})